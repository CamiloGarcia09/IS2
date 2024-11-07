package co.edu.uco.ucobet.generales.application.useCase.city.registercity.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.mapper.CityEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
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

    public RegisterNewCityImpl(final CityRepository cityRepository,
                               final RegisterNewCityRulesValidator registerNewCityRulesValidator,
                               final NotificationService notificationService,
                               final TelemetryService telemetryService) {
        this.cityRepository = cityRepository;
        this.registerNewCityRulesValidator = registerNewCityRulesValidator;
        this.notificationService = notificationService;
        this.telemetryService = telemetryService;
    }

    @Override
    public void execute(final CityDomain domain) {

        // Registra evento: Inicio de registro de nueva ciudad
        Map<String, String> startEventProps = new HashMap<>();
        startEventProps.put("CityName", domain.getName());
        telemetryService.trackEvent("RegisterNewCityStarted", startEventProps);

        //Rules validation
        registerNewCityRulesValidator.validate(domain);

        // Evento: Validación de reglas completada
        Map<String, String> validationEventProps = new HashMap<>();
        validationEventProps.put("CityName", domain.getName());
        telemetryService.trackEvent("RegisterNewCityRulesValidated", validationEventProps);

        //Se mappea
        var cityEntity = CityEntityMapper.INSTANCE.toEntity(domain);

        //Save City Entity
        cityRepository.save(cityEntity);

        // Evento: Ciudad guardada en la base de datos
        Map<String, String> saveEventProps = new HashMap<>();
        saveEventProps.put("CityId", cityEntity.getId().toString());
        saveEventProps.put("CityName", cityEntity.getName());
        telemetryService.trackEvent("RegisterNewCitySaved", saveEventProps);


        //Parametros para enviar el correo
        String subject = MessageHelper.getMessage("SUBJECT");
        String template = MessageHelper.getMessage("BODY");
        String cityName = domain.getName();
        String body = template.replace("${cityName}", cityName);
        String toEmail = MessageHelper.getMessage("TOEMAIL");

        EmailVO email = EmailVO.create(toEmail, subject, body);
        notificationService.sendEmail(email);
        //Notificar al administrador sobre la creacion de la nueva ciudad
        //¿Como? Notification building block

        //Tegna en cuenta que:
        //1. El correo del administrador esta en un lugar seguro (KeyVault building block)
        //2. El asunto del correo esta en un lugar parametrizado (Parameters building block)
        //3. El cuerpo del correo esta en un lugar parametrizado (Parameters building block)

        //Cache distribuida Redis

        // Evento: Correo de notificación enviado
        Map<String, String> emailEventProps = new HashMap<>();
        emailEventProps.put("CityName", cityName);
        emailEventProps.put("EmailRecipient", MessageHelper.getMessage("TOEMAIL"));
        telemetryService.trackEvent("RegisterNewCityNotificationSent", emailEventProps);

        // Evento: Fin del proceso de registro de la ciudad
        Map<String, String> endEventProps = new HashMap<>();
        endEventProps.put("CityId", cityEntity.getId().toString());
        endEventProps.put("CityName", cityEntity.getName());
        telemetryService.trackEvent("RegisterNewCityCompleted", endEventProps);
    }
}
