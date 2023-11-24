package View;
import Model.User;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class RegistrationForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    public RegistrationForm() {
        setTitle("Registration Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 150);
        JPanel panel = new JPanel();
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                // Call registration logic here
                if (User.insertUser(username, String.valueOf(password))) {
                    JOptionPane.showMessageDialog(null, "Registration successful!");
                    dispose(); // Close the registration form
                } else {
                    JOptionPane.showMessageDialog(null, "Registration failed!");
                }
            }
        });
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(registerButton);
        add(panel);
    }
}