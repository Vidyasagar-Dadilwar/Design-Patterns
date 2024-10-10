class FanMailHandler extends EmailHandler {
    @Override
    void handleRequest(EmailRequest request) {
        if (request.getType() == EmailType.FAN_MAIL) {
            System.out.println("Fan Mail Detected");
            System.out.println("Mail has been sent to CEO... ");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}