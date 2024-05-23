import com.example.seokyungkim_s3939114.ConnectionManager;
import com.example.seokyungkim_s3939114.Controller.DeliverymanController;
import com.example.seokyungkim_s3939114.Model.Customer;
import com.example.seokyungkim_s3939114.Model.Deliveryman;
import com.example.seokyungkim_s3939114.Model.Item;
import com.example.seokyungkim_s3939114.Request.InsertDeliverymanRequest;
import com.example.seokyungkim_s3939114.Request.UpdateDeliverymanRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DeliverymanControllerTest {
    private DeliverymanController deliverymanController;

    @BeforeAll
    public void setUp() {
        ConnectionManager.initConnection();
        deliverymanController = new DeliverymanController();
    }

    @Test
    public void testAddDeliveryman() {
        InsertDeliverymanRequest request = new InsertDeliverymanRequest("Dboy", "555-1234");

        deliverymanController.addDeliveryman(request);
    }

    @Test
    public void testUpdateDeliveryman() {
        UpdateDeliverymanRequest request = new UpdateDeliverymanRequest(2, "updatedDBoy", "123-1234");

        deliverymanController.updateDeliveryman(request);
    }

    @Test
    public void testDeleteDeliveryman() {
        int id = 1;

        Deliveryman deliveryman = deliverymanController.getDeliverymanById(id);
        assertNotNull(deliveryman, "Deliveryman should NOT be null");

        deliverymanController.deleteDeliveryman(deliveryman.getId());

        Deliveryman deletedDeliveryman = deliverymanController.getDeliverymanById(deliveryman.getId());
        assertNull(deletedDeliveryman, "Deliveryman should be null");
    }

    @Test
    public void testSearchDeliverymansByName() {
        String name = "updatedDBoy";

        List<Deliveryman> deliverymen = deliverymanController.searchDeliverymansByName(name);

        assertNotNull(deliverymen, "deliverymen should exist.");

        for (Deliveryman dman : deliverymen) {
            System.out.println(dman.getName());
            System.out.println(dman.getPhoneNumber());
        }
    }

}
