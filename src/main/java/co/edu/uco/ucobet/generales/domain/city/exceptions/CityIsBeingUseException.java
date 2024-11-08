package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class CityIsBeingUseException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityIsBeingUseException(final String userMessage, final String technicalMessage,
                                    final TelemetryService telemetryService,
                                    final MessageService messageService) {
        super(userMessage, technicalMessage, new Exception(), telemetryService, messageService);
    }

    public static CityIsBeingUseException create(TelemetryService telemetryService, MessageService messageService){
        var userMessage = messageService.getMessage("M009");
        var technicalMessage = messageService.getMessage("M028");
        return new CityIsBeingUseException(userMessage, technicalMessage, telemetryService, messageService);
    }
}
