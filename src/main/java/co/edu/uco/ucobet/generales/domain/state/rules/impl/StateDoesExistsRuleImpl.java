package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateDoesNotExistsException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class StateDoesExistsRuleImpl implements StateDoesExistsRule {

    private final TelemetryService telemetryService;
    private final StateRepository stateRepository;
    private final MessageService messageService;

    public StateDoesExistsRuleImpl(final StateRepository stateRepository,
                                   final TelemetryService telemetryService,
                                   final MessageService messageService) {
        this.stateRepository = stateRepository;
        this.telemetryService = telemetryService;
        this.messageService = messageService;
    }

    @Override
    public void validate(UUID data) {
       if(!stateRepository.existsById(data)) {
           throw StateDoesNotExistsException.create(telemetryService, messageService);
        }
    }
}
