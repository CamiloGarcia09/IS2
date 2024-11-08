package co.edu.uco.ucobet.generales.application.usecase.city.registercity.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.mapper.CityEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.secondaryports.service.keyvault.VaultService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.notification.NotificationService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.application.secondaryports.vo.EmailVO;
import co.edu.uco.ucobet.generales.application.usecase.city.registercity.RegisterNewCity;
import co.edu.uco.ucobet.generales.application.usecase.city.registercity.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public final class RegisterNewCityImpl implements RegisterNewCity {

    private final CityRepository cityRepository;
    private final RegisterNewCityRulesValidator registerNewCityRulesValidator;
    private final NotificationService notificationService;
    private final TelemetryService telemetryService;
    private final VaultService vaultService;
    private final MessageService messageService;

    public RegisterNewCityImpl(final CityRepository cityRepository,
                               final RegisterNewCityRulesValidator registerNewCityRulesValidator,
                               final NotificationService notificationService,
                               final TelemetryService telemetryService,
                               final VaultService vaultService,
                               final MessageService messageService) {
        this.cityRepository = cityRepository;
        this.registerNewCityRulesValidator = registerNewCityRulesValidator;
        this.notificationService = notificationService;
        this.telemetryService = telemetryService;
        this.vaultService = vaultService;
        this.messageService = messageService;
    }

    @Override
    public void execute(final CityDomain domain) {


        Map<String, String> startEventProps = new HashMap<>();
        startEventProps.put(messageService.getMessage("M042"), domain.getName());
        telemetryService.trackEvent(messageService.getMessage("M043"), startEventProps);


        registerNewCityRulesValidator.validate(domain);


        Map<String, String> validationEventProps = new HashMap<>();
        validationEventProps.put(messageService.getMessage("M042"), domain.getName());
        telemetryService.trackEvent(messageService.getMessage("M044"), validationEventProps);


        var cityEntity = CityEntityMapper.INSTANCE.toEntity(domain);


        cityRepository.save(cityEntity);


        Map<String, String> saveEventProps = new HashMap<>();
        saveEventProps.put(messageService.getMessage("M045"), cityEntity.getId().toString());
        saveEventProps.put(messageService.getMessage("M042"), cityEntity.getName());
        telemetryService.trackEvent(messageService.getMessage("M046"), saveEventProps);


        String subject = vaultService.getSecretValue("SUBJECT");
        String template = vaultService.getSecretValue("BODY");
        String cityName = domain.getName();
        String body = template.replace("${cityName}", cityName);
        String toEmail = vaultService.getSecretValue("TOEMAIL");

        EmailVO email = EmailVO.create(toEmail, subject, body);
        notificationService.sendEmail(email);


        Map<String, String> emailEventProps = new HashMap<>();
        emailEventProps.put(messageService.getMessage("M042"), cityName);
        emailEventProps.put(messageService.getMessage("M047"),
                vaultService.getSecretValue("TOEMAIL"));
        telemetryService.trackEvent(messageService.getMessage("M048"), emailEventProps);


        Map<String, String> endEventProps = new HashMap<>();
        endEventProps.put(messageService.getMessage("M042"), cityEntity.getId().toString());
        endEventProps.put(messageService.getMessage("M042"), cityEntity.getName());
        telemetryService.trackEvent(messageService.getMessage("M049"), endEventProps);
    }
}
