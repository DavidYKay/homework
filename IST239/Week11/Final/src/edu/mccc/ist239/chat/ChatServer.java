package edu.mccc.ist239.chat;
import java.net.*;
import java.util.HashMap;
import java.sql.*;

import com.cbthinkx.util.Debug;

/**
 * Single-threaded chat server, which uses a basic infinite loop, awaiting 
 * incoming packets. Note: Connected users are currently tracked in a HashMap.
 * This could be used in the future to implement more sophisticated behavior. 
 * At the moment, the same functionality could be easy implemented using a List.
 */
public class ChatServer {

    public static final int PASSWORD_LENGTH = 20;
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
			//DatagramPacket dp = new DatagramPacket(new byte[32], 32);
			DatagramPacket dp = new DatagramPacket(new byte[64], 64);
			socket.receive(dp);
			String msg = new String(dp.getData()).trim();
			Debug.println(msg);
			SocketAddress saddr = dp.getSocketAddress();
			if (msg.startsWith("hi")) {
                //Log on
				String[] args = msg.split(":");
				User user = new User(args[1]);
				String password = args[2];
                if (validatePasswordWithDB(user.toString(), password)) {
                    user.setInetAddress(dp.getAddress());
                    user.setPort(dp.getPort());
                    users.put(saddr, user);
                    targetMessage(
                        "login:true",
                        saddr
                    );
                } else {
                    //Send rejection notice to client
                    targetMessage(
                        "login:false",
                        saddr
                    );
                }
			} else if (msg.startsWith("bye")) {
                //Logoff
				users.remove(saddr);
			} else if (msg.startsWith("chat")) {
                try {
                    //Standard chat message
                    String[] args = msg.split(":");
                    String user = users.get(saddr).toString();
                    if (args.length >= 2) {
                        String chat = args[1];
                        chat = String.format(
                            "chat:%s: %s",
                            user,
                            chat
                        );
                        broadcastMessage(
                            chat, 
                            dp.getAddress()
                        );
                    }
                } catch(NullPointerException ex) {
                    //User did not exist
                    //Different message??
                    targetMessage(
                        "login:false",
                        saddr
                    );
                }
			} else if (msg.startsWith("im")) {
                String[] args = msg.split(":");
                if (args.length >= 3) {
                    String targetName = args[1];
                    String sourceName = null;
                    try {
                        sourceName = users.get(saddr).toString();
                    //} catch (NullPointerException ex) {
                    } catch (Exception ex) {
                        //User not found
                        continue;
                    }
                    //Grab user from our list
                    User target = null;
                    for (User u : users.values()) {
                        if (u.toString().equals(targetName)) {
                            target = u;
                        } else {
                            System.err.println(
                                String.format(
                                    "Target not found. Expected: %s Received: %s",
                                    targetName,
                                    //sourceName,
                                    u.toString()
                                )
                            );
                        }
                    }
                    if (target != null) {
                        String message = String.format(
                            "im:%s:%s",
                            sourceName,
                            args[2]
                        );
                        //Target found
                        targetMessage(
                            message,
                            new InetSocketAddress(
                                target.getInetAddress(),
                                target.getPort()
                            )
                        );
                    }
                } else {
                    //improper # arguments
                }
            } else {
                //broadcastMessage(msg, dp.getAddress());
			}
		}
	}

    /**
     * Send a message out to ONE user
     */
    private void targetMessage(String msg, SocketAddress saddr) {
        Debug.println("ChatServer.targetMessage: " + msg);
		try {
            //User target = users.get(saddr);
            DatagramPacket dp = new DatagramPacket(
                msg.getBytes(),
                msg.length(),
                ((InetSocketAddress) saddr).getAddress(),
                ((InetSocketAddress) saddr).getPort()
            );
            socket.send(dp);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
    }

    /**
     * Send a message out to ALL connected users
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

    private boolean validatePasswordWithDB(String userName, String userPass) {
        boolean result = false;
        //open db connection
        Connection conn = null;

        try {
            String dbUser     = "ist239";
            String dbPassword = "password";
            String url        = "jdbc:mysql://localhost/ist239";
            Class.forName ("com.mysql.jdbc.Driver").newInstance ();
            conn = DriverManager.getConnection (url, dbUser, dbPassword);
            System.out.println ("Database connection established");

            //fetch that shit
            String query = 
                "SELECT password"
                + " FROM user"
                + " WHERE username = ?";
            
            PreparedStatement prepStatement = conn.prepareStatement(
                query
            );

            prepStatement.setString(
                1,
                userName
                //"dk"
            );

            //Statement statement = conn.createStatement();
            //ResultSet resultSet = statement.executeQuery(query);
            //ResultSet resultSet = prepStatement.executeQuery(query);
            ResultSet resultSet = prepStatement.executeQuery();
            String password = null;
            while (resultSet.next()) {
                password = resultSet.getString(1);
            }
            if (password.equals(userPass)) {
                //compare password with one from DB
                result = true;
            } else {
                System.out.println(
                    String.format(
                        "Invalid login for user: %s. Expected password: %s, received: %s",
                        userName,
                        password,
                        userPass
                    )
                );
            }
        }
        catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close ();
                    System.out.println ("Database connection terminated");
                }
                catch (Exception e) { /* ignore close errors */ }
            }
        }
        return result;
    }
}
