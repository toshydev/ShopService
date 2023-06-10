package click.snekhome;

import java.util.Scanner;

public class ShopService {
    private Scanner scanner;
    private ProductRepo productRepo;
    private OrderRepo orderRepo;
    private int currentOrder;
    public ShopService() {
        this.productRepo = new ProductRepo();
        this.orderRepo = new OrderRepo();
        this.scanner = new Scanner(System.in);
    }

    public String getProduct(int id) {
        return productRepo.get(id).toString();
    }

    public void listProducts() {
        System.out.println(productRepo.list().values());
    }

    public void addOrder() {
        if (Order.getOrderCount() < 1) {
            currentOrder = 1;
        } else {
            currentOrder++;
        }
        orderRepo.add(new Order());
    }

    public String getOrder(int id) {
        return orderRepo.get(id).toString();
    }

    public String listOrders() {
        return orderRepo.list().toString();
    }

    public void browse() {
        System.out.println("LIST all items [list, l], ADD an item [add, a], REMOVE an item [remove, r] from/to your cart or view your CART [cart, c]. Quit with [quit, q]");
        if (scanner.hasNext()) {
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.isEmpty()) {
                if (choice.charAt(0) == 'l') {
                    listProducts();
                }
                if (choice.charAt(0) == 'a') {
                    System.out.println("Please enter the ID of an item you want to ADD:");
                    int ID = scanner.nextInt();
                    if (productRepo.getProducts().containsKey(ID)) {
                        orderRepo.get(currentOrder).add(productRepo.get(ID));
                        System.out.printf("Added %s to CART.%n", productRepo.get(ID).getName());
                    } else {
                        System.out.println("Product not found! Please enter an ID from the list.");
                    }
                }
                if (choice.charAt(0) == 'r') {
                    System.out.println("Please enter the ID of an item you want to REMOVE:");
                    int ID = scanner.nextInt();
                    if (productRepo.getProducts().containsKey(ID)) {
                        orderRepo.get(currentOrder).remove(ID);
                    } else {
                        System.out.println("Product not in cart! Please enter an ID from the list.");
                        System.out.println("Your CART:");
                        System.out.println(orderRepo.get(currentOrder).getProducts());
                    }
                }
                if (choice.charAt(0) == 'c') {
                    System.out.println("Your CART:");
                    System.out.println(orderRepo.get(currentOrder).getProducts());
                }
                if (choice.charAt(0) == 'q') {
                    System.out.println("--- Goodbye and thank you for shopping with SnekShop! ---");
                    System.exit(0);
                } else {
                    browse();
                }
            } else {
                browse();
            }
        }
    }

    public void run() {
        String banner = "---------------------------\n--- Welcome to SnekShop ---\n---------------------------";
        System.out.println(banner);
        System.out.println("Are you a customer or seller? [customer, c | seller, s]");
        String mode = scanner.nextLine().toLowerCase();
        if (mode.charAt(0) == 'c') {
            addOrder();
            browse();
        } else if (mode.charAt(0) == 's') {
            System.out.println("under construction...");
            System.exit(0);
        } else {
            run();
        }
    }
}
