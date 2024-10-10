class EmailRequest {
    private final String content;
    private final EmailType type;

    public EmailRequest(String content, EmailType type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public EmailType getType() {
        return type;
    }
}

enum EmailType {
    FAN_MAIL, REQUEST_MAIL, COMPLAINT_MAIL, SPAM_MAIL
}