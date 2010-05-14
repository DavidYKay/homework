package edu.mccc.ist239.chat;
import java.util.EventListener;
//public interface ChatClientListener extends EventListener {
public interface ChatClientListener extends ChatListener {
    public void messageReceived(ChatClientEvent e);
}
