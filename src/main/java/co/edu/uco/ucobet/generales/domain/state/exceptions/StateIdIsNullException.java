package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class StateIdIsNullException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private StateIdIsNullException(final String userMessage, final String technicalMessage,
                                          final TelemetryService telemetryService,
                                          final MessageService messageService) {
        super(userMessage, technicalMessage, new Exception(), telemetryService, messageService);

    }

    public static StateIdIsNullException create(TelemetryService telemetryService, MessageService messageService){
        var userMessage = messageService.getMessage("M018");
        var technicalMessage = messageService.getMessage("M035");
        return new StateIdIsNullException(userMessage,technicalMessage, telemetryService, messageService);
    }
}
