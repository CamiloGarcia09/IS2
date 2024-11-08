package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public final class CityNameForStateDoesExistsException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityNameForStateDoesExistsException(final String userMessage, final String technicalMessage,
                                                final TelemetryService telemetryService) {
        super(userMessage, technicalMessage, new Exception(),telemetryService);
    }

    public static CityNameForStateDoesExistsException create(TelemetryService telemetryService){
        var userMessage = MessageHelper.getMessage("M011");
        var technicalMessage = MessageHelper.getMessage("M029");
        return new CityNameForStateDoesExistsException(userMessage, technicalMessage, telemetryService);
    }
}
