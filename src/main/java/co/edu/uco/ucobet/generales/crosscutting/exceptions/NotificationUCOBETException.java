package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

import java.util.HashMap;
import java.util.Map;

public class NotificationUCOBETException extends UCOBETException {

    private static final long serialVersionUID = 1L;
    private final transient TelemetryService telemetryService;

    public NotificationUCOBETException(final String userMessage, final String technicalMessage,
                                       final Exception rootException, final TelemetryService telemetryService) {
        super(userMessage, technicalMessage, rootException, Layer.GENERAL);
        this.telemetryService = telemetryService;
        registerInTelemetry(userMessage, technicalMessage);
    }

    public static NotificationUCOBETException create(final String userMessage, final String technicalMessage,
                                                     final Exception rootException, final TelemetryService telemetryService) {
        return new NotificationUCOBETException(userMessage, technicalMessage, rootException, telemetryService);
    }

    public static NotificationUCOBETException create(final String userMessage, final String technicalMessage,
                                                     final TelemetryService telemetryService) {
        return new NotificationUCOBETException(userMessage, technicalMessage, new Exception(), telemetryService);
    }

    public static NotificationUCOBETException create(final String userMessage, final TelemetryService telemetryService) {
        return new NotificationUCOBETException(userMessage, userMessage, new Exception(), telemetryService);
    }

    private void registerInTelemetry(String userMessage, String technicalMessage) {
        if (telemetryService != null) {
            telemetryService.trackException(this);

            Map<String, String> properties = new HashMap<>();
            properties.put(MessageHelper.getMessage("M050"), userMessage);
            properties.put(MessageHelper.getMessage("M051"), technicalMessage);
            telemetryService.trackEvent(MessageHelper.getMessage("M054"), properties);
        }
    }
}
