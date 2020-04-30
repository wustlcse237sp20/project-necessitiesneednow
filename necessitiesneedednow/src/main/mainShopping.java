import javax.swing.*;
import java.awt.*;

public class mainShopping extends JFrame{
    private JPanel mainPanel;
    private JTextField groceriesSearchField;
    private JButton searchButton;
    private JRadioButton ingredientsButton;
    private JRadioButton productButton;
    private JTextField quantity;
    private JList searchResults;
    private JButton addToShoppingCartButton;
    private JLabel heading;

    public mainShopping(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(410, 450));
        this.setContentPane(mainPanel);
        this.pack();
        this.heading.setFont(new Font(heading.getFont().getName(), Font.BOLD, 20));
    }

    public static void main(String[] args){
        JFrame frame = new mainShopping("NNN Shopping");
        frame.setVisible(true);
    }
}
