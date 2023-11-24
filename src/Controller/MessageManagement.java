package Controller;
import Model.Message;
import java.util.List;
public class MessageManagement {
    public static boolean sendMessage(String sender, String recipient, String message) {
        return Message.insertMessage(sender, recipient, message);
    }
    public static List<String> getInboxMessages(String recipient) {
        return Message.getInboxMessages(recipient);
    }
    public static List<String> getSentMessages(String sender) {
        return Message.getSentMessages(sender);
    }
}