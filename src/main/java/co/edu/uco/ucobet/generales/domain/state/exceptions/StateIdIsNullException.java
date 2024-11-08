package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public final class StateIdIsNullException extends RuleUCOBETException {
    private static final long serialVersionUID = 1L;

    private StateIdIsNullException(final String userMessage, final String technicalMessage,
                                   final TelemetryService telemetryService) {
        super(userMessage, technicalMessage, new Exception(), telemetryService);

    }

    public static StateIdIsNullException create(TelemetryService telemetryService){
        var userMessage = MessageHelper.getMessage("M018");
        var technicalMessage = MessageHelper.getMessage("M035");
        return new StateIdIsNullException(userMessage,technicalMessage, telemetryService);
    }
}
