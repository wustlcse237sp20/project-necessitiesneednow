import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;

public class mainShopping extends JFrame {
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

    public mainShopping(String title) {
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
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!groceriesSearchField.getText().equals("") && !quantity.getText().equals("")) {
                    errorMessage.setText("");
                    String apiSearchResults = api.searchItems(groceriesSearchField.getText());
                    listModel.clear();
                    parseSearchResults(apiSearchResults);

                } else {
                    errorMessage.setText("Please fill out all fields!");
                }
            }
        });

        // Add to Shopping Cart Button Action
        addToShoppingCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!searchResults.isSelectionEmpty()) {
                    // TODO: Need to updated price functionality
                    String itemName = searchResults.getSelectedValue().toString();
                    double itemPrice = getItemPrice(itemName);
                    Item item = new Item(itemName, 0, itemPrice, true);
                    list.addItem(item, 1, "Target", subscribe.isSelected());
                    clearFields();
                } else {
                    errorMessage.setText("Please select an item to add to your shopping cart!");
                }
            }
        });

        finishShoppingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * Parses string of apiSearchResults and prints it out on JList of GUI
     *
     * @param apiSearchResults String of search results
     */
    public void parseSearchResults(String apiSearchResults) {
        JSONArray albums = null;
        try {
            albums = new JSONArray(apiSearchResults);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (albums.length() <= 0) listModel.addElement("Your search resulted in 0 results!");
        for (int i = 0; i < albums.length(); i++) {
            JSONObject album = null;
            try {
                album = albums.getJSONObject(i);
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String name = null;
            try {
                name = album.getString("name");
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                int id = album.getInt("id");
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            listModel.addElement(name);
        }
        searchResults = new JList(listModel);
        scrollPane.setViewportView(searchResults);
    }

    public double getItemPrice(String itemName) {
        int id = api.getItemId(itemName);
        double price = 0;
        try {
            price = api.getSpecificItem(id, Integer.parseInt(quantity.getText().toString()));
        } catch (NumberFormatException | JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return price;
    }

    /**
     * Only allows users to enter numerical values (and backspace) in quantity text field
     */
    public void setupQuantityTextField() {
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
    public void clearFields() {
        subscribe.setSelected(false);
        groceriesSearchField.setText("");
        quantity.setText("");
        listModel.clear();
    }

    /**
     * Styles all the buttons in mainShopping GUI
     */
    public void styleButtons() {
        addToShoppingCartButton.setBackground(new Color(7, 117, 33));
        addToShoppingCartButton.setOpaque(true);
        addToShoppingCartButton.setForeground(Color.WHITE);
        addToShoppingCartButton.setBorderPainted(false);
        finishShoppingButton.setBackground(new Color(191, 191, 191));
        finishShoppingButton.setOpaque(true);
        finishShoppingButton.setForeground(Color.WHITE);
        finishShoppingButton.setBorderPainted(false);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(14, 6, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.setEnabled(true);
        groceriesSearchField = new JTextField();
        groceriesSearchField.setText("");
        mainPanel.add(groceriesSearchField, new GridConstraints(4, 1, 4, 2, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final Spacer spacer1 = new Spacer();
        mainPanel.add(spacer1, new GridConstraints(4, 0, 4, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        searchButton = new JButton();
        searchButton.setText("Search");
        mainPanel.add(searchButton, new GridConstraints(4, 4, 4, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        quantity = new JTextField();
        mainPanel.add(quantity, new GridConstraints(4, 3, 4, 1, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Search for Groceries");
        mainPanel.add(label1, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Quantity");
        mainPanel.add(label2, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        mainPanel.add(spacer2, new GridConstraints(4, 5, 4, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        ingredientsButton = new JRadioButton();
        ingredientsButton.setSelected(true);
        ingredientsButton.setText("Ingredients");
        mainPanel.add(ingredientsButton, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        productButton = new JRadioButton();
        productButton.setText("Products");
        mainPanel.add(productButton, new GridConstraints(8, 2, 1, 1, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(22);
        mainPanel.add(scrollPane, new GridConstraints(9, 1, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        searchResults = new JList();
        scrollPane.setViewportView(searchResults);
        final Spacer spacer3 = new Spacer();
        mainPanel.add(spacer3, new GridConstraints(9, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        mainPanel.add(spacer4, new GridConstraints(9, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        mainPanel.add(spacer5, new GridConstraints(13, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        heading = new JLabel();
        heading.setHorizontalAlignment(0);
        heading.setHorizontalTextPosition(0);
        heading.setText("Neccessities Needed Now: Shopping");
        mainPanel.add(heading, new GridConstraints(1, 1, 1, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer6 = new Spacer();
        mainPanel.add(spacer6, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        addToShoppingCartButton = new JButton();
        addToShoppingCartButton.setText("Add to Shopping Cart");
        mainPanel.add(addToShoppingCartButton, new GridConstraints(11, 1, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        errorMessage = new JLabel();
        errorMessage.setForeground(new Color(-56284));
        errorMessage.setText("");
        mainPanel.add(errorMessage, new GridConstraints(2, 1, 1, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer7 = new Spacer();
        mainPanel.add(spacer7, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer8 = new Spacer();
        mainPanel.add(spacer8, new GridConstraints(3, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer9 = new Spacer();
        mainPanel.add(spacer9, new GridConstraints(2, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        subscribe = new JCheckBox();
        subscribe.setText("Click to subscribe to this item");
        mainPanel.add(subscribe, new GridConstraints(10, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        finishShoppingButton = new JButton();
        finishShoppingButton.setText("Finish Shopping");
        mainPanel.add(finishShoppingButton, new GridConstraints(12, 1, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}
