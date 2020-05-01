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
    private boolean successfulLogIn = false;
//    private LogInPageController controller = new LogInPageController();
//    private User LogInPageGUIUser = new User(null,null,null);

    public LogInPageGUI(String title, LogInPageController controller) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel); // set the content that goes into the JFrame (which we named mainPanel)
        this.pack();
        this.setVisible(true);

        //TODO how do I have the program wait until the button is pressed?

            enterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (LogInPageController.ensuringUserFieldNotBlank(nameTextField.getText(), emailTextField.getText(), addressTextField.getText())) {
                        String nameOfUser = nameTextField.getText();
                        String emailOfUser = emailTextField.getText();
                        String addressOfUser = addressTextField.getText();
                        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
                        LocalDateTime currentLocalTime = LocalDateTime.now();
                        JOptionPane.showMessageDialog(null, "We've gone ahead and made you a shoppingList for today's date, " + (dtf.format(currentLocalTime) + "!"));
                        userInfo.add(0, dtf.format(currentLocalTime));
                        userInfo.add(1, nameOfUser);
                        userInfo.add(2, emailOfUser);
                        userInfo.add(3, addressOfUser);
                        User userForTheController = new User(nameOfUser, emailOfUser, addressOfUser);
                        controller.setUserInfo(userForTheController);
                        SuccessField.setText("Hello, " + nameOfUser + "!");
                        successfulLogIn = true;
                        closeFrame(); // just sets frame as invisible
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Entry! Please Fill Out All Fields");
                        nameTextField.setText("");
                        emailTextField.setText("");
                        addressTextField.setText("");
                        successfulLogIn = false;
                    }
                }
            });
        }

    public boolean isSuccessfulLogIn() { //TODO was planning on using this method somehow, "if (!isSuccessfulLogIn)
                                                                                    //TODO { *have the user try again* } else {*let user continue*}
        return successfulLogIn;
    }

    public void closeFrame() {
        this.setVisible(false);
    }
}
