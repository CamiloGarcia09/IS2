package co.edu.uco.ucobet.generales.application.useCase.city.registercity.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.mapper.CityEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.secondaryports.service.notification.NotificationService;
import co.edu.uco.ucobet.generales.application.useCase.city.registercity.RegisterNewCity;
import co.edu.uco.ucobet.generales.application.useCase.city.registercity.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import org.springframework.stereotype.Service;

@Service
public final class RegisterNewCityImpl implements RegisterNewCity {

    private final CityRepository cityRepository;
    private final RegisterNewCityRulesValidator registerNewCityRulesValidator;
    private final NotificationService notificationService;

    public RegisterNewCityImpl(final CityRepository cityRepository,
                               final RegisterNewCityRulesValidator registerNewCityRulesValidator,
                               final NotificationService notificationService) {
        this.cityRepository = cityRepository;
        this.registerNewCityRulesValidator = registerNewCityRulesValidator;
        this.notificationService = notificationService;
    }

    @Override
    public void execute(final CityDomain domain) {

        //Rules validation
        registerNewCityRulesValidator.validate(domain);

        //Se mappea
        var cityEntity = CityEntityMapper.INSTANCE.toEntity(domain);

        //Save City Entity
        cityRepository.save(cityEntity);

        //Parametros para enviar el correo
        String subject = MessageHelper.getMessage("SUBJECT");
        String template = MessageHelper.getMessage("BODY");
        String cityName = domain.getName();
        String body = template.replace("${cityName}", cityName);
        notificationService.sendEmail("juancag0903@gmail.com", subject, body);



        //Notificar al administrador sobre la creacion de la nueva ciudad
        //¿Como? Notification building block

        //Tegna en cuenta que:
        //1. El correo del administrador esta en un lugar seguro (KeyVault building block)
        //2. El asunto del correo esta en un lugar parametrizado (Parameters building block)
        //3. El cuerpo del correo esta en un lugar parametrizado (Parameters building block)

        //Cache distribuida Redis
    }
}
