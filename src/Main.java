import View.LoginForm;
public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
            }
        });
    }
}