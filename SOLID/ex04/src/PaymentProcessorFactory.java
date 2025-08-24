public class PaymentProcessorFactory {
    public static PaymentProcessor getProcessor(String provider) {
        switch (provider) {
            case "CARD":
                return new CardPaymentProcessor();
            case "UPI":
                return new UpiPaymentProcessor();
            case "WALLET":
                return new WalletPaymentProcessor();
            default:
                throw new RuntimeException("No provider");
        }
    }
}
