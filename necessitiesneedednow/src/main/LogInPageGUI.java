import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
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
    private static ArrayList<String> userInfo;

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
                //TODO find a way to store user info from these boxes. uncommenting these lines results in a crud-ton of errors.
//                userInfo.add(nameOfUser);
//                userInfo.add(emailOfUser);
//                userInfo.add(addressOfUser);
                DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
                LocalDateTime currentLocalTime = LocalDateTime.now();
//                userInfo.add(currentLocalTime.toString());
                SuccessField.setText("Thanks, " + nameOfUser + "! We've gone ahead and made you a shoppingList for " + (dtf.format(currentLocalTime) + "!"));
            }
        });
    }



    public static void main(String[] args) {
        JFrame frame = new LogInPageGUI("Log In Page for Necessities Needed Now");
        frame.setVisible(true);
//        System.out.println(userInfo.toString());
    }
}
