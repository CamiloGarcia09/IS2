package co.edu.uco.ucobet.generales.domain.state.rules.impl;
import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateIdIsDefaultValueException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotDefaultValueRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class StateIdIsNotDefaultValueRuleImpl implements StateIdIsNotDefaultValueRule {

    private final TelemetryService telemetryService;
    private final MessageService messageService;

    public StateIdIsNotDefaultValueRuleImpl(final TelemetryService telemetryService,
                                            final MessageService messageService) {
        this.telemetryService = telemetryService;
        this.messageService = messageService;
    }

    @Override
    public void validate(UUID data) {
        if (UUIDHelper.isDefault(data)){
            throw StateIdIsDefaultValueException.create(telemetryService, messageService);
        }
    }
}
