package click.snekhome;

import java.util.HashMap;
import java.util.Map;

public class ProductRepo extends Repo {
    private Map<Integer, Product> products;
    public ProductRepo() {
        this.products = new HashMap<>();
        Product[] productArray = new Product[60];
        productArray[0] = new Clothing("Shirt", "M", "Cotton");
        productArray[1] = new Clothing("Pants", "L", "Denim");
        productArray[2] = new Clothing("Dress", "S", "Silk");
        productArray[3] = new Clothing("Sweater", "XL", "Wool");
        productArray[4] = new Clothing("Jeans", "M", "Denim");
        productArray[5] = new Clothing("T-Shirt", "S", "Cotton");
        productArray[6] = new Clothing("Jacket", "L", "Leather");
        productArray[7] = new Clothing("Skirt", "M", "Cotton");
        productArray[8] = new Clothing("Shorts", "S", "Polyester");
        productArray[9] = new Clothing("Blouse", "L", "Silk");
        productArray[10] = new Clothing("Hoodie", "M", "Cotton");
        productArray[11] = new Clothing("Sweatpants", "XL", "Fleece");
        productArray[12] = new Clothing("Cardigan", "S", "Wool");
        productArray[13] = new Clothing("Tank Top", "M", "Cotton");
        productArray[14] = new Clothing("Coat", "L", "Wool");
        productArray[15] = new Clothing("Leggings", "S", "Spandex");
        productArray[16] = new Clothing("Blazer", "M", "Polyester");
        productArray[17] = new Clothing("Trousers", "L", "Cotton");
        productArray[18] = new Clothing("Hooded Sweatshirt", "XL", "Cotton");
        productArray[19] = new Clothing("Vest", "S", "Polyester");
        productArray[20] = new Food("Apple");
        productArray[21] = new Food("Banana", "Gluten");
        productArray[22] = new Food("Orange", "Citrus");
        productArray[23] = new Food("Bread", "Wheat", "Gluten");
        productArray[24] = new Food("Milk", "Lactose");
        productArray[25] = new Food("Eggs");
        productArray[26] = new Food("Cheese", "Lactose");
        productArray[27] = new Food("Chicken");
        productArray[28] = new Food("Beef");
        productArray[29] = new Food("Fish", "Seafood");
        productArray[30] = new Food("Rice");
        productArray[31] = new Food("Pasta", "Wheat", "Gluten");
        productArray[32] = new Food("Tomato");
        productArray[33] = new Food("Cucumber");
        productArray[34] = new Food("Carrot");
        productArray[35] = new Food("Potato");
        productArray[36] = new Food("Broccoli");
        productArray[37] = new Food("Spinach", "Oxalates");
        productArray[38] = new Food("Strawberries");
        productArray[39] = new Food("Blueberries");
        productArray[40] = new Electronics("Phone", "iPhone 12", "Apple");
        productArray[41] = new Electronics("Laptop", "MacBook Pro", "Apple");
        productArray[42] = new Electronics("TV", "Samsung QLED", "Samsung");
        productArray[43] = new Electronics("Headphones", "Sony WH-1000XM4", "Sony");
        productArray[44] = new Electronics("Smartwatch", "Apple Watch Series 6", "Apple");
        productArray[45] = new Electronics("Camera", "Nikon D850", "Nikon");
        productArray[46] = new Electronics("Tablet", "iPad Air", "Apple");
        productArray[47] = new Electronics("Speaker", "Sonos One", "Sonos");
        productArray[48] = new Electronics("Gaming Console", "PlayStation 5", "Sony");
        productArray[49] = new Electronics("Monitor", "Dell Ultrasharp U2719D", "Dell");
        productArray[50] = new Electronics("Router", "TP-Link Archer A7", "TP-Link");
        productArray[51] = new Electronics("Smart Speaker", "Amazon Echo Dot", "Amazon");
        productArray[52] = new Electronics("Keyboard", "Logitech G Pro", "Logitech");
        productArray[53] = new Electronics("Mouse", "Razer DeathAdder V2", "Razer");
        productArray[54] = new Electronics("Earphones", "Jabra Elite 75t", "Jabra");
        productArray[55] = new Electronics("Printer", "Epson EcoTank ET-4760", "Epson");
        productArray[56] = new Electronics("External Hard Drive", "Seagate Backup Plus", "Seagate");
        productArray[57] = new Electronics("Smart Thermostat", "Nest Learning Thermostat", "Google");
        productArray[58] = new Electronics("Wireless Charger", "Anker PowerWave", "Anker");
        productArray[59] = new Electronics("Fitness Tracker", "Fitbit Charge 4", "Fitbit");
        for (Product product : productArray) {
            products.put(product.getId(), product);
        }
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public Map<Integer, Product> list() {
        return products;
    }

    @Override
    public Product get(int id) {
        return products.get(id);
    }

    @Override
    public void add(Object obj) {
        if (obj instanceof Product) {
            products.put(((Product) obj).getId(), (Product) obj);
        }
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    public static void main(String[] args) {
        ProductRepo pr = new ProductRepo();
        Product product = pr.get(1);
        System.out.println(product);
    }
}
