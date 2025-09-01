package com.example.orders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines;
    private final Integer discountPercent;
    private final boolean expedited;
    private final String notes;

    private Order(String id,
                  String customerEmail,
                  List<OrderLine> lines,
                  Integer discountPercent,
                  boolean expedited,
                  String notes) {
        this.id = id;
        this.customerEmail = customerEmail;
        this.lines = Collections.unmodifiableList(lines);
        this.discountPercent = discountPercent;
        this.expedited = expedited;
        this.notes = notes;
    }

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() { return lines; }
    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }

    public static final class Builder {
        private final String id;
        private final String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        public Builder(String id, String customerEmail, OrderLine firstLine) {
            this.id = id;
            this.customerEmail = customerEmail;
            addLine(firstLine);
        }

        public Builder addLine(OrderLine line) {
            if (line != null) {
                lines.add(line);
            }
            return this;
        }

        public Builder discountPercent(Integer discountPercent) {
            this.discountPercent = discountPercent;
            return this;
        }

        public Builder expedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }

        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public Order build() {
            if (!PricingRules.isValidEmail(customerEmail)) {
                throw new IllegalArgumentException("Invalid email: " + customerEmail);
            }
            if (!PricingRules.isValidDiscount(discountPercent)) {
                throw new IllegalArgumentException("Invalid discount: " + discountPercent);
            }
            if (id == null || id.isEmpty()) {
                throw new IllegalArgumentException("id is required");
            }
            if (lines.isEmpty()) {
                throw new IllegalArgumentException("At least one order line is required");
            }

            List<OrderLine> lineCopies = new ArrayList<>(lines.size());
            for (OrderLine l : lines) {
                if (l == null) continue;
                // defensive copy of each line to avoid external mutations
                lineCopies.add(new OrderLine(l.getSku(), l.getQuantity(), l.getUnitPriceCents()));
            }
            if (lineCopies.isEmpty()) {
                throw new IllegalArgumentException("At least one valid order line is required");
            }

            return new Order(id, customerEmail, lineCopies, discountPercent, expedited, notes);
        }
    }
}
