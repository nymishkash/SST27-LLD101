public class ShippingStrategyFactory {
    public static ShippingStrategy getStrategy(String type) {
        switch (type) {
            case "STANDARD":
                return new StandardShippingStrategy();
            case "EXPRESS":
                return new ExpressShippingStrategy();
            case "OVERNIGHT":
                return new OvernightShippingStrategy();
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
