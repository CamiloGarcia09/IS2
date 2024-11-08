package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.notificationservice;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.notification.NotificationService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.application.secondaryports.vo.EmailVO;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.NotificationUCOBETException;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;


public class NotificationServiceImpl implements NotificationService {

    private final String apiKey;
    private final TelemetryService telemetryService;
    private final MessageService messageService;

    @Value("${adminEmaill}")
    private String adminMail;

    public NotificationServiceImpl(final String apiKey,
                                   final TelemetryService telemetryService,
                                   final MessageService messageService) {
        this.apiKey = apiKey;
        this.telemetryService = telemetryService;
        this.messageService = messageService;
    }

    @Override
    public void sendEmail(EmailVO emailVO) {
        Email from = new Email(adminMail);
        Email recipient = new Email(emailVO.getTo());
        Content content = new Content("text/plain", emailVO.getBody());
        Mail mail = new Mail(from, emailVO.getSubject(), recipient, content);
        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sg.api(request);

        } catch (IOException exception) {
            throw NotificationUCOBETException.create(messageService.getMessage("M059"),
                    messageService.getMessage("M060"), exception, telemetryService);
        }
    }
}