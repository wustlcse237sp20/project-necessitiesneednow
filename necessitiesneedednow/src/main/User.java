import java.util.Scanner;

public class User {
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    private String name;
    private String email;
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
