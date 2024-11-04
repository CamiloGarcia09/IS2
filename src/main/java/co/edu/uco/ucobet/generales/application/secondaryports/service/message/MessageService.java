package co.edu.uco.ucobet.generales.application.secondaryports.service.message;

public interface MessageService {
    String getMessage(String key);
    String getMessage(String key, String defaultMessage);
    void setMessage(String key, String message);
}