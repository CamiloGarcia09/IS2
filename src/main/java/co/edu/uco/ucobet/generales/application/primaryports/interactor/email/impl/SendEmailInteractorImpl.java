package co.edu.uco.ucobet.generales.application.primaryports.interactor.email.impl;

import co.edu.uco.ucobet.generales.application.primaryports.dto.SendEmailDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.email.SendEmailInteractor;
import co.edu.uco.ucobet.generales.application.primaryports.mapper.EmailDTOMapper;
import co.edu.uco.ucobet.generales.application.useCase.email.SendEmail;
import co.edu.uco.ucobet.generales.domain.EmailData;
import org.springframework.stereotype.Service;


@Service
public class SendEmailInteractorImpl implements SendEmailInteractor {

    private final SendEmail sendEmail;

    public SendEmailInteractorImpl(SendEmail sendEmail) {
        this.sendEmail = sendEmail;
    }

    @Override
    public void execute(SendEmailDTO sendEmailDTO) {
        // Usando la instancia estática del mapper
        EmailData emailData = EmailDTOMapper.INSTANCE.toDomain(sendEmailDTO);
        // Llamada al caso de uso
        sendEmail.execute(emailData);
    }
}