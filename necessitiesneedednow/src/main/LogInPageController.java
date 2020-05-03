import java.time.LocalDateTime;

public class LogInPageController {


    private User primaryUser;

    private LocalDateTime localDateTime;

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


    public void setDateOfList(LocalDateTime date) {localDateTime = date;}


}
