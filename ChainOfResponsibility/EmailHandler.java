abstract class EmailHandler {
    protected EmailHandler nextHandler;

    public void setNextHandler(EmailHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    abstract void handleRequest(EmailRequest request);
}