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

    public LogInPageGUI(String title, LogInPageController controller) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel); // set the content that goes into the JFrame (which we named mainPanel)
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
                enterButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (LogInPageController.ensuringUserFieldNotBlank(nameTextField.getText(), emailTextField.getText(), addressTextField.getText())) {
                            String nameOfUser = nameTextField.getText();
                            String emailOfUser = emailTextField.getText();
                            String addressOfUser = addressTextField.getText();
                            DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
                            LocalDateTime currentLocalTime = LocalDateTime.now();

                            // TODO should I use the controller to get/set the date of the shoppingList or use the LogInPageGUI class' methods
                            controller.setDateOfList(currentLocalTime);
                            userInfo.add(0, dtf.format(currentLocalTime));

                            userInfo.add(1, nameOfUser);
                            userInfo.add(2, emailOfUser);
                            userInfo.add(3, addressOfUser);
                            User userForTheController = new User(nameOfUser, emailOfUser, addressOfUser);
                            controller.setUserInfo(userForTheController);
                            SuccessField.setText("Hello, " + nameOfUser + "!");
                            successfulLogIn = true;
                            dispose();
                            JFrame mainShoppingFrame = new mainShopping("NNN Shopping");
                            mainShoppingFrame.setResizable(false);
                            mainShoppingFrame.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid Entry! Please Fill Out All Fields. Quitting...");
                            nameTextField.setText("");
                            emailTextField.setText("");
                            addressTextField.setText("");
                            successfulLogIn = false;

                            System.exit(0);
                        }
                    }
                });
        }

    public boolean isSuccessfulLogIn() { //TODO was planning on using this method somehow, "if (!isSuccessfulLogIn)
                                                                                    //TODO { *have the user try again* } else {*let user continue*}
        return successfulLogIn;
    }

    public static DefaultListModel<String> getUserInfo() {
        return userInfo;
    }

    public static String getDateOfShoppingList() {
        return userInfo.get(0);
    }

    public void closeFrame() {
        this.setVisible(false);
    }
}
