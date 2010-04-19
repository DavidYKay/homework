package edu.mccc.ist239.chat;

import java.net.*;

public class User {
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
