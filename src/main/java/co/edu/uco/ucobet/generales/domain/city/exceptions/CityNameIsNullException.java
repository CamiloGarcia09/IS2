package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class CityNameIsNullException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityNameIsNullException(final String userMessage, final String technicalMessage,
                                    final TelemetryService telemetryService,
                                    final MessageService messageService) {
        super(userMessage, technicalMessage, new Exception(), telemetryService, messageService);
    }

    public static CityNameIsNullException create(TelemetryService telemetryService, MessageService messageService){
        var userMessage = messageService.getMessage("M013");
        var technicalMessage = messageService.getMessage("M031");
        return new CityNameIsNullException(userMessage, technicalMessage, telemetryService, messageService);
    }
}
