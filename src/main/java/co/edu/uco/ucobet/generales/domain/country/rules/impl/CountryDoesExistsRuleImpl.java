package co.edu.uco.ucobet.generales.domain.country.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CountryRepository;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.domain.country.exceptions.CountryDoesNotExistsException;
import co.edu.uco.ucobet.generales.domain.country.rules.CountryDoesExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class CountryDoesExistsRuleImpl implements CountryDoesExistsRule {

    private final TelemetryService telemetryService;
    private final CountryRepository countryRepository;

    public CountryDoesExistsRuleImpl(CountryRepository countryRepository, TelemetryService telemetryService) {
        this.countryRepository = countryRepository;
        this.telemetryService = telemetryService;
    }

    @Override
    public void validate(UUID data) {
        if(!countryRepository.existsById(data)) {
            throw CountryDoesNotExistsException.create(telemetryService);
        }
    }
}
