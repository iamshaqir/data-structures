package utility;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import streams.Order;
import streams.OrderItem;
import streams.StreamDeepDive;

import java.math.BigDecimal;
import java.util.List;

public class StreamDemoTest {

    private static List<Order> orders = null;

    @BeforeAll
    static void beforeAll() {
        orders = StreamDeepDive.buildOrders();
        System.out.println("Sample: " + orders.get(0));
    }


    @Test
    void flatMapTest() {
        List<OrderItem> orderItems = orders.stream()
                .flatMap(order -> order.items().stream())
                .toList();
        
        List<String> sortedProductNames = orders.stream()
                .flatMap(ordersList -> ordersList.items().stream())
                .map(OrderItem::productName)
                .distinct()
                .sorted()
                .limit(5)
                .toList();
    }

    @Test
    void mapTest() {
        List<Long> ids = orders.stream()
                .map(Order::id)
                .toList();

        // Total per order (BigDecimal)
        List<BigDecimal> totals = orders.stream()
                .map(Order::total)
                .toList();
    }
}
