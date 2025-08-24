
public class Demo01 {
    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator();
        EmailClient emailClient = new EmailClient();
        OrderRepository orderRepository = new DatabaseOrderRepository();
        
        OrderService orderService = new OrderService(taxCalculator, emailClient, orderRepository);
        orderService.checkout("a@shop.com", 100.0);
    }
}
