import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;

public class testing {
    public static void main(String[] args) {

        HashMap<Object, Object> Users = new HashMap<Object, Object>();
        User Mike = new User("Mike", "mike@yahoo.com", "415 Wydown Blvd");
        shoppingList today = new shoppingList("4/2/20");

        Scanner input = new Scanner(System.in);
        String nameOfItem = "";
        int counter = 0;
        while (!nameOfItem.equals("done")) {
            counter++;
            System.out.println("Input item " + counter + "'s name here please. Type the word 'done' if you are finished.");
            nameOfItem = input.nextLine();
            if (nameOfItem.equals("done")) {
                counter --;
            }
                 else {
                    System.out.println("Please input the amount of that item you want in digits please.");
                    int totalAmount = input.nextInt();
                    input.nextLine();
                    System.out.println("Please enter the store where you would like this purchased from");
                    String store = input.nextLine();
                    System.out.println("Please enter the price of the item");
                    double price = input.nextDouble();
                    input.nextLine();
                    System.out.println("Would you like to subscribe to this item? (Enter true/false)");
                    boolean subscribed = input.nextBoolean();
                    input.nextLine();

                    today.addItem(nameOfItem, totalAmount, store, price, subscribed);


                }
            }

        System.out.println("Today's shopping list is:" + (today.getItems()));


        }
    }



