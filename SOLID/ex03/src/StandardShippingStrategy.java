public class StandardShippingStrategy implements ShippingStrategy {
    @Override
    public double calculateCost(double weightKg) {
        return 50 + 5 * weightKg;
    }
}
