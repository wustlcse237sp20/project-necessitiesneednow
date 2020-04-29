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
    private static DefaultListModel<String> userInfo = new DefaultListModel<>();
    private LogInPageController controller;

    public LogInPageGUI(String title) {
        super(title);
        controller = new LogInPageController();
//        JList list = new JList(controller.retrieveUserInfo()); // if you update via the controller, you also update the view. do i need this?
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setContentPane(mainPanel); // set the content that goes into the JFrame (which we named mainPanel)
        this.pack();
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // grab the text from the textLabel and store it
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
                new User(nameOfUser,emailOfUser,addressOfUser);
                SuccessField.setText("Hello, " + nameOfUser + "!");
                System.out.println(controller.retrieveUserInfoAsString(userInfo));
            }
        });

    }

//    private static String getUserInfo



    public static void main(String[] args) {
        JFrame frame = new LogInPageGUI("Log In Page for Necessities Needed Now");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
