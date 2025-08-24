
public class PaymentService {
    public String pay(Payment p) {
        PaymentProcessor processor = PaymentProcessorFactory.getProcessor(p.provider);
        return processor.processPayment(p.amount);
    }
}