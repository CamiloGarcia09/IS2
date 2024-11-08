package co.edu.uco.ucobet.generales.domain.country.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.country.exceptions.CountryIdIsDefaultValueException;
import co.edu.uco.ucobet.generales.domain.country.rules.CountryIdIsNotDefaultValueRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class CountryIdIsNotDefaultValueRuleImpl implements CountryIdIsNotDefaultValueRule {

    private final TelemetryService telemetryService;
    private final MessageService messageService;

    public CountryIdIsNotDefaultValueRuleImpl(final TelemetryService telemetryService,
                                              final MessageService messageService) {
        this.telemetryService = telemetryService;
        this.messageService = messageService;
    }

    @Override
    public void validate(UUID data) {
        if (UUIDHelper.isDefault(data)){
            throw CountryIdIsDefaultValueException.create(telemetryService, messageService);
        }
    }
}
