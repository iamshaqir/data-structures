package streams;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import java.util.Set;

public record Order(long id, String customerName, List<OrderItem> items,
                    Set<String> tags, Status status,
                    Instant createdAt, ZoneId zone) {
    public Order(long id, String customerName, List<OrderItem> items, Set<String> tags, Status status,
                 Instant createdAt, ZoneId zone) {
        this.id = id;
        this.customerName = customerName;
        this.items = List.copyOf(items);
        this.tags = Set.copyOf(tags);
        this.status = status;
        this.createdAt = createdAt;
        this.zone = zone;
    }


    public BigDecimal total() {
        return items.stream()
                .map(OrderItem::lineTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    @Override
    public String toString() {
        return "Order#" + id + " {" + customerName + ", items=" + items.size() + ", tags=" + tags + ", status=" + status + "}";
    }
}
