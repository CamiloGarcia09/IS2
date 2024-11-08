package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateIdIsNullException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotNullRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class StateIdIsNotNullRuleImpl implements StateIdIsNotNullRule {

    private final TelemetryService telemetryService;

    public StateIdIsNotNullRuleImpl(TelemetryService telemetryService) {
        this.telemetryService = telemetryService;
    }

    @Override
    public void validate(UUID data) {
        if (ObjectHelper.isNull(data)){
            throw StateIdIsNullException.create(telemetryService);
        }
    }
}
