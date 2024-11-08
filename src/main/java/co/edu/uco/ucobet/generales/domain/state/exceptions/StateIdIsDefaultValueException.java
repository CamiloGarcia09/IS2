package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public final class StateIdIsDefaultValueException extends RuleUCOBETException {
    private static final long serialVersionUID = 1L;

    private StateIdIsDefaultValueException(final String userMessage, final String technicalMessage,
                                           final TelemetryService telemetryService) {
        super(userMessage, technicalMessage, new Exception(), telemetryService);

    }

    public static StateIdIsDefaultValueException create(TelemetryService telemetryService){
        var userMessage = MessageHelper.getMessage("M017");
        var technicalMessage = MessageHelper.getMessage("M034");
        return new StateIdIsDefaultValueException(userMessage, technicalMessage, telemetryService);
    }
}
