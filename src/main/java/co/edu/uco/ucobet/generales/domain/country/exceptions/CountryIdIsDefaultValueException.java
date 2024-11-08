package co.edu.uco.ucobet.generales.domain.country.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class CountryIdIsDefaultValueException extends RuleUCOBETException {
    private static final long serialVersionUID = 1L;

    private CountryIdIsDefaultValueException(final String userMessage, final String technicalMessage,
                                             final TelemetryService telemetryService,
                                             final MessageService messageService) {
        super(userMessage, technicalMessage, new Exception(), telemetryService, messageService);

    }

    public static CountryIdIsDefaultValueException create(TelemetryService telemetryService, MessageService messageService){
        var userMessage = messageService.getMessage("M038");
        var technicalMessage = messageService.getMessage("M039");
        return new CountryIdIsDefaultValueException(userMessage, technicalMessage, telemetryService, messageService);
    }
}