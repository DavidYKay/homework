package edu.mccc.ist239.chat;
import java.awt.EventQueue;
import java.util.*;
import java.net.*;
import java.security.*;
import java.math.*;
import java.io.*;

import javax.swing.event.EventListenerList;

import com.cbthinkx.util.Debug;

/**
 * The headless client class
 *
 * Should have three threads by the time we're done: UI Thread, message thread, file thread?
 */
public class ChatClient {
    /** The local socket */
	private DatagramSocket socket;
    /** The server IP address */
	private InetAddress ipaddr;
    private FileThread fileThread;
    public ChatClient(String username, String password, String ip) {
        this(ip);
        login(username, password);
    }
    public ChatClient(String ip) {
        //Use a regular expression to break incoming message into NAME, MESSAGE
        //Note that "hi:" and "bye:" are commands for log on, log off
		try {
			this.ipaddr = InetAddress.getByName(ip);
			this.socket = new DatagramSocket();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
        /**
         * Main thread
         */
		new Thread() {
			public void run() {
				Debug.println("Thread:run()");
				try {
                    //Sit around forever, waiting for packets
					for (;;) {
						DatagramPacket dp = new DatagramPacket(new byte[256], 256);
						socket.receive(dp);
						String msg = new String(dp.getData()).trim();
						Debug.println(msg);
						try {
                            if (msg.startsWith("login")) {
                                String[] args = msg.split(":");
                                if (args[1].equals("true")) {
                                    fireLoginEvent(true);
                                } else {
                                    fireLoginEvent(false);
                                }
                            } else if (msg.startsWith("im")) {
                                String[] args = msg.split(":");
                                String username = args[1];
                                //find the right window
                                ChatClientListener l = chatWindows.get(username);
                                if (l == null) {
                                    ChatPanel cp = new ChatPanel(
                                        ChatClient.this,
                                        username
                                    );
                                    new ChatWindow(
                                        null,
                                        cp
                                    );
                                    cp.messageReceived(
                                        new ChatClientEvent(
                                            ChatClient.this, 
                                            msg
                                        )
                                    );
                                } else {
                                    //send it to them
                                    l.messageReceived(
                                        new ChatClientEvent(
                                            ChatClient.this, 
                                            msg
                                        )
                                    );
                                }
                            } else if (msg.startsWith("file")) {
                                System.out.println("file message received");
                                //file:/home/dk/client_state.xml:/127.0.0.1:45663
                                //Is this the start of the transfer?
                                String[] args = msg.split(":");
                                String username = args[1];
                                String fileName = args[2];
                                String ip = args[3];
                                int port = Integer.parseInt(
                                    args[4]
                                );
                                ip = ip.substring(1);
                                System.out.println("IP: " + ip);
                                System.out.println("Port: " + port);
                                //InetSocketAddress hostSaddr = new InetSocketAddress (ip, port);
                                Socket hostSocket = new Socket(
                                    ip,
                                    port
                                );
                                System.out.println("File Socket Created!");
                                receiveFile(hostSocket, fileName);
                            } else {
                                fireChatClientMessageReceived(msg);
                            }
						} catch (Exception ex) {
							System.err.println(ex.getMessage());
							System.err.println(msg);
						}
					}
				} catch (Exception ex) {
					System.err.println(ex.getMessage());
				}
			}
		}.start();
        fileThread = new FileThread();
        fileThread.start();
    }

    class FileThread extends Thread {
        public static final int MAX_BUFFER_SIZE = 1024; //1 Kb of data
        private ServerSocket serverSocket; 
        public void run() {
            try {
                serverSocket = new ServerSocket(4973);
                //serverSocket = new ServerSocket();
            } catch (IOException e) {
                System.out.println("Could not listen on port: 4973, Listening on port 4974");
                try {
                    serverSocket = new ServerSocket(4974);
                    //break;
                } catch (IOException ioe) {
                    System.out.println("Could not listen on port: 4974, Epic fail");
                }
            }
            for (;;) {
                Socket clientSocket = null;
                try {
                    clientSocket = serverSocket.accept();
                    clientSocket.setSoTimeout(10000);
                } catch (IOException e) {
                    //System.out.println("Accept failed: 4973");
                    //break;
                }
                if (clientSocket != null) {
                    //receiveFile(clientSocket);
                    transferFile(clientSocket);
                }
            }
        }
        public ServerSocket getSocket() {
            return serverSocket;
        }
    }

    public void login(String username, String ps) {
        MessageDigest m = null;
        try {
            //byte[] bytes = ps.getBytes("ASCII");
            byte[] bytes = ps.getBytes("UTF-8");
            m = MessageDigest.getInstance("MD5");
            m.update(bytes, 0, bytes.length);
        } catch (Exception ex) {
            System.err.println("MD5 failed");
        }
        String md5Password = new BigInteger(1, m.digest()).toString(16);
        System.out.println("MD5: " + md5Password);

        //Send to server
        String msg = String.format(
            "hi:%s:%s",
            username,
            md5Password
        );
        sendMessage(msg);
    }

    public void logOut() {
        sendMessage("bye");
    }

    /**
     * Prepends the chat marker and sends the message to the server
     */
    public void sendChatMessage(String message) {
        sendMessage(
            "chat:" + message
        );
    }

    /**
     * Send a private IM to a designated user
     */
    public void sendPrivateMessage(String user, String message) {
        sendMessage(
            String.format(
                "im:%s:%s",
                user,
                message
            )
        );
    }

    /**
     * Send a message to the central server, raw
     */
    public void sendMessage(String message) {
        sendMessage(
            message,
            ipaddr,
            5972
        );
    }

    /**
     * Send a message to the central server, raw
     */
    public void sendMessage(String message, InetAddress ip, int port) {
        try {
            this.socket.send(
                new DatagramPacket(
                    message.getBytes(),
                    message.length(),
                    ip,
                    port
                )
            );
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Notify other client that we're cancelling the transfer
     */
    public void cancelFile(String userName) {
        sendMessage(
            "fileCancel:" + userName
        );
    }

    /**
     * Open a socket and wait
     */
    private void receiveFile(Socket senderSocket, String fileName) {
        System.out.println("receiveFile()");

        DataInputStream  in   = null;
        DataOutputStream dOut = null;
        FileOutputStream fOut = null;
        try {
            //connect to the other client
            in   = new DataInputStream(senderSocket.getInputStream());
            dOut = new DataOutputStream(senderSocket.getOutputStream());
            
            dOut.writeUTF(fileName);
            //String fileName = in.readUTF();
            //pull the file down the wire
            //FileOutputStream out = new FileOutputStream(new File(saveDirectory.getAbsolutePath() + "/" + fileName));
            fileName = fileName + ".new";
            fOut = new FileOutputStream(fileName);

            byte[] buffer = new byte[512];
            int bufRead;
            int totsize = 0;

            while((bufRead = in.read(buffer)) != -1) {
                totsize = totsize + bufRead;
                fOut.write(buffer, 0, bufRead);
            }
            System.out.println("bytes read: " + totsize);
            //EOF exception!
        } catch (Exception ex) {
            System.err.println("receiveFile failed");
            System.err.println(ex.getMessage());
        } finally {
            try {
                dOut.close();
                fOut.close();
                in.close();
                senderSocket.close();
            } catch (Exception ex) {
                //Do nothing
            }
        }
    }

    public void transferFile(Socket outSocket) {
        System.out.println("transferFile()");
            FileInputStream  fin  = null;
            DataOutputStream dOut = null;
            DataInputStream dIn  = null;
        try {
            dOut = new DataOutputStream(outSocket.getOutputStream());
            dIn  = new DataInputStream(outSocket.getInputStream());

            String fileName = dIn.readUTF();
            File file = new File(fileName);
            fin  = new FileInputStream(file);
            long bytes = file.length();
            //dOut.writeUTF(file.getName());

            //dOut.writeUTF(
            //    "size:" + bytes
            //);

            byte[] buffer = new byte[512];
            int bufRead;
            int totsize = 0;

            while((bufRead = fin.read(buffer)) != -1) {
                totsize = totsize + bufRead;
                dOut.write(buffer, 0, bufRead);
            }
            System.out.println("bytes read: " + totsize);
        } catch (Exception ex) {
            System.err.println("transferFile failed");
            System.err.println(ex.getMessage());
        } finally {
            try {
                fin.close();
                dOut.close();
                outSocket.close();
            } catch (Exception ex) {
                //Do nothing
            }
        }
    }

    /**
     * Begin a file transfer request to another client
     */
    public void sendFile(String userName, File file) {
        //Open a socket, wait for one minute
        //notify server that we're waiting
        String msg = String.format(
            //"file:%s:%s",
            //fileSocket.toString(),
            "file:%d:%s:%s",
            fileThread.getSocket().getLocalPort(),
            userName,
            file.getAbsolutePath()
            //file.getName()
        );
        System.out.println("sending file.");
        System.out.println("Message:" + msg);
        sendMessage(
            msg
        );
    }

    //Event Listener code copied from earlier MVC example
	private EventListenerList listenerList = new EventListenerList();
	//public void addChatClientListener(ChatClientListener l) {
	public void addChatClientListener(ChatClientListener l) {
		Debug.println("ChatClient.addChatClientListener()");
		listenerList.add(ChatClientListener.class, l);
	}
	public void removeChatClientListener(ChatClientListener l) {
		Debug.println("ChatClient.removeChatClientListener()");
		listenerList.remove(ChatClientListener.class, l);
	}
    
	public void addChatLoginListener(ChatLoginListener l) {
		Debug.println("ChatLogin.addChatLoginListener()");
		listenerList.add(ChatLoginListener.class, l);
	}
	public void removeChatLoginListener(ChatLoginListener l) {
		Debug.println("ChatLogin.removeChatLoginListener()");
		listenerList.remove(ChatLoginListener.class, l);
	}

	protected void fireChatClientMessageReceived(final String msg) {
		Debug.println("ChatClient.fireChatClientMessageReceived()");
		if (!EventQueue.isDispatchThread()) {
			try {
				EventQueue.invokeAndWait(
					new Runnable() {
						public void run() {
							notifyListeners(msg);
						}
					}
				);
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		} else {
			notifyListeners(msg);
		}
	}

	protected void fireLoginEvent(final boolean success) {
		Debug.println("ChatClient.fireLoginEvent()");
		if (!EventQueue.isDispatchThread()) {
			try {
				EventQueue.invokeAndWait(
					new Runnable() {
						public void run() {
							notifyLogin(success);
						}
					}
				);
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		} else {
			notifyLogin(success);
		}
	}

	private void notifyListeners(String msg) {
		Debug.println("ChatClient.notifyListeners()");
		ChatClientEvent e = new ChatClientEvent(this, msg);
		Object[] listeners = listenerList.getListenerList();
		for (int i = listeners.length - 2; i >= 0; i -= 2) {
			if (listeners[i] == ChatClientListener.class) {
                ((ChatClientListener) listeners[i + 1]).messageReceived(e);
			}
		}
	}

	private void notifyLogin(boolean success) {
		Debug.println("ChatClient.notifyLogin()");
		Object[] listeners = listenerList.getListenerList();
		for (int i = listeners.length - 2; i >= 0; i -= 2) {
			if (listeners[i] == ChatLoginListener.class) {
                ((ChatLoginListener) listeners[i + 1]).loginEvent(success);
			}
		}
	}

	private void notifyTransfer(boolean success) {
		Debug.println("ChatClient.notifyLogin()");
		Object[] listeners = listenerList.getListenerList();
		for (int i = listeners.length - 2; i >= 0; i -= 2) {
			if (listeners[i] == ChatLoginListener.class) {
                ((ChatLoginListener) listeners[i + 1]).loginEvent(success);
			}
		}
	}

    /**
     * This keeps track of the IM windows and is used to detect when a new 
     * one must be spawned 
     */
    private HashMap<String, ChatClientListener> chatWindows = new HashMap<String, ChatClientListener>();
    public void addChatWindow(String buddyName, ChatClientListener l) {
        chatWindows.put(
            buddyName,
            l
        );
    }
    public void removeChatWindow(String buddyName) {
        chatWindows.remove(
            buddyName
        );
    }
}
