import javax.swing.*;
import java.util.HashMap;
import java.util.Scanner;

public class testing {

    public static void main(String[] args) {

        LogInPageController userInformation = new LogInPageController();
        LogInPageGUI firstGUIScreen = new LogInPageGUI("Log In Page for Necessities Needed Now", userInformation); // pass in controller to GUI

        //TODO, make sure that we can only reach the lower lines of code **after** we get user input from LogInPageGUI???

        System.out.println("You made it!");

        //TODO, currently returns a NPE due to a lack of info in userInformation. program reaches this line before a user even gets a chance to do anything on firstGUIScreen
        System.out.println(userInformation.getUser().toString());
        // order goes: date, name, email, address
        //TODO, my main worry is that once we run our main program and reach our second GUI, will the second GUI be able to call userInformation.getUser() and get anything? or will it always return NPE?



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
            System.out.println("Your current list is: " + firstUserShoppingList.getAllItemNames());
            System.out.println("Examples of available food include: milk, eggs, cheese, yogurt, butter, cottage cheese, bread," +
                    "potato chips, cereal, carrots, peppers, lettuce, celery, oranges, strawberries, grapes, blueberries")
            ;
            System.out.println("Input item " + counter + "'s name here please. Type the word 'done' if you are finished.");
            nameOfItem = input.nextLine();
            if (nameOfItem.equals("done")) {
                counter--;
            } else {

                ShoppingAPI apiCall = new ShoppingAPI();
                boolean searchSuccessful = apiCall.searchItems(nameOfItem);

                while (!searchSuccessful) {
                    System.out.println("Your search query returned no results! Please try again!");
                    nameOfItem = input.nextLine();
                    searchSuccessful = apiCall.searchItems(nameOfItem);
                }

                // might need to implement an option to exist list to do a different query
                System.out.println("Please choose an item from the list above:");
                String itemName = input.nextLine();
                int itemId;
                while ((itemId = apiCall.getItemId(itemName)) == 0) {
                    System.out.println("Please choose an item ONLY from the list above:");
                    itemName = input.nextLine();
                }

                System.out.println("Please input the amount of that item you want in digits.");
                while (!input.hasNextInt()) {
                    System.out.println("Please enter the amount you want using ONLY digits.");
                    input.next();
                }
                int totalAmount = input.nextInt(); // increases total amount

                input.nextLine();
                System.out.println("Please enter the store where you would like this purchased from");
                String store = input.nextLine();

                double price = apiCall.getSpecificItem(itemId, totalAmount);

//                System.out.println("Please enter the price of the item");
//                while (!input.hasNextDouble()) {
//                    System.out.println("Please enter the price of the item using ONLY digits.");
//                    input.next();
//                }
//                double price = input.nextDouble();
//                input.nextLine();

                System.out.println("Would you like to subscribe to this item? (Enter true/false)");
                while (!input.hasNextBoolean()) {
                    System.out.println("Please enter ONLY true/false.");
                    input.next();
                }
                boolean subscribed = input.nextBoolean();
                input.nextLine();

                Item item = new Item (itemName, 0, price, true);

                firstUserShoppingList.addItem(item, totalAmount, store, subscribed);


            }
        }

            System.out.println("Today's shopping list is:" + (firstUserShoppingList.getAllItemNames()));



    }
}




