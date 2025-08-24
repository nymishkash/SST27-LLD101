public class ExpressShippingStrategy implements ShippingStrategy {
    @Override
    public double calculateCost(double weightKg) {
        return 80 + 8 * weightKg;
    }
}
