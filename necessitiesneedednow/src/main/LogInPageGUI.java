import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;




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
    private static DefaultListModel<String> userInfo = new DefaultListModel<>();
    private LogInPageController controller = new LogInPageController();
    private User LogInPageGUIUser = new User(null,null,null);

    public LogInPageGUI(String title, LogInPageController controller) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel); // set the content that goes into the JFrame (which we named mainPanel)
        this.pack();
        this.setVisible(true);

        //TODO how do I have the program wait until the button is pressed
        //TODO why isn't this working? should the program not pause until the button is pressed?
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (LogInPageGUIUser.getName() == null && LogInPageGUIUser.getEmail() == null && LogInPageGUIUser.getAddress() == null ){
                    // pop up dialogue
                    LogInPageGUIUser.setName(nameTextField.getText());
                    LogInPageGUIUser.setEmail(emailTextField.getText());
                    LogInPageGUIUser.setAddress(addressTextField.getText());
                }

                // if they make it here, they've logged in successfully
                // using the controller for states

                String nameOfUser = nameTextField.getText();
                String emailOfUser = emailTextField.getText();
                String addressOfUser = addressTextField.getText();
                DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
                LocalDateTime currentLocalTime = LocalDateTime.now();
                JOptionPane.showMessageDialog(null, "We've gone ahead and made you a shoppingList for today's date, " + (dtf.format(currentLocalTime) + "!"));
                userInfo.add(0,dtf.format(currentLocalTime));
                userInfo.add(1,nameOfUser);
                userInfo.add(2,emailOfUser);
                userInfo.add(3,addressOfUser);
                User userForTheController = new User(nameOfUser,emailOfUser,addressOfUser);
                controller.setUserInfo(userForTheController);
                // setUser (from the controller)
                SuccessField.setText("Hello, " + nameOfUser + "!");
            }
        });
    }
}
