import java.util.Scanner;

public class User {
    private String name;
    private String email;
    private String address;


    public User(String name, String email, String address){
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public static User initializeUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello! Welcome to NecessitiesNeededNow. To begin, we'll just need a few pieces of information!");

        System.out.println("Please enter your first and last name here (press enter when done): ");
        String nameOfUser = input.nextLine();

        System.out.println("Please enter your email address here: ");
        String emailOfUser = input.nextLine();

        System.out.println("Lastly, please enter your address: ");
        String addressOfUser = input.nextLine();

        return new User(nameOfUser,emailOfUser,addressOfUser);
    }
}
