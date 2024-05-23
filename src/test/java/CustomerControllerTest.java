

import com.example.seokyungkim_s3939114.ConnectionManager;
import com.example.seokyungkim_s3939114.Controller.*;
import com.example.seokyungkim_s3939114.Model.Customer;
import com.example.seokyungkim_s3939114.Request.InsertCustomerRequest;
import com.example.seokyungkim_s3939114.Request.UpdateCustomerRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerControllerTest {
    private CustomerController customerController;

    @BeforeAll
    public void setUp() {
        ConnectionManager.initConnection();
        customerController = new CustomerController();
    }

    @Test
    public void testAddCustomer() {
        InsertCustomerRequest request = new InsertCustomerRequest("John Doe", "123 Main St", "555-1234");

        customerController.addCustomer(request);
    }

    @Test
    public void testUpdateCustomer() {
        UpdateCustomerRequest request = new UpdateCustomerRequest(1, "updatedJohnDoe", "123 Main St", "555-1234");

        customerController.updateCustomer(request);
    }

    @Test
    public void testDeleteCustomer() {
        int id = 1;

        Customer customer = customerController.getCustomerById(id);
        assertNotNull(customer, "Customer should NOT be null");

        customerController.deleteCustomer(customer.getId());

        Customer deletedCustomer = customerController.getCustomerById(customer.getId());
        assertNull(deletedCustomer, "Customer should be null");
    }

    @Test
    public void testSearchCustomersByName() {
        String name = "John Doe";

        List<Customer> customers = customerController.searchCustomersByName(name);

        assertNotNull(customers, "Customers should exist.");

        for (Customer customer : customers) {
            System.out.println(customer.getName());
            System.out.println(customer.getAddress());
        }
    }
}
