import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

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
    private JScrollPane scrollPane;
    private JLabel errorMessage;
    private JCheckBox subscribe;
    private JButton finishShoppingButton;
    private DefaultListModel listModel = new DefaultListModel();
    private ShoppingAPI api = new ShoppingAPI();
    private shoppingList list;

    public mainShopping(String title){
        // Initializing GUI
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(440, 450));
        this.setContentPane(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null); // Centers Jframe at center of screen

        this.heading.setFont(new Font(heading.getFont().getName(), Font.BOLD, 20));
        searchResults.setModel(listModel);

        // Shopping List Setup
        // TODO: update date here
        list = new shoppingList("222");
        JFrame shoppingListFrame = new shoppingListDisplayGUI("Your Current Shopping List", list);
        shoppingListFrame.setVisible(true);

        styleButtons();
        setupQuantityTextField();

        // Grouping the radio buttons together so that it's either/or
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(ingredientsButton);
        buttonGroup.add(productButton);

        // Search Button Action
        searchButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!groceriesSearchField.getText().equals("") && !quantity.getText().equals("")){
                    errorMessage.setText("");
                    String apiSearchResults = api.searchItems(groceriesSearchField.getText());
                    listModel.clear();
                    parseSearchResults(apiSearchResults);

                } else{
                    errorMessage.setText("Please fill out all fields!");
                }
            }
        });

        // Add to Shopping Cart Button Action
        addToShoppingCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!searchResults.isSelectionEmpty()){
                    // TODO: Need to updated price functionality
                    String itemName = searchResults.getSelectedValue().toString();
                    double itemPrice = getItemPrice(itemName);
                    Item item = new Item(itemName, 0, itemPrice, true);
                    list.addItem(item, 1, "Target", subscribe.isSelected());
                    clearFields();
                } else{
                    errorMessage.setText("Please select an item to add to your shopping cart!");
                }
            }
        });

        finishShoppingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveShoppingList save = new saveShoppingList(list);
                try {
                    save.save();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
    }

    /**
     * Parses string of apiSearchResults and prints it out on JList of GUI
     * @param apiSearchResults String of search results
     */
    public void parseSearchResults(String apiSearchResults){
        JSONArray albums = new JSONArray(apiSearchResults);
        if(albums.length() <= 0) listModel.addElement("Your search resulted in 0 results!");
        for(int i = 0; i < albums.length(); i++) {
            JSONObject album = albums.getJSONObject(i);
            String name = album.getString("name");
            int id = album.getInt("id");
            listModel.addElement(name);
        }
        searchResults = new JList(listModel);
        scrollPane.setViewportView(searchResults);
    }

    public double getItemPrice(String itemName){
        int id = api.getItemId(itemName);
        double price = api.getSpecificItem(id, Integer.parseInt(quantity.getText().toString()));
        return price;
    }

    /**
     * Only allows users to enter numerical values (and backspace) in quantity text field
     */
    public void setupQuantityTextField(){
        quantity.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = quantity.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    quantity.setEditable(true);
                } else {
                    quantity.setEditable(false);
                }
            }
        });
    }

    /**
     * Clears all fields
     */
    public void clearFields(){
        subscribe.setSelected(false);
        groceriesSearchField.setText("");
        quantity.setText("");
        listModel.clear();
    }

    /**
     * Styles all the buttons in mainShopping GUI
     */
    public void styleButtons(){
        addToShoppingCartButton.setBackground(new Color(7, 117, 33));
        addToShoppingCartButton.setOpaque(true);
        addToShoppingCartButton.setForeground(Color.WHITE);
        addToShoppingCartButton.setBorderPainted(false);
        finishShoppingButton.setBackground(new Color(191, 191, 191));
        finishShoppingButton.setOpaque(true);
        finishShoppingButton.setForeground(Color.WHITE);
        finishShoppingButton.setBorderPainted(false);
    }
}
