package edu.mccc.ist239.chat;
import java.util.EventListener;
public interface ChatLoginListener extends ChatListener {
    public void loginEvent(boolean success);
}
