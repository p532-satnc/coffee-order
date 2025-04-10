package edu.iu.habahram.coffeeorder;
import edu.iu.habahram.coffeeorder.model.OrderData;
import edu.iu.habahram.coffeeorder.model.Receipt;
import edu.iu.habahram.coffeeorder.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class OrderRepositoryTest {
    private OrderRepository orderRepository;

    @BeforeEach
    public void setUp() {
        orderRepository = new OrderRepository();
    }

    private void assertReceipt(Receipt receipt, String expectedBeverage, List<String> condiments) {
        assertNotNull(receipt);
        assertTrue(receipt.id() > 0);
        assertTrue(receipt.description().toLowerCase().contains(expectedBeverage.toLowerCase()));
        for (String condiment : condiments) {
            assertTrue(receipt.description().toLowerCase().contains(condiment.toLowerCase()));
        }
        assertTrue(receipt.cost() > 0);
    }

    @Test
    public void testDarkRoastWithMilk() throws Exception {
        Receipt receipt = orderRepository.add(new OrderData("Dark Roast", List.of("Milk")));
        assertReceipt(receipt, "Dark Roast", List.of("Milk"));
    }

    @Test
    public void testDarkRoastWithMocha() throws Exception {
        Receipt receipt = orderRepository.add(new OrderData("Dark Roast", List.of("Mocha")));
        assertReceipt(receipt, "Dark Roast", List.of("Mocha"));
    }

    @Test
    public void testDarkRoastWithSoy() throws Exception {
        Receipt receipt = orderRepository.add(new OrderData("Dark Roast", List.of("Soy")));
        assertReceipt(receipt, "Dark Roast", List.of("Soy"));
    }

    @Test
    public void testDarkRoastWithWhip() throws Exception {
        Receipt receipt = orderRepository.add(new OrderData("Dark Roast", List.of("Whip")));
        assertReceipt(receipt, "Dark Roast", List.of("Whip"));
    }

    @Test
    public void testHouseBlendWithMilk() throws Exception {
        Receipt receipt = orderRepository.add(new OrderData("House Blend", List.of("Milk")));
        assertReceipt(receipt, "House Blend", List.of("Milk"));
    }

    @Test
    public void testHouseBlendWithMocha() throws Exception {
        Receipt receipt = orderRepository.add(new OrderData("House Blend", List.of("Mocha")));
        assertReceipt(receipt, "House Blend", List.of("Mocha"));
    }

    @Test
    public void testHouseBlendWithSoy() throws Exception {
        Receipt receipt = orderRepository.add(new OrderData("House Blend", List.of("Soy")));
        assertReceipt(receipt, "House Blend", List.of("Soy"));
    }

    @Test
    public void testHouseBlendWithWhip() throws Exception {
        Receipt receipt = orderRepository.add(new OrderData("House Blend", List.of("Whip")));
        assertReceipt(receipt, "House Blend", List.of("Whip"));
    }

    @Test
    public void testEspressoWithMilk() throws Exception {
        Receipt receipt = orderRepository.add(new OrderData("Espresso", List.of("Milk")));
        assertReceipt(receipt, "Espresso", List.of("Milk"));
    }

    @Test
    public void testEspressoWithMocha() throws Exception {
        Receipt receipt = orderRepository.add(new OrderData("Espresso", List.of("Mocha")));
        assertReceipt(receipt, "Espresso", List.of("Mocha"));
    }

    @Test
    public void testEspressoWithSoy() throws Exception {
        Receipt receipt = orderRepository.add(new OrderData("Espresso", List.of("Soy")));
        assertReceipt(receipt, "Espresso", List.of("Soy"));
    }

    @Test
    public void testEspressoWithWhip() throws Exception {
        Receipt receipt = orderRepository.add(new OrderData("Espresso", List.of("Whip")));
        assertReceipt(receipt, "Espresso", List.of("Whip"));
    }

    @Test
    public void testDecafWithMilk() throws Exception {
        Receipt receipt = orderRepository.add(new OrderData("Decaf", List.of("Milk")));
        assertReceipt(receipt, "Decaf", List.of("Milk"));
    }

    @Test
    public void testDecafWithMocha() throws Exception {
        Receipt receipt = orderRepository.add(new OrderData("Decaf", List.of("Mocha")));
        assertReceipt(receipt, "Decaf", List.of("Mocha"));
    }

    @Test
    public void testDecafWithSoy() throws Exception {
        Receipt receipt = orderRepository.add(new OrderData("Decaf", List.of("Soy")));
        assertReceipt(receipt, "Decaf", List.of("Soy"));
    }

    @Test
    public void testDecafWithWhip() throws Exception {
        Receipt receipt = orderRepository.add(new OrderData("Decaf", List.of("Whip")));
        assertReceipt(receipt, "Decaf", List.of("Whip"));
    }
}



