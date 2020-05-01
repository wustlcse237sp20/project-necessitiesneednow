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

    public shoppingListDisplayGUI(shoppingList list){
        this.itemDisplayList.setModel(list.getAllItems());
    }
}
