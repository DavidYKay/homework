package edu.mccc.ist239.chat;
import java.awt.EventQueue;
import java.util.*;
import java.net.*;
import java.security.*;
import java.math.*;

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
                                } else if (msg.startsWith("file")) {
                                    //Is this the start of the transfer?
                                    //String[] args = msg.split(":");
                                    //String username = args[0];
                                } else {
                                    //send it to them
                                    l.messageReceived(
                                        new ChatClientEvent(
                                            ChatClient.this, 
                                            msg
                                        )
                                    );
                                }
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
    }

    public void login(String username, String ps) {
        MessageDigest m = null;
        try {
            byte[] bytes = ps.getBytes("UTF-8");
            //byte[] bytes = ps.getBytes("ASCII");
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
        try {
        this.socket.send(
            new DatagramPacket(
                message.getBytes(),
                message.length(),
                ipaddr,
                5972
            )
        );
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
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

    //This keeps track of the IM windows and is used to detect when a new 
    //one must be spawned 
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
