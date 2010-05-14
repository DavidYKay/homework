package edu.mccc.ist239.chat;
import java.net.*;
import java.util.HashMap;
import java.sql.*;
import java.util.*;

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
                    sendBuddies(
                        user
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
			} else if (msg.startsWith("file")) {
                //File transfer
                //pass user socket information to recipient
                String[] args = msg.split(":");
                int port = Integer.parseInt(
                    args[1]
                );
                String userName = args[2];
                String fileName = args[3];
                User source = users.get(saddr);
                User target = getUser(userName);
                String message = String.format(
                    "file:%s:%s:%s:%s",
                    source.getName(),
                    fileName,
                    ((InetSocketAddress) saddr).getAddress(),
					port
                );
                
                targetMessage(
                    message,
                    target.getInetAddress(),
                    target.getPort() 
					//port
                );
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
                    User target = getUser(targetName);
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
            } else if (msg.startsWith("addbuddy")) {
                String[] args = msg.split(":");
                addBuddy(
                    users.get(saddr),
                    args[1]
                );
            } else {
                //broadcastMessage(msg, dp.getAddress());
			}
		}
	}

    /**
     * Ugly, linear method of finding a user from a username
     */
    private User getUser(String targetName) {
        User target = null;
        for (User u : users.values()) {
            if (u.toString().equals(targetName)) {
				//Target found!
                target = u;
				break;
            } else {
                System.err.println(
                    String.format(
                        "Target not found. Expected: %s Received: %s",
                        targetName,
                        u.toString()
                    )
                );
            }
        }
        return target;
    }

    private void targetMessage(String msg, InetAddress iaddr, int port) {
        Debug.println("ChatServer.targetMessage: " + msg);
		try {
            //User target = users.get(saddr);
            DatagramPacket dp = new DatagramPacket(
                msg.getBytes(),
                msg.length(),
                iaddr,
                port
            );
            socket.send(dp);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
    }

    /**
     * Send a message out to ONE user
     */
    private void targetMessage(String msg, SocketAddress saddr) {
        targetMessage(
            msg,
            ((InetSocketAddress) saddr).getAddress(),
            ((InetSocketAddress) saddr).getPort()
        );
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

    private Connection getDbConnection() {
        Connection conn = null;
        try {
            String dbUser     = "ist239";
            String dbPassword = "password";
            String dbUrl      = "jdbc:mysql://localhost/ist239";
            Class.forName ("com.mysql.jdbc.Driver").newInstance ();
            conn = DriverManager.getConnection (dbUrl, dbUser, dbPassword);
            System.out.println ("Database connection established");
        } catch (Exception e) {
            System.out.println ("Database connection failed");
        }
        return conn;
    }

    private void closeDbConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close ();
                System.out.println ("Database connection terminated");
            }
            catch (Exception e) { /* ignore close errors */ }
        }
    }

    private boolean validatePasswordWithDB(String userName, String userPass) {
        boolean result = false;
        //open db connection
        Connection conn = null;

        try {
            conn = getDbConnection();

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
            closeDbConnection(conn);
        }
        return result;
    }

    /**
     * Send buddies on a separate thread, since it takes some time
     */
    private void sendBuddies(final User user) {
		new Thread() {
			public void run() {
				Debug.println("sendBuddies.Thread:run()");
                //Look up buddies in the database
                
                Connection conn = getDbConnection();

                String query = 
                    "SELECT buddies.buddy_id, user.username"
                    + " FROM user"
                    + " LEFT JOIN buddies"
                    + " ON buddies.buddy_id = user.id"
                    + " WHERE buddy_id = ?";
                
                ArrayList<String> buddyNames = new ArrayList<String>();
                try {
                    PreparedStatement prepStatement = conn.prepareStatement(
                        query
                    );

                    prepStatement.setInt(
                        1,
                        2
                    );

                    ResultSet resultSet = prepStatement.executeQuery();
                    while (resultSet.next()) {
                        String buddyName = resultSet.getString(2);
                        buddyNames.add(
                            buddyName
                        );
                    }

                } catch (Exception ex) {
                    //SQL exception
					System.err.println("Database exception:");
					System.err.println(ex.getMessage());
                }
                closeDbConnection(conn);
                
                //send all names to user
                for (String buddyName : buddyNames) {
                    String msg = "buddy:" + buddyName;
                    targetMessage(
                        msg,
                        user.getInetAddress(),
                        user.getPort()
                    );
                }
            }
        }.run();
    }

    /**
     * This is a bit of a hack since I didn't plan ahead and use 
     * integer IDs for everything
     */
    private int getBuddyId(String userName) {
        int buddyId = -1;
        Connection conn = null;

        try {
            conn = getDbConnection();

            //fetch that shit
            String query = 
                "SELECT id"
                + " FROM user"
                + " WHERE username = ?";
            
            PreparedStatement prepStatement = conn.prepareStatement(
                query
            );

            prepStatement.setString(
                1,
                userName
            );

            ResultSet resultSet = prepStatement.executeQuery();
            while (resultSet.next()) {
                buddyId = resultSet.getInt(1);
            }
        }
        catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            closeDbConnection(conn);
        }
        return buddyId;
    }

    /**
     * Add a buddy to the user's buddy list
     */
    private void addBuddy(final User user, final String buddyName) {
		new Thread() {
			public void run() {
				Debug.println("addBuddy.Thread:run()");
                //Look up buddies in the database
                
                Connection conn = getDbConnection();

                String query = 
                    "INSERT INTO buddies"
                    + "(user_id, buddy_id) VALUES (?, ?)";
                
                try {
                    PreparedStatement prepStatement = conn.prepareStatement(
                        query
                    );
                    prepStatement.setInt(
                        1,
                        getBuddyId(
                            user.getName()
                        )
                        //userId
                    );
                    prepStatement.setInt(
                        2,
                        getBuddyId(
                            buddyName
                        )
                        //buddyId
                    );
                    prepStatement.execute();
                } catch (Exception ex) {
                    //SQL exception
					System.err.println("Database exception:");
					System.err.println(ex.getMessage());
                }
                closeDbConnection(conn);
            }
        }.run();
    }
}
