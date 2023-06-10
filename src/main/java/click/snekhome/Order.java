package click.snekhome;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private static int orderCount;
    private int id;
    private Map<Integer, Product> products;
    private Status status;

    public Order() {
        if (orderCount < 1) {
            orderCount = 1;
        } else {
            orderCount++;
        }
        this.id = orderCount;
        this.products = new HashMap<>();
        setStatus(Status.ACTIVE);
    }

    public void add(Product product) {
        this.products.put(product.getId(), product);
    }

    public void remove(int id) {
        this.products.remove(id);
    }

    public void finish() {
        setStatus(Status.DONE);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static int getOrderCount() {
        return orderCount;
    }

    public int getId() {
        return id;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("Order-ID: %d - %s", this.getId(), this.getStatus());
    }
}
