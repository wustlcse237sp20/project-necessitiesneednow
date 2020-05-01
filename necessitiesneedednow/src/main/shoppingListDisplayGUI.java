import javax.swing.*;

public class shoppingListDisplayGUI extends JFrame {

    private JPanel mainPanel;
    private JLabel currentShoppingList;
    private JList<String> itemDisplayList;


    public shoppingListDisplayGUI(String title, shoppingList shoppingList){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.itemDisplayList.setModel(shoppingList.getAllItems());
        this.pack();
    }

    public static void main(String[] args) {
        Item Apples = new Item ("Apples", 234, 234, true);
        Item Pears = new Item ("Pears", 234,234 , false );
        Item Carrots = new Item ("Carrots", 234, 234, false);
        Item Peas = new Item ("Peas", 234, 234, false);
        shoppingList testList = new shoppingList("222");
        testList.addItem(Apples,2,"Walmart", false);
        testList.addItem(Pears, 2, "easdf", false);
        testList.addItem(Carrots,2,"asdf",true);
        testList.addItem(Peas, 2, "asdf", true);

        JFrame frame = new shoppingListDisplayGUI("Your Current Shopping List", testList);

        frame.setVisible(true);

    }
}
