package streams;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class StreamDeepDive {
    public static List<Order> buildOrders() {
        String[] names = {"Aria", "Ben", "Chloe", "Dev", "Esha", "Farhan", "Gina", "Harsh", "Ira", "Jay",
                "Kian", "Leah", "Mira", "Noah", "Omar", "Pia", "Qi", "Ravi", "Sara", "Tara",
                "Uma", "Vik", "Wen", "Xena", "Yash", "Zara"};
        String[] cats = {"Books", "Electronics", "Grocery", "Toys", "Clothing", "Beauty"};
        String[] tags = {"gift", "priority", "bulk", "loyal", "fragile", "promo", "warehouse", "reorder"};
        String[] prod = {"Notebook", "Headphones", "Rice Bag", "Action Figure", "Hoodie", "Lipstick", "Charger",
                "Novel", "Coffee", "Keyboard"};
        Status[] statuses = Status.values();


        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        List<Order> orders = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            String customer = names[rnd.nextInt(names.length)] + " " + (char) ('A' + rnd.nextInt(26)) + ".";


            int itemCount = rnd.nextInt(1, 6); // 1..5 items
            List<OrderItem> items = new ArrayList<>();

            for (int j = 0; j < itemCount; j++) {
                String p = prod[rnd.nextInt(prod.length)];
                String cat = cats[rnd.nextInt(cats.length)];
                int qty = rnd.nextInt(1, 6);
                BigDecimal price = BigDecimal.valueOf(rnd.nextDouble(3.5, 250.0)).setScale(2,
                        java.math.RoundingMode.HALF_UP);
                double disc = rnd.nextDouble() < 0.2 ? rnd.nextDouble(0.05, 0.30) : 0.0; // 20% chance of discount
                items.add(new OrderItem("P" + rnd.nextInt(1000, 9999), p, cat, qty, price, disc));
            }


            int tagCount = rnd.nextInt(0, 4); // 0..3 tags
            Set<String> tagSet = new HashSet<>();
            for (int t = 0; t < tagCount; t++) tagSet.add(tags[rnd.nextInt(tags.length)]);


            Status status = statuses[rnd.nextInt(statuses.length)];
            Instant created = Instant.now().minus(Duration.ofHours(rnd.nextInt(1, 24 * 30))); // within last 30 days
            ZoneId zone = ZoneId.of("Asia/Kolkata");


            orders.add(new Order(i, customer, items, tagSet, status, created, zone));
        }
        return orders;
    }


}
