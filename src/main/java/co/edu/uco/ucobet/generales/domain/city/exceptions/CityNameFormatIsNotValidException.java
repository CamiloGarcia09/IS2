package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public final class CityNameFormatIsNotValidException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityNameFormatIsNotValidException(final String userMessage, final String technicalMessage,
                                              TelemetryService telemetryService) {
        super(userMessage, technicalMessage, new Exception(), telemetryService);
    }

    public static CityNameFormatIsNotValidException create(TelemetryService telemetryService){
        var userMessage = MessageHelper.getMessage("M010");
        var technicalMessage = MessageHelper.getMessage("M024");
        return new CityNameFormatIsNotValidException(userMessage, technicalMessage, telemetryService);
    }
}
