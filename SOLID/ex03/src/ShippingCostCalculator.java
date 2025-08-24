public class ShippingCostCalculator {
    public double cost(Shipment s) {
        ShippingStrategy strategy = ShippingStrategyFactory.getStrategy(s.type);
        return strategy.calculateCost(s.weightKg);
    }
}
