import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;

public class testing {
    public static void main(String[] args) {

    	new GUI();
    	
        HashMap<User, shoppingList> Users = new HashMap<>();

        User firstUser = User.initializeUser();
        String currentDate = java.time.LocalDate.now().toString();
        shoppingList firstUserShoppingList = new shoppingList(currentDate);
        System.out.println("We've gone ahead and made a shopping list for you for today's date, " + currentDate);
        Users.put(firstUser, firstUserShoppingList);



        Scanner input = new Scanner(System.in);
        String nameOfItem = "";
        int counter = 0;
        while (!nameOfItem.equals("done")) {
            counter++;
            System.out.println("Your current list is: " + firstUserShoppingList.getItems());
            System.out.println("Examples of available food include: milk, eggs, cheese, yogurt, butter, cottage cheese, bread," +
                            "potato chips, cereal, carrots, peppers, lettuce, celery, oranges, strawberries, grapes, blueberries")
                                ;
            System.out.println("Input item " + counter + "'s name here please. Type the word 'done' if you are finished.");
            nameOfItem = input.nextLine();
            if (nameOfItem.equals("done")) {
                counter--;
            } else {
                System.out.println("Please input the amount of that item you want in digits.");
                while (!input.hasNextInt()) {
                    System.out.println("Please enter the amount you want using ONLY digits.");
                    input.next();
                }
                int totalAmount = input.nextInt();
                input.nextLine();
                System.out.println("Please enter the store where you would like this purchased from");
                String store = input.nextLine();
                System.out.println("Please enter the price of the item");
                while (!input.hasNextDouble()) {
                    System.out.println("Please enter the price of the item using ONLY digits.");
                    input.next();
                }
                    double price = input.nextDouble();
                    input.nextLine();
                    System.out.println("Would you like to subscribe to this item? (Enter true/false)");
                    while (!input.hasNextBoolean()) {
                        System.out.println("Please enter ONLY true/false.");
                        input.next();
                    }
                    boolean subscribed = input.nextBoolean();
                    input.nextLine();

                    firstUserShoppingList.addItem(nameOfItem, totalAmount, store, price, subscribed);


                }
            }

            System.out.println("Today's shopping list is:" + (firstUserShoppingList.getItems()));


        }
    }




