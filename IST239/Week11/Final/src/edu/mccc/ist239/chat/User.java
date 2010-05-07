package edu.mccc.ist239.chat;

import java.net.*;

/**
 * This class represents a user, connected to the server.
 * This information is useful in directing packets back to him/her.
 */
public class User {
    //Not currently used
    private String name;
	private InetAddress inetaddr;
	private int port;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getPort() {
        return port;
    }
    public InetAddress getInetAddress() {
        return inetaddr;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public void setInetAddress(InetAddress inetaddr) {
        this.inetaddr = inetaddr;
    }
}
