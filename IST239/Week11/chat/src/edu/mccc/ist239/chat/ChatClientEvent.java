package edu.mccc.ist239.chat;
import java.util.EventObject;
import com.cbthinkx.util.Debug;

public class ChatClientEvent extends EventObject {
    private String message;
    public ChatClientEvent(ChatClient client, String message) {
        super(client);
        Debug.println("ChatClientEvent()");
        this.message = message;
    }   
    public String getMessage() {
        return message;
    }
}
