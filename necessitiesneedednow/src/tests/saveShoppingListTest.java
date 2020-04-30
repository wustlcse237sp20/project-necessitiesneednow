import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;


class saveShoppingListTest {

    public shoppingList listForTesting = new shoppingList("04-13-20");


    @Test
    void save() throws IOException {
        Item apple = new Item("Apple", 2, 1.5, true);
        listForTesting.addItem(apple, 3, "Apple Store", true);
        saveShoppingList save = new saveShoppingList(listForTesting);
        Assertions.assertTrue(save.save());
    }
}