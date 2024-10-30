package co.edu.uco.ucobet.generales.domain;

public final class EmailData {

    private String to;
    private String subject;
    private String content;

    public EmailData(final String to, final String subject, final String content) {
        setTo(to);
        setSubject(subject);
        setContent(content);
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    private void setTo(final String to) {
        this.to = to;
    }

    private void setSubject(final String subject) {
        this.subject = subject;
    }

    private void setContent(final String content) {
        this.content = content;
    }
}
