package co.edu.uco.ucobet.generales.application.secondaryports.service.notification;

import co.edu.uco.ucobet.generales.application.secondaryports.vo.EmailVO;

public interface NotificationService {
    void sendEmail(EmailVO emailVO);
}
