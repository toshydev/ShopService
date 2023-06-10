package click.snekhome;

import java.util.HashMap;
import java.util.Map;

public class OrderRepo extends Repo {
    private Map<Integer, Order> orders;
    public OrderRepo() {
        this.orders = new HashMap<>();
    }

    public Map<Integer, Order> list() {
        return orders;
    }

    @Override
    public Order get(int id) {
       return orders.get(id);
    }

    @Override
    public void add(Object obj) {
        if (obj instanceof Order) {
            orders.put(((Order) obj).getId(), (Order) obj);
        }
    }

    @Override
    public void remove(int id) {
        orders.remove(id);
    }

    public static void main(String[] args) {
        ProductRepo pr = new ProductRepo();
        Order o1 = new Order();
        o1.add(pr.get(12));
        OrderRepo or = new OrderRepo();
        or.add(o1);
        System.out.println(or.list());
        o1.add(pr.get(55));
        o1.add(pr.get(40));
        o1.finish();
        System.out.println(or.list());
        System.out.println(or.get(1).getProducts());

    }
}
