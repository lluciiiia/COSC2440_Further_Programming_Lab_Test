import com.example.seokyungkim_s3939114.ConnectionManager;
import com.example.seokyungkim_s3939114.Controller.OrderController;
import com.example.seokyungkim_s3939114.Model.Order;
import com.example.seokyungkim_s3939114.Request.InsertOrderRequest;
import com.example.seokyungkim_s3939114.Request.UpdateOrderRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderControllerTest {
    private OrderController orderController;

    @BeforeAll
    public void setUp() {
        ConnectionManager.initConnection();
        orderController = new OrderController();
    }

    @Test
    public void testAddOrder() {
        InsertOrderRequest request = new InsertOrderRequest(2, 2, 50.0);

        orderController.addOrder(request);
    }

    @Test
    public void testUpdateOrder() {
        UpdateOrderRequest request = new UpdateOrderRequest(1, 1, 120.0);

        orderController.updateOrder(request);
    }

    @Test
    public void testDeleteOrder() {
        int id = 1;

        Order order = orderController.getOrderById(id);
        assertNotNull(order, "Order should NOT be null");

        orderController.deleteOrder(order.getId());

        Order deletedOrder = orderController.getOrderById(order.getId());
        assertNull(deletedOrder, "Order should be null");
    }

    @Test
    public void testSearchOrderById() {
        int id = 4;

        Order order = orderController.getOrderById(id);
        assertNotNull(order, "Order should NOT be null");
    }
}
