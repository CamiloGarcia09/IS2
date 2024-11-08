package co.edu.uco.ucobet.generales.domain.country.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.country.exceptions.CountryIdIsNullException;
import co.edu.uco.ucobet.generales.domain.country.rules.CountryIdIsNotNullRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class CountryIdIsNotNullRuleImpl implements CountryIdIsNotNullRule {

    private final TelemetryService telemetryService;
    private final MessageService messageService;

    public CountryIdIsNotNullRuleImpl(TelemetryService telemetryService,
                                      final MessageService messageService) {
        this.telemetryService = telemetryService;
        this.messageService = messageService;
    }

    @Override
    public void validate(UUID data) {
        if (ObjectHelper.isNull(data)){
            throw CountryIdIsNullException.create(telemetryService, messageService);
        }
    }
}
