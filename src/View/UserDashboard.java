package View;
import Model.Message;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class UserDashboard extends JFrame {
    private String loggedInUsername;
    public UserDashboard(String loggedInUsername) {
        this.loggedInUsername = loggedInUsername;
        setTitle("User Dashboard - " + loggedInUsername);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Inbox", createInboxPanel());
        tabbedPane.addTab("Sent Box", createSentBoxPanel());
        add(tabbedPane);
    }
    private JPanel createInboxPanel() {
        JPanel inboxPanel = new JPanel();
        JTextField recipientField = new JTextField(15);
        JTextArea messageArea = new JTextArea(10, 30);
        JButton sendMessageButton = new JButton("Send Message");
        sendMessageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String recipient = recipientField.getText();
                String message = messageArea.getText();
                if (Message.insertMessage(loggedInUsername, recipient, message)) {
                    JOptionPane.showMessageDialog(null, "Message sent!");
                } else {
                    JOptionPane.showMessageDialog(null, "Message not sent. Error occurred.");
                }
            }
        });
        inboxPanel.add(new JLabel("Recipient:"));
        inboxPanel.add(recipientField);
        inboxPanel.add(new JLabel("Message:"));
        inboxPanel.add(new JScrollPane(messageArea));
        inboxPanel.add(sendMessageButton);

        return inboxPanel;
    }
    private JPanel createSentBoxPanel() {
        JPanel sentBoxPanel = new JPanel();
        return sentBoxPanel;
    }
}