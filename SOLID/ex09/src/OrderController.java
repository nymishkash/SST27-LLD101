public class OrderController {
    private OrderRepository orderRepository;
    
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    public void create(String id) {
        orderRepository.save(id);
        System.out.println("Created order: " + id);
    }
}