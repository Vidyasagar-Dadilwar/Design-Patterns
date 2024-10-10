class RequestMailHandler extends EmailHandler {
    @Override
    void handleRequest(EmailRequest request) {
        if (request.getType() == EmailType.REQUEST_MAIL) {
            System.out.println("Request Mail Detected");
            System.out.println("Mail has been sent to Bussiness Department");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}