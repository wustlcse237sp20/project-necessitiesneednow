import javax.swing.*;

public class App {

    public static void main(String[] args) {
        LogInPageController userInformation = new LogInPageController();
        new LogInPageGUI("Log In Page for Necessities Needed Now", userInformation); // pass in controller to GUI



    }
}