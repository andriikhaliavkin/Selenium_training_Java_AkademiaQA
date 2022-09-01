package enums;

public enum MessageSubject {
    CUSTOMER_SERVICE("Customer service"),
    WEBMASTER("Webmaster");

    private String subject;

    MessageSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
}
