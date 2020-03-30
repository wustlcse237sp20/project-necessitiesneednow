import java.util.HashMap;
import java.util.Scanner;

public class testing {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // System.in means it takes input from the keyboard
        System.out.println("Input the first item with quantity in digit (like Apple 3):");
        String s1 = input.nextLine(); // reads a line of input. returns the line as a string
        System.out.println("Input the second item with quantity in digit (like Apple 3):");
        String s2 = input.nextLine();
        System.out.println("Item 1:" + s1 + " " + s2);

        HashMap currentInventory = new HashMap();
        HashMap currentShoppingCart = new HashMap();
        User Jenny = new User("Jenny", "yenny@yahoo.com",  "317 Island Lane", currentInventory, currentShoppingCart);


        Jenny.getCurrentShoppingCart();

    }
}
