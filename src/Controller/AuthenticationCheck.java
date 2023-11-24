package Controller;
import Model.User;
public class AuthenticationCheck {
    public static boolean authenticateUser(String username, String password) {
        // Verify user credentials against the database
        return User.validateUser(username, password);
    }
}