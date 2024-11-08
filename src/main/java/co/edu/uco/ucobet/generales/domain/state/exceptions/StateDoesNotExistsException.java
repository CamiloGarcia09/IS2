package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public final class StateDoesNotExistsException extends RuleUCOBETException {
    private static final long serialVersionUID = 1L;

    private StateDoesNotExistsException(final String userMessage, final String technicalMessage,
                                        final TelemetryService telemetryService) {
        super(userMessage, technicalMessage, new Exception(), telemetryService);

    }

    public static StateDoesNotExistsException create(TelemetryService telemetryService){
        var userMessage = MessageHelper.getMessage("M015");
        var technicalMessage = MessageHelper.getMessage("M033");
        return new StateDoesNotExistsException(userMessage, technicalMessage, telemetryService);
    }
}
