public class OvernightShippingStrategy implements ShippingStrategy {
    @Override
    public double calculateCost(double weightKg) {
        return 120 + 10 * weightKg;
    }
}
