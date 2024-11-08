package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class CityNameForStateDoesExistsException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityNameForStateDoesExistsException(final String userMessage, final String technicalMessage,
                                                final TelemetryService telemetryService,
                                                final MessageService messageService) {
        super(userMessage, technicalMessage, new Exception(),telemetryService, messageService);
    }

    public static CityNameForStateDoesExistsException create(TelemetryService telemetryService, MessageService messageService){
        var userMessage = messageService.getMessage("M011");
        var technicalMessage = messageService.getMessage("M029");
        return new CityNameForStateDoesExistsException(userMessage, technicalMessage, telemetryService, messageService);
    }
}
