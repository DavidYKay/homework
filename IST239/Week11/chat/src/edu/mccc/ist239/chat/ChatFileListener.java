package edu.mccc.ist239.chat;
import java.util.EventListener;
import java.net.Socket;
public interface ChatFileListener extends ChatListener {
    public void fileEvent(Socket hostSocket, String fileName);
}
