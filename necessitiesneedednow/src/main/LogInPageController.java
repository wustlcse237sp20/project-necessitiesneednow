import javax.swing.*;

public class LogInPageController {

    private DefaultListModel<String> userInfo;
    private User primaryUser;
    private shoppingList primaryShoppingList;

    // starts in the login state
    // once they hit the button, and it's verified, you go into the next state


    public void setUserInfo(User u) {
        primaryUser = u;
    }

    public User getUser() {
        return primaryUser;
    }


//    public DefaultListModel<String> retrieveUserInfo() {
//        return userInfo;
//    }
//
//    public String getUserInfoAsString(DefaultListModel<String> userInfo) {
//        return userInfo.toString();
//    }
}
