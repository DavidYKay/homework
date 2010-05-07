package edu.mccc.ist239.chat;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.HashMap;

import com.cbthinkx.util.Debug;

/**
 * Single-threaded chat server, which uses a basic infinite loop, awaiting 
 * incoming packets. Note: Connected users are currently tracked in a HashMap.
 * This could be used in the future to implement more sophisticated behavior. 
 * At the moment, the same functionality could be easy implemented using a List.
 */
public class ChatServer {
	private HashMap<SocketAddress, User> users = new HashMap<SocketAddress, User>();
	private DatagramSocket socket;
	public ChatServer() throws Exception {
		Debug.println("ChatServer:ChatServer()");
		this.socket = new DatagramSocket(5972);
	}
	public static void main(String[] sa) throws Exception {
		Debug.println("ChatServer:main()");
		ChatServer server = new ChatServer();
		server.doit();
	}
    /**
     * Main loop. Sits around, waiting for packets from users.
     */
	private void doit() throws Exception {
		Debug.println("ChatServer:doit()");
		for (;;) {
			DatagramPacket dp = new DatagramPacket(new byte[32], 32);
			socket.receive(dp);
			String msg = new String(dp.getData()).trim();
			Debug.println(msg);
			SocketAddress saddr = dp.getSocketAddress();
			if (msg.startsWith("hi")) {
                //Log on
				String[] sa = msg.split(":");
				User user = new User(sa[1]);
				user.setInetAddress(dp.getAddress());
				user.setPort(dp.getPort());
				users.put(saddr, user);
			} else if (msg.startsWith("bye")) {
                //Logoff
				users.remove(saddr);
            } else {
                //Standard message
                broadcastMessage(msg, dp.getAddress());
			}
		}
	}
    /**
     * Send a message out to all connected users
     */
    private void broadcastMessage(String msg, InetAddress iaddr) {
        Debug.println("ChatServer.broadcastMessage: " + msg);
		try {
            for (User target : users.values()) {
                Debug.println("Iterating user: " + target);
                DatagramPacket dp = new DatagramPacket(
                    msg.getBytes(),
                    msg.length(),
                    target.getInetAddress(),
                    target.getPort()
                );
                socket.send(dp);
            }
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
    }
}
