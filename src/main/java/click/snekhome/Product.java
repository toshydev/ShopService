package click.snekhome;

import java.util.Objects;

public abstract class Product {
   private static int productCount;
   private String name;
   private int id;

   public Product(String name) {
        this.name = name;
        if(productCount < 0) {
            productCount = 1;
        } else {
            productCount++;
        }
        this.id = productCount;
    }

    public static int getProductCount() {
        return productCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return String.format("ID: %d - '%s'%n", this.id, this.name);
    }
}
