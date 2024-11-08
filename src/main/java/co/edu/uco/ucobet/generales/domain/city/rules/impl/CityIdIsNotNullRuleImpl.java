package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdIsNullException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotNullRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class CityIdIsNotNullRuleImpl implements CityIdIsNotNullRule {

    private final TelemetryService telemetryService;
    private final MessageService messageService;

    public CityIdIsNotNullRuleImpl(final TelemetryService telemetryService,
                                   final MessageService messageService) {
        this.telemetryService = telemetryService;
        this.messageService = messageService;
    }

    @Override
    public void validate(UUID data) {
        if (ObjectHelper.isNull(data)){
            throw CityIdIsNullException.create(telemetryService, messageService);
        }
    }
}