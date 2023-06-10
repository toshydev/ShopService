package click.snekhome;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class Food extends Product {
    private HashSet<String> allergies;
    public Food(String name) {
        super(name);
        this.allergies = new HashSet<>();
    }

    public Food(String name, String... allergies) {
        this(name);
        this.setAllergies(allergies);
    }

    public HashSet<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(String... args) {
        this.allergies.addAll(Arrays.asList(args));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Food food = (Food) o;
        return Objects.equals(allergies, food.allergies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), allergies);
    }
}
