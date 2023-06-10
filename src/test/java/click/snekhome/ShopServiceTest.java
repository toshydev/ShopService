package click.snekhome;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopServiceTest {
    private final InputStream originalInput = System.in;
    private final PrintStream originalOutput = System.out;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalInput);
        System.setOut(originalOutput);
    }

    @Test
    public void testRunCustomerMode() {
        String input = "c\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ShopService shopService = new ShopService();
        shopService.run();

        String expectedOutput = "---------------------------\n--- Welcome to SnekShop ---\n---------------------------\n" +
                "Are you a customer or seller? [customer, c | seller, s]\n" + "LIST all items [list, l], ADD an item [add, a], REMOVE an item [remove, r] from/to your cart or view your CART [cart, c]. Quit with [quit, q]";
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }
}
