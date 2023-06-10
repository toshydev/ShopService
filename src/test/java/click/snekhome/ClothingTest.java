package click.snekhome;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClothingTest {

    @Test
    void testEqualsAndHashCode() {
        Clothing clothing1 = new Clothing("Shirt", "M", "Cotton");
        clothing1.setId(1);

        Clothing clothing2 = new Clothing("Shirt", "M", "Cotton");
        clothing2.setId(1);

        Clothing clothing3 = new Clothing("Pants", "S", "Denim");
        clothing3.setId(2);

        // Test equals()
        assertThat(clothing1).isEqualTo(clothing2);
        assertThat(clothing1).isNotEqualTo(clothing3);

        // Test hashCode()
        assertThat(clothing1.hashCode()).isEqualTo(clothing2.hashCode());
        assertThat(clothing1.hashCode()).isNotEqualTo(clothing3.hashCode());
    }

    @Test
    void testGettersAndSetters() {
        Clothing clothing = new Clothing("Shirt", "L", "Polyester");

        // Test getSize() and setSize()
        assertThat(clothing.getSize()).isEqualTo("L");
        clothing.setSize("XL");
        assertThat(clothing.getSize()).isEqualTo("XL");

        // Test getMaterial() and setMaterial()
        assertThat(clothing.getMaterial()).isEqualTo("Polyester");
        clothing.setMaterial("Cotton");
        assertThat(clothing.getMaterial()).isEqualTo("Cotton");
    }

    @Test
    void testProductCount() {
        int initialCount = Product.getProductCount();
        Clothing clothing1 = new Clothing("Shirt", "M", "Cotton");
        assertThat(Product.getProductCount()).isEqualTo(initialCount + 1);

        Clothing clothing2 = new Clothing("Pants", "S", "Denim");
        assertThat(Product.getProductCount()).isEqualTo(initialCount + 2);
    }
}
