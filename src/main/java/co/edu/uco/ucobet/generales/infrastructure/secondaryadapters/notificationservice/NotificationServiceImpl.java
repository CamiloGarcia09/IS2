package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.notificationservice;

import co.edu.uco.ucobet.generales.application.secondaryports.service.notification.NotificationService;
import co.edu.uco.ucobet.generales.application.secondaryports.vo.EmailVO;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.NotificationUCOBETException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;


public class NotificationServiceImpl implements NotificationService {

    private final String apiKey;

    @Value("${adminMail}")
    private String adminMail;

    public NotificationServiceImpl(String apiKey) {
        this.apiKey = apiKey;
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
            Response response = sg.api(request);

        } catch (IOException exception) {
            throw NotificationUCOBETException.create(MessageHelper.getMessage("M059"),
                    MessageHelper.getMessage("M060"), exception);
        }
    }
}