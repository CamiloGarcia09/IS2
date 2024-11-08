package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class CityNameLenghtIsNotValidException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityNameLenghtIsNotValidException(final String userMessage, final String technicalMessage,
                                              final TelemetryService telemetryService,
                                              final MessageService messageService) {
        super(userMessage, technicalMessage, new Exception(), telemetryService, messageService);
    }

    public static CityNameLenghtIsNotValidException create(TelemetryService telemetryService, MessageService messageService){
        var userMessage = messageService.getMessage("M014");
        var technicalMessage = messageService.getMessage("M032");
        return new CityNameLenghtIsNotValidException(userMessage, technicalMessage, telemetryService, messageService);
    }
}
