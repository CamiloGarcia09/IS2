package co.edu.uco.ucobet.generales.application.primaryports.dto;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;

public class EmailDataDTO {

    private String to;
    private String subject;
    private String content;

    public EmailDataDTO(final String to, final String subject, final String content) {
        setTo(to);
        setSubject(subject);
        setContent(content);
    }

    public static EmailDataDTO create (final String to, final String subject, final String content) {
        return new EmailDataDTO(to, subject,content);
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

    public void setTo(String to) {
        this.to =  TextHelper.applyTrim(to);
    }

    public void setSubject(String subject) {
        this.subject = TextHelper.applyTrim(subject);
    }

    public void setContent(String content) {
        this.content = TextHelper.applyTrim(content);
    }
}
