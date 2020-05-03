public class retrieveUserInfo {

//    private LogInPageController userInformation = new LogInPageController();
    private LogInPageController outwardFacingController = new LogInPageController();

    public static void main(String[] args) {
        LogInPageController userInformation = new LogInPageController();
        new LogInPageGUI("Log In Page for Necessities Needed Now", userInformation);
    }


}
