import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;



public class LogInPageGUI extends JFrame {
    private JPanel mainPanel;
    private JLabel Username;
    private JLabel Email;
    private JLabel Address;
    private JButton enterButton;
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField addressTextField;
    private JLabel SuccessField;
    private static ArrayList<String> userInfo = new ArrayList<>();

    public LogInPageGUI(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits when u click close ???
        this.setContentPane(mainPanel); // set the content that goes into the JFrame (which we named mainPanel)
        this.pack();
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // grab the text from the textLabel and store it
                String nameOfUser = nameTextField.getText();
                String emailOfUser = emailTextField.getText();
                String addressOfUser = addressTextField.getText();
                JOptionPane.showMessageDialog(null, "success!");

                userInfo.add(nameOfUser);
                userInfo.add(emailOfUser);
                userInfo.add(addressOfUser);
                User newUser = new User(nameOfUser,emailOfUser,addressOfUser);
                // construct a user
                DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
                LocalDateTime currentLocalTime = LocalDateTime.now();
                userInfo.add(dtf.format(currentLocalTime));
                // TODO: call CSV stuff here?
                SuccessField.setText("Thanks, " + nameOfUser + "! We've gone ahead and made you a shoppingList for " + (dtf.format(currentLocalTime) + "!"));
                System.out.println(getUserInfo().toString());
            }
        });
    }

    private static ArrayList<String> getUserInfo() {
        return userInfo;
    }

    public static void main(String[] args) {
        JFrame frame = new LogInPageGUI("Log In Page for Necessities Needed Now");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}