package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class StateIdIsDefaultValueException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private StateIdIsDefaultValueException(final String userMessage, final String technicalMessage,
                                          final TelemetryService telemetryService,
                                          final MessageService messageService) {
        super(userMessage, technicalMessage, new Exception(), telemetryService, messageService);

    }

    public static StateIdIsDefaultValueException create(TelemetryService telemetryService, MessageService messageService){
        var userMessage = messageService.getMessage("M017");
        var technicalMessage = messageService.getMessage("M034");
        return new StateIdIsDefaultValueException(userMessage, technicalMessage, telemetryService, messageService);
    }
}
