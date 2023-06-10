package click.snekhome;

import java.util.Objects;

public class Clothing extends Product {
    private String size;
    private String material;
    public Clothing(String name) {
        super(name);
    }

    public Clothing(String name, String size) {
        this(name);
        this.size = size;
    }
    public Clothing(String name, String size, String material) {
        this(name, size);
        this.material = material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothing clothing = (Clothing) o;
        return Objects.equals(size, clothing.size) && Objects.equals(material, clothing.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, material);
    }
}
