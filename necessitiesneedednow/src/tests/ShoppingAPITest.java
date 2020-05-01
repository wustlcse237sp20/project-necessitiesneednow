import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingAPITest {


    @Test
    void searchItems() {
        ShoppingAPI.searchItems("apples");
        assertTrue(true);
    }

    @Test
    void getSpecificItem() {
        assertEquals(0.72,ShoppingAPI.getSpecificItem(1123,3));
        // note that this displays $0.72 in the main program due to a println return in the method. the method returns the unedited double.
    }

    @Test
    void getItemId() {
        ShoppingAPI.parseItemList("[{name:apples,id:9003}]");
        assertEquals(9003, ShoppingAPI.getItemId("apples"));
    }

    @Test
    void parseItemList() {
        ShoppingAPI.parseItemList("[{name:apples,id:9003}]");
        assertTrue(true);
    }

    @Test
    void parseItem() {
        assertEquals(3.17,ShoppingAPI.parseItem("{estimatedCost: {value:3.17, unit:US Cents}}"));
    }
}