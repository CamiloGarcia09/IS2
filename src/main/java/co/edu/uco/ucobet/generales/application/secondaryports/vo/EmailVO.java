package co.edu.uco.ucobet.generales.application.secondaryports.vo;

import java.io.File;
import java.util.List;

public class EmailVO {
    private String to;
    private String subject;
    private String body;
    private List<File> attachments;

    private EmailVO(String to, String subject, String body, List<File> attachments) {
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.attachments = attachments;
    }

    public static EmailVO create(String to) {
        return new EmailVO(to, null, null, null);
    }

    public static EmailVO create(String to, String subject) {
        return new EmailVO(to, subject, null, null);
    }

    public static EmailVO create(String to, String subject, String body) {
        return new EmailVO(to, subject, body, null);
    }

    public static EmailVO create(String to, String subject, String body, List<File> attachments) {
        return new EmailVO(to, subject, body, attachments);
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<File> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<File> attachments) {
        this.attachments = attachments;
    }
}
