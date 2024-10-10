class CompaintMailHandler extends EmailHandler {
    @Override
    void handleRequest(EmailRequest request) {
        if (request.getType() == EmailType.COMPLAINT_MAIL) {
            System.out.println("Complaint Mail Detected");
            System.out.println("Mail has been sent to Customer Services");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}