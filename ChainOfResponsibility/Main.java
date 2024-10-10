public class Main {
    public static void main(String[] args) {
        EmailHandler FanMailHandler = new FanMailHandler();
        EmailHandler RequestEmailHandler = new RequestMailHandler();
        EmailHandler CompaintMailHandler = new CompaintMailHandler();
        EmailHandler SpamMEmailHandler = new SpamMailHandler();

        FanMailHandler.setNextHandler(RequestEmailHandler);
        RequestEmailHandler.setNextHandler(CompaintMailHandler);
        CompaintMailHandler.setNextHandler(SpamMEmailHandler);
        

        EmailRequest fanMail = new EmailRequest("I am your biggest FAN !!!", EmailType.FAN_MAIL);
        FanMailHandler.handleRequest(fanMail);

        EmailRequest spamMail = new EmailRequest("Spammmm Mailll", EmailType.SPAM_MAIL);
        SpamMEmailHandler.handleRequest(spamMail);

    }
}