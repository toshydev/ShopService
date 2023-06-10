package click.snekhome;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ElectronicsTest {

    @Test
    void testEqualsAndHashCode() {
        Electronics electronics1 = new Electronics("Phone", "Model1", "Manufacturer");
        electronics1.setId(1);

        Electronics electronics2 = new Electronics("Phone", "Model1", "Manufacturer");
        electronics2.setId(1);

        Electronics electronics3 = new Electronics("Laptop", "Model2", "Manufacturer");
        electronics3.setId(2);

        // Test equals()
        assertThat(electronics1).isEqualTo(electronics2);
        assertThat(electronics1).isNotEqualTo(electronics3);

        // Test hashCode()
        assertThat(electronics1.hashCode()).isEqualTo(electronics2.hashCode());
        assertThat(electronics1.hashCode()).isNotEqualTo(electronics3.hashCode());
    }

    @Test
    void testGettersAndSetters() {
        Electronics electronics = new Electronics("TV");
        electronics.setModel("Model1");
        electronics.setManufacturer("Manufacturer");

        // Test getManufacturer()
        assertThat(electronics.getManufacturer()).isEqualTo("Manufacturer");

        // Test getModel()
        assertThat(electronics.getModel()).isEqualTo("Model1");
    }
}

