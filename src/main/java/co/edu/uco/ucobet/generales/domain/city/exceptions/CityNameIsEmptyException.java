package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class CityNameIsEmptyException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityNameIsEmptyException(final String userMessage, final String technicalMessage,
                                     final TelemetryService telemetryService,
                                     final MessageService messageService) {
        super(userMessage, technicalMessage, new Exception(), telemetryService, messageService);
    }

    public static CityNameIsEmptyException create(TelemetryService telemetryService, MessageService messageService){
        var userMessage = messageService.getMessage("M012");
        var technicalMessage = messageService.getMessage("M030");
        return new CityNameIsEmptyException(userMessage, technicalMessage, telemetryService, messageService);
    }
}
