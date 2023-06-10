package click.snekhome;

public class Main {
    private final ShopService shop;

    public Main() {
        this.shop = new ShopService();
        shop.run();
    }

    public static void main(String[] args) {
        Main shop = new Main();
    }
}
