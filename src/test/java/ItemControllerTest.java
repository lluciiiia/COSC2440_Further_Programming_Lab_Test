import com.example.seokyungkim_s3939114.ConnectionManager;
import com.example.seokyungkim_s3939114.Controller.ItemController;
import com.example.seokyungkim_s3939114.Model.Customer;
import com.example.seokyungkim_s3939114.Model.Item;
import com.example.seokyungkim_s3939114.Request.InsertItemRequest;
import com.example.seokyungkim_s3939114.Request.UpdateItemRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ItemControllerTest {
    private ItemController itemController;

    @BeforeAll
    public void setUp() {
        ConnectionManager.initConnection();
        itemController = new ItemController();
    }

    @Test
    public void testAddItem() {
        InsertItemRequest request = new InsertItemRequest("Test Item", 10.0);

        itemController.addItem(request);
    }

    @Test
    public void testUpdateItem() {
        UpdateItemRequest request = new UpdateItemRequest(1, "Updated Item", 15.0);

        itemController.updateItem(request);
    }

    @Test
    public void testDeleteItem() {
        int id = 1;

        Item item = itemController.getItemById(id);
        assertNotNull(item, "Item should NOT be null");

        itemController.deleteItem(item.getId());

        Item deletedItem = itemController.getItemById(item.getId());
        assertNull(deletedItem, "Item should be null");
    }

    @Test
    public void testSearchItemsByName() {
        String name = "Pizza";

        List<Item> items = itemController.searchItemsByName(name);

        assertNotNull(items, "Items should exist.");

        for (Item item : items) {
            System.out.println(item.getName());
            System.out.println(item.getPrice());
        }
    }
}
