package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesNotExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class CityIdDoesExistsRuleImpl implements CityIdDoesExistsRule {

    private final TelemetryService telemetryService;
    private final CityRepository cityRepository;

    public CityIdDoesExistsRuleImpl(final CityRepository cityRepository,TelemetryService telemetryService) {
        this.cityRepository = cityRepository;
        this.telemetryService = telemetryService;
    }

    @Override
    public void validate(final UUID data) {
        if (!cityRepository.existsById(data)) {
            throw CityIdDoesNotExistsException.create(telemetryService);
        }
    }
}
