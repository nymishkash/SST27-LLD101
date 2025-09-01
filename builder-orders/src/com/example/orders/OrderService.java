package com.example.orders;

import java.util.List;

public class OrderService {

    public Order createOrder(String id, String email, List<OrderLine> lines, Integer discount, boolean expedited, String notes) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("At least one order line is required");
        }
        Order.Builder builder = new Order.Builder(id, email, lines.get(0))
                .discountPercent(discount)
                .expedited(expedited)
                .notes(notes);
        for (int i = 1; i < lines.size(); i++) {
            builder.addLine(lines.get(i));
        }
        return builder.build();
    }
}
