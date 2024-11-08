package co.edu.uco.ucobet.generales.domain.city.rules.impl;
import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameForStateDoesExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameForStateDoesNotExistsRule;
import org.springframework.stereotype.Service;

@Service
public final class CityNameForStateDoesNotExistRuleImpl implements CityNameForStateDoesNotExistsRule {

    private final CityRepository cityRepository;
    private final TelemetryService telemetryService;
    private final MessageService messageService;

    public CityNameForStateDoesNotExistRuleImpl(final CityRepository cityRepository,
                                                final TelemetryService telemetryService,
                                                final MessageService messageService) {
        this.cityRepository = cityRepository;
        this.telemetryService = telemetryService;
        this.messageService = messageService;
    }

    @Override
    public void validate(CityDomain data) {
        var cityEntityFilter= CityEntity.create().setName(data.getName()).
                setState(StateEntityMapper.INSTANCE.toEntity(data.getState()));
        var resultados= cityRepository.findByFilter(cityEntityFilter);

        if (!resultados.isEmpty()) {
            throw CityNameForStateDoesExistsException.create(telemetryService, messageService);
        }
    }
}
