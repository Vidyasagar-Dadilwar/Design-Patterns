public class StreamingFacade {
    private UserAccount userAccount;
    private MovieSelection movieSelection;
    private StreamingServices streamingServices;
    private PaymentProcessing paymentProcessing;

    public StreamingFacade() {
        userAccount = new UserAccount();
        movieSelection = new MovieSelection();
        streamingServices = new StreamingServices();
        paymentProcessing = new PaymentProcessing();
    }

    public void streamMovie(String userId, String movieTitle, double amount) {
        if (userAccount.checkSubscription(userId)) {
            movieSelection.selectMovie(movieTitle);
            if (paymentProcessing.processPayment(userId, amount)) {
                streamingServices.prepareStream(movieTitle);
                streamingServices.startStream();
            } else {
                System.out.println("Payment processing failed.");
            }
        } else {
            System.out.println("Subscription check failed.");
        }
    }
}