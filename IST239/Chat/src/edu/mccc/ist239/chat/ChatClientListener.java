package edu.mccc.ist239.chat;
import java.util.EventListener;
public interface ChatClientListener extends EventListener {
    public void messageReceived(ChatClientEvent e);
}
