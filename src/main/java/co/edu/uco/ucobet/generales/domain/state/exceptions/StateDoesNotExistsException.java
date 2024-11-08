package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class StateDoesNotExistsException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private StateDoesNotExistsException(final String userMessage, final String technicalMessage,
                                          final TelemetryService telemetryService,
                                          final MessageService messageService) {
        super(userMessage, technicalMessage, new Exception(), telemetryService, messageService);

    }

    public static StateDoesNotExistsException create(TelemetryService telemetryService, MessageService messageService){
        var userMessage = messageService.getMessage("M015");
        var technicalMessage = messageService.getMessage("M033");
        return new StateDoesNotExistsException(userMessage, technicalMessage, telemetryService, messageService);
    }
}
