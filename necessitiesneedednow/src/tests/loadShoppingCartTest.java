import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;


class loadShoppingCartTest {

    public shoppingList listForTesting = new shoppingList("04-28-20");


    @Test
    void load() throws IOException {
        Item apple = new Item("Apple", 2, 1.5, true);
        Item orange = new Item("orange", 45, 2.5, true);
        listForTesting.addItem(apple, 3, "Apple Store", true);
        listForTesting.addItem(orange, 4, "Orange Store", false);
        saveShoppingList save = new saveShoppingList(listForTesting);
        save.save();
        loadShoppingCart load = new loadShoppingCart("04-28-20");
        shoppingList loadedList = load.load();
        Assertions.assertEquals(listForTesting.getAllItemNames(), loadedList.getAllItemNames());

    }
}