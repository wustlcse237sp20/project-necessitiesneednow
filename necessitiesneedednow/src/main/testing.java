import java.util.HashMap;
import java.util.Scanner;

public class testing {

    public static void main(String[] args) {
        HashMap currentInventory = new HashMap();
        HashMap currentShoppingCart = new HashMap();

        Scanner input = new Scanner(System.in);
        String s1 = "";
        String s2 = "";
        int counter = 0;
        while (!s1.equals("done")) {
            counter++;
            System.out.println("Input item " + counter + " here as item please. Type the word 'done' if you are finished.");
            s1 = input.nextLine();
            System.out.println("Please input the amount of that item you want in digits please. If you are done, please hit Enter.");
            s2 = input.nextLine();
            if (s1.equals("done") || s1.equals("Done")) {
            } else {
                currentShoppingCart.put(s1, s2);
            }
        }

            User Jenny = new User("Jenny", "yenny@yahoo.com", "317 Island Lane", currentInventory, currentShoppingCart);


        System.out.println("Looks like you have " + counter +  " items in your cart! " + Jenny.getCurrentShoppingCart());

    }
}
