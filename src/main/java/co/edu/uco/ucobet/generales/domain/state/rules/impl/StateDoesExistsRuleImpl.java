package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateDoesNotExistsException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class StateDoesExistsRuleImpl implements StateDoesExistsRule {

    private final TelemetryService telemetryService;
    private final StateRepository stateRepository;

    public StateDoesExistsRuleImpl(StateRepository stateRepository, TelemetryService telemetryService) {
        this.stateRepository = stateRepository;
        this.telemetryService = telemetryService;
    }

    @Override
    public void validate(UUID data) {
       if(!stateRepository.existsById(data)) {
           throw StateDoesNotExistsException.create(telemetryService);
        }
    }
}
