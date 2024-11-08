package co.edu.uco.ucobet.generales.domain.country.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CountryRepository;
import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.domain.country.exceptions.CountryDoesNotExistsException;
import co.edu.uco.ucobet.generales.domain.country.rules.CountryDoesExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class CountryDoesExistsRuleImpl implements CountryDoesExistsRule {

    private final TelemetryService telemetryService;
    private final CountryRepository countryRepository;
    private final MessageService messageService;

    public CountryDoesExistsRuleImpl(final CountryRepository countryRepository,
                                     final TelemetryService telemetryService,
                                     final MessageService messageService) {
        this.countryRepository = countryRepository;
        this.telemetryService = telemetryService;
        this.messageService = messageService;
    }

    @Override
    public void validate(UUID data) {
        if(!countryRepository.existsById(data)) {
            throw CountryDoesNotExistsException.create(telemetryService, messageService);
        }
    }
}
