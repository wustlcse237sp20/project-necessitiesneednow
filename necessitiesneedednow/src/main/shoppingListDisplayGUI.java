import javax.swing.*;
import java.awt.*;

public class shoppingListDisplayGUI extends JFrame {

    private JPanel mainPanel;
    private JLabel currentShoppingList;
    private JList<String> itemDisplayList;


    public shoppingListDisplayGUI(String title, shoppingList shoppingList){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.itemDisplayList.setModel(shoppingList.getAllItems());
//        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
//        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
//        this.setLocation((int) rect.getMaxX() - this.getWidth(), 0);
        this.pack();
    }

    public shoppingListDisplayGUI(shoppingList list){
        this.itemDisplayList.setModel(list.getAllItems());
    }
}
