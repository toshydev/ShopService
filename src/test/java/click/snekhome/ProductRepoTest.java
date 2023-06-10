package click.snekhome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductRepoTest {
    private ProductRepo productRepo;

    @BeforeEach
    public void setUp() {
        productRepo = new ProductRepo();
    }

    @Test
    public void testList() {
        Map<Integer, Product> productList = productRepo.list();

        // Assert that the product list is not empty
        assertThat(productList).isNotEmpty();

        // Assert that the product list contains the expected number of products
        assertThat(productList).hasSize(60);
    }

    @Test
    public void testGet() {
        // Get a product from the repository
        Product product = productRepo.list().values().iterator().next();

        // Assert that the returned product is not null
        assertThat(product).isNotNull();

        // Assert that the product can be retrieved using its ID
        assertThat(productRepo.get(product.getId())).isEqualTo(product);
    }

    @Test
    public void testAdd() {
        // Create a new product
        Product newProduct = new Clothing("Shoes", "M", "Leather");

        // Add the new product to the repository
        productRepo.add(newProduct);

        // Get the added product from the repository
        Product addedProduct = productRepo.get(newProduct.getId());

        // Assert that the added product is not null
        assertThat(addedProduct).isNotNull();

        // Assert that the added product is the same as the new product
        assertThat(addedProduct).isEqualTo(newProduct);
    }

    @Test
    public void testRemove() {
        // Get the initial size of the product list
        int initialSize = productRepo.list().size();

        // Get a product from the repository to remove
        Product productToRemove = productRepo.list().values().iterator().next();

        // Remove the product from the repository
        productRepo.remove(productToRemove.getId());

        // Get the product list after removal
        Map<Integer, Product> productList = productRepo.list();

        // Assert that the size of the product list is decreased by 1
        assertThat(productList).hasSize(initialSize - 1);

        // Assert that the removed product is no longer present in the repository
        assertThat(productRepo.get(productToRemove.getId())).isNull();
    }
}
