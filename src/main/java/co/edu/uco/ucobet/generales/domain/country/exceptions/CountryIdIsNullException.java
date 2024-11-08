package co.edu.uco.ucobet.generales.domain.country.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class CountryIdIsNullException extends RuleUCOBETException {
    private static final long serialVersionUID = 1L;

    private CountryIdIsNullException(final String userMessage, final String technicalMessage,
                                     final TelemetryService telemetryService,
                                     final MessageService messageService) {
        super(userMessage, technicalMessage, new Exception(), telemetryService, messageService);

    }

    public static CountryIdIsNullException create(TelemetryService telemetryService, MessageService messageService){
        var userMessage = messageService.getMessage("M040");
        var technicalMessage = messageService.getMessage("M041");
        return new CountryIdIsNullException(userMessage,technicalMessage, telemetryService, messageService);
    }
}
