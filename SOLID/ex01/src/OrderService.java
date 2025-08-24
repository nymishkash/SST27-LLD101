public class OrderService {
    private TaxCalculator taxCalculator;
    private EmailClient emailClient;
    private OrderRepository orderRepository;

    public OrderService(TaxCalculator taxCalculator, EmailClient emailClient, OrderRepository orderRepository) {
        this.taxCalculator = taxCalculator;
        this.emailClient = emailClient;
        this.orderRepository = orderRepository;
    }

    public void checkout(String customerEmail, double subtotal) {
        double total = taxCalculator.calculateTotalWithTax(subtotal);
        emailClient.send(customerEmail, "Thanks! Your total is " + total);
        orderRepository.save("ORDER-" + System.currentTimeMillis());
    }
}