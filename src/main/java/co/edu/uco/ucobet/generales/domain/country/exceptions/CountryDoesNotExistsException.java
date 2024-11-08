package co.edu.uco.ucobet.generales.domain.country.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public final class CountryDoesNotExistsException extends RuleUCOBETException {
    private static final long serialVersionUID = 1L;

    private CountryDoesNotExistsException(final String userMessage, final String technicalMessage,
                                          final TelemetryService telemetryService) {
        super(userMessage, technicalMessage, new Exception(), telemetryService);

    }

    public static CountryDoesNotExistsException create(TelemetryService telemetryService){
        var userMessage = MessageHelper.getMessage("M036");
        var technicalMessage = MessageHelper.getMessage("M037");
        return new CountryDoesNotExistsException(userMessage, technicalMessage,telemetryService);
    }

}