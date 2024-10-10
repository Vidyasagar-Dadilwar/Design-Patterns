class SpamMailHandler extends EmailHandler {
    @Override
    void handleRequest(EmailRequest request) {
        if (request.getType() == EmailType.SPAM_MAIL) {
            System.out.println("Spam email detected");
            System.out.println("Mail got deleted ...");
        }
        // else if(nexthandler!= null){
        // nextHandler.handleRequest(request);
        // }
    }
}