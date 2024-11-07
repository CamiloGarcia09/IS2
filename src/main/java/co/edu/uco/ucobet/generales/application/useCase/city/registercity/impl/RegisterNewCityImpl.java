package co.edu.uco.ucobet.generales.application.useCase.city.registercity.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.mapper.CityEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.secondaryports.service.keyvault.VaultService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.notification.NotificationService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.application.secondaryports.vo.EmailVO;
import co.edu.uco.ucobet.generales.application.useCase.city.registercity.RegisterNewCity;
import co.edu.uco.ucobet.generales.application.useCase.city.registercity.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;
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

    public RegisterNewCityImpl(final CityRepository cityRepository,
                               final RegisterNewCityRulesValidator registerNewCityRulesValidator,
                               final NotificationService notificationService,
                               final TelemetryService telemetryService,
                               final VaultService vaultService) {
        this.cityRepository = cityRepository;
        this.registerNewCityRulesValidator = registerNewCityRulesValidator;
        this.notificationService = notificationService;
        this.telemetryService = telemetryService;
        this.vaultService = vaultService;
    }

    @Override
    public void execute(final CityDomain domain) {


        Map<String, String> startEventProps = new HashMap<>();
        startEventProps.put(MessageHelper.getMessage("M042"), domain.getName());
        telemetryService.trackEvent(MessageHelper.getMessage("M043"), startEventProps);


        registerNewCityRulesValidator.validate(domain);


        Map<String, String> validationEventProps = new HashMap<>();
        validationEventProps.put(MessageHelper.getMessage("M042"), domain.getName());
        telemetryService.trackEvent(MessageHelper.getMessage("M044"), validationEventProps);


        var cityEntity = CityEntityMapper.INSTANCE.toEntity(domain);


        cityRepository.save(cityEntity);


        Map<String, String> saveEventProps = new HashMap<>();
        saveEventProps.put(MessageHelper.getMessage("M045"), cityEntity.getId().toString());
        saveEventProps.put(MessageHelper.getMessage("M042"), cityEntity.getName());
        telemetryService.trackEvent(MessageHelper.getMessage("M046"), saveEventProps);


        String subject = vaultService.getSecretValue("SUBJECT");
        String template = vaultService.getSecretValue("BODY");
        String cityName = domain.getName();
        String body = template.replace("${cityName}", cityName);
        String toEmail = vaultService.getSecretValue("TOEMAIL");

        EmailVO email = EmailVO.create(toEmail, subject, body);
        notificationService.sendEmail(email);


        Map<String, String> emailEventProps = new HashMap<>();
        emailEventProps.put(MessageHelper.getMessage("M042"), cityName);
        emailEventProps.put(MessageHelper.getMessage("M047"),
                vaultService.getSecretValue("TOEMAIL"));
        telemetryService.trackEvent(MessageHelper.getMessage("M048"), emailEventProps);


        Map<String, String> endEventProps = new HashMap<>();
        endEventProps.put(MessageHelper.getMessage("M042"), cityEntity.getId().toString());
        endEventProps.put(MessageHelper.getMessage("M042"), cityEntity.getName());
        telemetryService.trackEvent(MessageHelper.getMessage("M049"), endEventProps);
    }
}
