package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesNotExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class CityIdDoesNotExistsRuleImpl implements CityIdDoesNotExistsRule {

    private final TelemetryService telemetryService;
    private final CityRepository cityRepository;
    private final MessageService messageService;

    public CityIdDoesNotExistsRuleImpl(final CityRepository cityRepository,
                                       final TelemetryService telemetryService,
                                       final MessageService messageService) {
        this.cityRepository = cityRepository;
        this.telemetryService = telemetryService;
        this.messageService = messageService;
    }

    @Override
    public void validate(UUID data) {
        if (cityRepository.existsById(data)) {
            throw CityIdDoesExistsException.create(telemetryService, messageService);
        }
    }
}
