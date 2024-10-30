package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.sendgrid;


import co.edu.uco.ucobet.generales.crosscutting.exceptions.SendgridUCOBETException;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EmailSender {

    private final String apiKey;

    public EmailSender(@Value("${keySendgrid}") String apiKey) {
        this.apiKey = apiKey;
    }

    public void sendEmail(String to, String subject, String content) throws SendgridUCOBETException {
        Email from = new Email("zbankproject@gmail.com");
        Email toEmail = new Email(to);
        Content emailContent = new Content("text/plain", content);
        Mail mail = new Mail(from, subject, toEmail, emailContent);

        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");  //Endpoint para enviar los correos
            request.setBody(mail.build());
            Response response = sg.api(request);

            // Opcional: Maneja el log de respuesta para depuración
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException  exception) {
            throw  SendgridUCOBETException.create("Error al enviar el correo");
        }
    }
}