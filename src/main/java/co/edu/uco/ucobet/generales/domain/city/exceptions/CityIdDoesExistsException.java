package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public final class CityIdDoesExistsException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityIdDoesExistsException(final String userMessage, final String technicalMessage,
                                      final TelemetryService telemetryService) {
        super(userMessage, technicalMessage, new Exception(), telemetryService);
    }

    public static CityIdDoesExistsException create(TelemetryService telemetryService){
        var userMessage = MessageHelper.getMessage("M006");
        var technicalMessage =MessageHelper.getMessage("M025");
        return new CityIdDoesExistsException(userMessage, technicalMessage, telemetryService);
    }
}
