package click.snekhome;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FoodTest {

    @Test
    void testEqualsAndHashCode() {
        Food food1 = new Food("Apple");
        food1.setId(1);

        Food food2 = new Food("Apple");
        food2.setId(1);

        Food food3 = new Food("Banana");
        food3.setId(2);

        // Test equals()
        assertThat(food1).isEqualTo(food2);
        assertThat(food1).isNotEqualTo(food3);

        // Test hashCode()
        assertThat(food1.hashCode()).isEqualTo(food2.hashCode());
        assertThat(food1.hashCode()).isNotEqualTo(food3.hashCode());
    }

    @Test
    void testGettersAndSetters() {
        Food food = new Food("Pizza");
        food.setAllergies("Gluten", "Dairy");

        // Test getAllergies()
        assertThat(food.getAllergies()).containsExactlyInAnyOrder("Gluten", "Dairy");
    }
}

