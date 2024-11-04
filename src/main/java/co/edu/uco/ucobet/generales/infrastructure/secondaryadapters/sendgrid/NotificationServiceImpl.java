package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.sendgrid;

import co.edu.uco.ucobet.generales.application.secondaryports.service.notification.NotificationService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.SendgridUCOBETException;
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

    private String apiKey;

    @Value("${adminMail}")
    private String adminMail;

    public NotificationServiceImpl(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        Email from = new Email(adminMail);
        Email recipient = new Email(to);
        Content content = new Content("text/plain", body);
        Mail mail = new Mail(from, subject, recipient, content);
        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);

        } catch (IOException exception) {
            throw  SendgridUCOBETException.create("Error al enviar el correo");
        }
    }


    /*
    public void sendEmail(String to, String subject, String content) throws SendgridUCOBETException {
        Email from = new Email("zbankproject@gmail.com");
        Email toEmail = new Email(to);
        Content emailContent = new Content("text/plain", content);
        Mail mail = new Mail(from, subject, toEmail, emailContent);

        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);

        } catch (IOException  exception) {
            throw  SendgridUCOBETException.create("Error al enviar el correo");
        }
    }

     */
}