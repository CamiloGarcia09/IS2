package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class CityIdDoesExistsException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityIdDoesExistsException(final String userMessage, final String technicalMessage,
                                      final TelemetryService telemetryService,
                                      final MessageService messageService) {
        super(userMessage, technicalMessage, new Exception(), telemetryService, messageService);

    }

    public static CityIdDoesExistsException create(TelemetryService telemetryService, MessageService messageService){
        var userMessage = messageService.getMessage("M006");
        var technicalMessage = messageService.getMessage("M025");
        return new CityIdDoesExistsException(userMessage, technicalMessage, telemetryService, messageService);
    }
}
