package com.ms.data.structures.sorting.playground;

public class OnlineRetail implements Comparable<OnlineRetail> {

    private final int invoiceNo;
    private final String stockCode;
    private final String description;
    private final int quantity;
    private final String invoiceData;
    private final double unitPrice;
    private final String customerID;
    private final String country;

    private OnlineRetail(OnlineRetailBuilder builder) {
        this.invoiceNo = builder.invoiceNo;
        this.stockCode = builder.stockCode;
        this.description = builder.description;
        this.quantity = builder.quantity;
        this.invoiceData = builder.invoiceData;
        this.unitPrice = builder.unitPrice;
        this.customerID = builder.customerID;
        this.country = builder.country;
    }

    public String getDescription() {
        return description;
    }

    public static OnlineRetailBuilder builder() {
        return new OnlineRetailBuilder();
    }

    @Override
    public int compareTo(OnlineRetail o) {
        return Double.compare(unitPrice, o.unitPrice);
    }

    @Override
    public String toString() {
        return "OnlineRetail{" +
                "invoiceNo=" + invoiceNo +
                ", stockCode=" + stockCode +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", invoiceData='" + invoiceData + '\'' +
                ", unitPrice=" + unitPrice +
                ", customerID='" + customerID + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public static class OnlineRetailBuilder {
        private int invoiceNo;
        private String stockCode;
        private String description;
        private int quantity;
        private String invoiceData;
        private double unitPrice;
        private String customerID;
        private String country;

        public OnlineRetailBuilder invoiceNo(int invoiceNo) {
            this.invoiceNo = invoiceNo;
            return this;
        }

        public OnlineRetailBuilder stockCode(String stockCode) {
            this.stockCode = stockCode;
            return this;
        }

        public OnlineRetailBuilder description(String description) {
            this.description = description;
            return this;
        }

        public OnlineRetailBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public OnlineRetailBuilder invoiceData(String invoiceData) {
            this.invoiceData = invoiceData;
            return this;
        }

        public OnlineRetailBuilder unitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public OnlineRetailBuilder customerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public OnlineRetailBuilder country(String country) {
            this.country = country;
            return this;
        }

        public OnlineRetail build() {
            return new OnlineRetail(this);
        }
    }

}
