import javax.swing.*;

public class LogInPageController {

    private DefaultListModel<String> userInfo;

    public String retrieveUserInfoAsString(DefaultListModel<String> userInfo) {
        return userInfo.toString();
    }

    public DefaultListModel<String> retrieveUserInfo() {
        return userInfo;
    }
}
