package co.edu.uco.ucobet.generales.application.secondaryports.vo;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;

import java.io.File;
import java.util.List;

public final class EmailVO {
    private String to;
    private String subject;
    private String body;
    private List<File> attachments;

    private EmailVO(final String to, final String subject, final String body,
                    final List<File> attachments) {
        setTo(to);
        setSubject(subject);
        setBody(body);
        setAttachments(attachments);
    }

    public static EmailVO create(final String to) {
        return new EmailVO(to, TextHelper.EMPTY, TextHelper.EMPTY, null);
    }

    public static EmailVO create(final String to, final String subject) {
        return new EmailVO(to, subject, TextHelper.EMPTY, null);
    }

    public static EmailVO create(final String to, final String subject, final String body) {
        return new EmailVO(to, subject, body, null);
    }

    public static EmailVO create(final String to, final String subject,
                                 final String body, final List<File> attachments) {
        return new EmailVO(to, subject, body, attachments);
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public List<File> getAttachments() {
        return attachments;
    }

    public void setTo(final String to) {
        this.to = TextHelper.applyTrim(to);
    }

    public void setSubject(final String subject) {
        this.subject = TextHelper.applyTrim(subject);
    }

    public void setBody(final String body) {
        this.body = TextHelper.applyTrim(body);
    }

    public void setAttachments(List<File> attachments) {
        this.attachments = attachments;
    }
}
