import javax.swing.*;

public class LogInPageController {

    private DefaultListModel<String> userInfo;
    private User primaryUser;
    private shoppingList primaryShoppingList;


    public static boolean ensuringUserFieldNotBlank(String name, String email, String address) {
        if (name.equals("") || email.equals("") || address.equals("")) {
            return false;
        } else{
            return true;
        }
    }

    /**
     * a method that sets information in the LogInPageGUI, not for use in a main program
     * @param u
     */
    public void setUserInfo(User u) {
        primaryUser = u;
    }

    /**
     * a method that gets information from the LogInPageGUI, is meant for use in a main program
     * @return the User in question.
     */
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
