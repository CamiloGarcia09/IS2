package co.edu.uco.ucobet.generales.application.secondaryports.service.notification;

public interface NotificationService {
    void sendEmail(String to, String subject, String body);
}
