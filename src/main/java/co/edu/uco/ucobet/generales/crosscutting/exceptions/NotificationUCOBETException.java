package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

import java.util.HashMap;
import java.util.Map;

public class NotificationUCOBETException extends UCOBETException {

    private static final long serialVersionUID = 1L;
    private final transient TelemetryService telemetryService;
    private final transient MessageService messageService;

    public NotificationUCOBETException(final String userMessage, final String technicalMessage,
                                       final Exception rootException, final TelemetryService telemetryService,
                                       final MessageService messageService) {
        super(userMessage, technicalMessage, rootException, Layer.GENERAL);
        this.telemetryService = telemetryService;
        this.messageService = messageService;
        registerInTelemetry(userMessage, technicalMessage);
    }

    public static NotificationUCOBETException create(final String userMessage, final String technicalMessage,
                                                     final Exception rootException, final TelemetryService telemetryService) {
        return new NotificationUCOBETException(userMessage, technicalMessage, rootException, telemetryService, null);
    }

    public static NotificationUCOBETException create(final String userMessage, final String technicalMessage,
                                                     final TelemetryService telemetryService) {
        return new NotificationUCOBETException(userMessage, technicalMessage, new Exception(), telemetryService, null);
    }

    public static NotificationUCOBETException create(final String userMessage, final TelemetryService telemetryService) {
        return new NotificationUCOBETException(userMessage, userMessage, new Exception(), telemetryService, null);
    }

    private void registerInTelemetry(String userMessage, String technicalMessage) {
        if (telemetryService != null) {
            telemetryService.trackException(this);

            Map<String, String> properties = new HashMap<>();
            properties.put(messageService.getMessage("M050"), userMessage);
            properties.put(messageService.getMessage("M051"), technicalMessage);
            telemetryService.trackEvent(messageService.getMessage("M054"), properties);
        }
    }
}
