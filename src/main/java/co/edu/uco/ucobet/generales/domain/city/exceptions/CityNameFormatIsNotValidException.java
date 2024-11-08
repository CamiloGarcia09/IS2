package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class CityNameFormatIsNotValidException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityNameFormatIsNotValidException(final String userMessage, final String technicalMessage,
                                              TelemetryService telemetryService,
                                              final MessageService messageService) {
        super(userMessage, technicalMessage, new Exception(), telemetryService, messageService);
    }

    public static CityNameFormatIsNotValidException create(TelemetryService telemetryService, MessageService messageService){
        var userMessage = messageService.getMessage("M010");
        var technicalMessage = messageService.getMessage("M024");
        return new CityNameFormatIsNotValidException(userMessage, technicalMessage, telemetryService, messageService);
    }
}
