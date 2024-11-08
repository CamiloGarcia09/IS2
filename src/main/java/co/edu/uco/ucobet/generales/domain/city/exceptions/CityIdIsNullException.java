package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class CityIdIsNullException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityIdIsNullException(final String userMessage, final String technicalMessage,
                                  final TelemetryService telemetryService,
                                  final MessageService messageService) {
        super(userMessage, technicalMessage, new Exception(), telemetryService, messageService);
    }

    public static CityIdIsNullException create(TelemetryService telemetryService, MessageService messageService){
        var userMessage = messageService.getMessage("M008");
        var technicalMessage = messageService.getMessage("M027");
        return new CityIdIsNullException(userMessage, technicalMessage, telemetryService, messageService);
    }
}