import com.example.orders.*;

public class TryIt {
    public static void main(String[] args) {
        OrderLine l1 = new OrderLine("A", 1, 200);
        OrderLine l2 = new OrderLine("B", 3, 100);

        Order o = new Order.Builder("o2", "a@b.com", l1)
                .addLine(l2)
                .discountPercent(10)
                .build();

        System.out.println("Before external mutation: " + o.totalAfterDiscount());
        l1.setQuantity(999); // external mutation should not affect order totals now
        System.out.println("After external mutation:  " + o.totalAfterDiscount());
    }
}
