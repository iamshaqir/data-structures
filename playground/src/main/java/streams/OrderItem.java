package streams;

import java.math.BigDecimal;

public record OrderItem(String productId, String productName, String category, int quantity, BigDecimal unitPrice,
                        double discount) {


    public BigDecimal lineTotal() {
        BigDecimal gross = unitPrice.multiply(BigDecimal.valueOf(quantity));
        BigDecimal disc = gross.multiply(BigDecimal.valueOf(discount));
        return gross.subtract(disc);
    }


    @Override
    public String toString() {
        return "%s x%d (cat=%s, $%s, disc=%.0f%%)".formatted(productName, quantity, category, unitPrice, discount * 100);
    }
}
