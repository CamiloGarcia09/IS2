package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIsBeingUseException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIsNotBeingUseRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class CityIsNotBeingUseRuleImpl implements CityIsNotBeingUseRule {

    private final TelemetryService telemetryService;
    private final CityRepository cityRepository;

    public CityIsNotBeingUseRuleImpl(final CityRepository cityRepository, TelemetryService telemetryService) {
        this.cityRepository = cityRepository;
        this.telemetryService = telemetryService;
    }

    @Override
    public void validate(UUID data) {
        if (cityRepository.isCityBeingUsed(data)){
            throw CityIsBeingUseException.create(telemetryService);
        }
    }
}
