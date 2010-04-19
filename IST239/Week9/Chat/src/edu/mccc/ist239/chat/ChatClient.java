package edu.mccc.ist239.chat;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.event.EventListenerList;
import com.cbthinkx.util.Debug;
public class ChatClient {
	//private Map<String, User> users;
    //

	private DatagramSocket socket;
	private InetAddress ipaddr;
	private Pattern p;
    public ChatClient(String username, String ip) {
		this.p = Pattern.compile(
            "(.+):(.+)"
        );

		try {
			String hello = "hi:" + username;
			this.ipaddr = InetAddress.getByName(ip);
			this.socket = new DatagramSocket();
			this.socket.send(
				new DatagramPacket(
					hello.getBytes(),
					hello.length(),
					ipaddr,
					5972
				)
			);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}

		new Thread() {
			public void run() {
				Debug.println("Thread:run()");
				try {
					for (;;) {
						DatagramPacket dp = new DatagramPacket(new byte[256], 256);
						socket.receive(dp);
						String msg = new String(dp.getData()).trim();
						Debug.println(msg);
						Matcher m = p.matcher(msg);
						try {
							m.find();
                            fireChatClientMessageReceived(msg);
							//User user = users.get(m.group(1));
							//user.setSpeed(
							//	Double.parseDouble(m.group(2))
							//);
							//jp.repaint();
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
	private EventListenerList listenerList = new EventListenerList();
	public void addChatClientListener(ChatClientListener l) {
		Debug.println("ChatClient.addChatClientListener()");
		listenerList.add(ChatClientListener.class, l);
	}
	public void removeChatClientListener(ChatClientListener l) {
		Debug.println("ChatClient.removeChatClientListener()");
		listenerList.remove(ChatClientListener.class, l);
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
	private void notifyListeners(String msg) {
		Debug.println("ChatClient.notifyListeners()");
		//ChatClientEvent e = new ChatClientEvent(this, msg);
		ChatClientEvent e = new ChatClientEvent(this, msg);
		Object[] listeners = listenerList.getListenerList();
		for (int i = listeners.length - 2; i >= 0; i -= 2) {
			if (listeners[i] == ChatClientListener.class) {
                ((ChatClientListener) listeners[i + 1]).messageReceived(e);
			}
		}
	}
}
