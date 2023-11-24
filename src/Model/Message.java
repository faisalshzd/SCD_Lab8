package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class Message {
    public static boolean insertMessage(String sender, String recipient, String message) {
        try (Connection connection = DB_Manager.getConnection()) {
            String query = "INSERT INTO Messages (sender, recipient, message_content) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, sender);
                preparedStatement.setString(2, recipient);
                preparedStatement.setString(3, message);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static List<String> getInboxMessages(String recipient) {
        List<String> inboxMessages = new ArrayList<>();
        try (Connection connection = DB_Manager.getConnection()) {
            String query = "SELECT message_content FROM Messages WHERE recipient = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, recipient);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        inboxMessages.add(resultSet.getString("message_content"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inboxMessages;
    }
    public static List<String> getSentMessages(String sender) {
        List<String> sentMessages = new ArrayList<>();
        try (Connection connection = DB_Manager.getConnection()) {
            String query = "SELECT message_content FROM Messages WHERE sender = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, sender);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        sentMessages.add(resultSet.getString("message_content"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sentMessages;
    }
}