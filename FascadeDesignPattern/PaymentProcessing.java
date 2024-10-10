public class PaymentProcessing {
    boolean processPayment(String username, double amt){
        System.out.println("Processing the payment of Rs. " + amt + " with username: " + username);
        System.out.println("Payment successful of Rs. " + amt + " with username: " + username);
        return true;
    }
}
