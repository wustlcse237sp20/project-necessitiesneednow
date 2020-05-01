import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
    private DefaultListModel listModel = new DefaultListModel();
    private ShoppingAPI api = new ShoppingAPI();

    public mainShopping(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(440, 450));
        this.setContentPane(mainPanel);
        this.pack();
        this.heading.setFont(new Font(heading.getFont().getName(), Font.BOLD, 20));
        searchResults.setModel(listModel);

        // Button Styling
        addToShoppingCartButton.setBackground(new Color(7, 117, 33));
        addToShoppingCartButton.setOpaque(true);
        addToShoppingCartButton.setForeground(Color.WHITE);
        addToShoppingCartButton.setBorderPainted(false);

        // Only allows numeric values (and backspace) to be used
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
                // TODO: Add items to shopping cart/list
                if(!searchResults.isSelectionEmpty()){

                } else{
                    errorMessage.setText("Please select an item to add to your shopping cart!");
                }
            }
        });
    }

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
}
