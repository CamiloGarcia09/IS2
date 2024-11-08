package co.edu.uco.ucobet.generales.domain.country.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public final class CountryIdIsNullException extends RuleUCOBETException {
    private static final long serialVersionUID = 1L;

    private CountryIdIsNullException(final String userMessage, final String technicalMessage,
                                     final TelemetryService telemetryService) {
        super(userMessage, technicalMessage, new Exception(), telemetryService);

    }

    public static CountryIdIsNullException create(TelemetryService telemetryService){
        var userMessage = MessageHelper.getMessage("M040");
        var technicalMessage = MessageHelper.getMessage("M041");
        return new CountryIdIsNullException(userMessage,technicalMessage, telemetryService);
    }
}
