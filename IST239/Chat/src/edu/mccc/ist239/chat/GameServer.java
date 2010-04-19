package edu.mccc.ist239.chat;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import java.net.*;
import com.cbthinkx.util.Debug;
public class GameServer implements ActionListener {
	private HashMap<SocketAddress, User> users = new HashMap<SocketAddress, User>();
	private DatagramSocket socket;
	public GameServer() throws Exception {
		Debug.println("GameServer:GameServer()");
		this.socket = new DatagramSocket(5972);
		new javax.swing.Timer(1000, this).start();
	}
	public static void main(String[] sa) throws Exception {
		Debug.println("GameServer:main()");
		GameServer server = new GameServer();
		server.doit();
	}
	private void doit() throws Exception {
		Debug.println("GameServer:doit()");
		for (;;) {
			DatagramPacket dp = new DatagramPacket(new byte[32], 32);
			socket.receive(dp);
			String msg = new String(dp.getData()).trim();
			Debug.println(msg);
			SocketAddress saddr = dp.getSocketAddress();
			if (msg.startsWith("hi")) {
				String[] sa = msg.split(":");
				User user = new User(sa[1]);
				user.setInetAddress(dp.getAddress());
				user.setPort(dp.getPort());
				users.put(saddr, user);
			} else {
				if (msg.startsWith("bye")) {
				} else {
				}
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		Debug.println("GameServer:actionPerformed()");
		try {
			for (User user : users.values()) {
                String msg = user.getName() + ": Hello!";
				updateUser(user);
				Debug.println(msg);
				for (User target : users.values()) {
					DatagramPacket dp = new DatagramPacket(
						msg.getBytes(),
						msg.length(),
						target.getInetAddress(),
						target.getPort()
					);
					socket.send(dp);
				}
			}
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	private void updateUser(User user) {
		Debug.println("GameServer:updateUser()");
		//checkCollision();
	}
}
