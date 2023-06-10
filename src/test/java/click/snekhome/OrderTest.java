package click.snekhome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {
    private Order order;

    @BeforeEach
    public void setUp() {
        order = new Order();
    }

    @Test
    public void testAdd() {
        // Create a new clothing
        Clothing clothing = new Clothing("Shirt", "M", "Cotton");

        // Add the clothing to the order
        order.add(clothing);

        // Get the products in the order
        Map<Integer, Product> products = order.getProducts();

        // Assert that the clothing is added to the order
        assertThat(products).containsEntry(clothing.getId(), clothing);
    }

    @Test
    public void testRemove() {
        // Create a new clothing
        Clothing clothing = new Clothing("Shirt", "M", "Cotton");

        // Add the clothing to the order
        order.add(clothing);

        // Get the initial size of the products in the order
        int initialSize = order.getProducts().size();

        // Remove the clothing from the order
        order.remove(clothing.getId());

        // Get the products in the order after removal
        Map<Integer, Product> products = order.getProducts();

        // Assert that the size of the products in the order is decreased by 1
        assertThat(products).hasSize(initialSize - 1);

        // Assert that the clothing is no longer present in the order
        assertThat(products).doesNotContainKey(clothing.getId());
    }



    @Test
    public void testFinish() {
        // Set the status of the order to ACTIVE
        order.setStatus(Status.ACTIVE);

        // Finish the order
        order.finish();

        // Assert that the status of the order is DONE
        assertThat(order.getStatus()).isEqualTo(Status.DONE);
    }

    @Test
    public void testGetOrderCount() {
        // Get the initial order count
        int initialOrderCount = Order.getOrderCount();

        // Create a new order
        Order newOrder = new Order();

        // Get the order count after creating a new order
        int updatedOrderCount = Order.getOrderCount();

        // Assert that the order count is increased by 1
        assertThat(updatedOrderCount).isEqualTo(initialOrderCount + 1);
    }

    @Test
    public void testGetId() {
        // Get the ID of the order
        int orderId = order.getId();

        // Assert that the ID of the order is greater than 0
        assertThat(orderId).isGreaterThan(0);
    }

    @Test
    public void testGetProducts() {
        // Get the products in the order
        Map<Integer, Product> products = order.getProducts();

        // Assert that the products map is initially empty
        assertThat(products).isEmpty();
    }

    @Test
    public void testGetStatus() {
        // Set the status of the order to ACTIVE
        order.setStatus(Status.ACTIVE);

        // Get the status of the order
        Status status = order.getStatus();

        // Assert that the status of the order is ACTIVE
        assertThat(status).isEqualTo(Status.ACTIVE);
    }
}

