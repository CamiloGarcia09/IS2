package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

import java.util.HashMap;
import java.util.Map;

public class RepositoryUCOBETException extends UCOBETException {

    private static final long serialVersionUID = 1L;
    private final transient TelemetryService telemetryService;

    public RepositoryUCOBETException(final String userMessage, final String technicalMessage,
                                     final Exception rootException, final TelemetryService telemetryService) {
        super(userMessage, technicalMessage, rootException, Layer.REPOSITORY);
        this.telemetryService = telemetryService;
        registerInTelemetry(userMessage, technicalMessage);
    }

    public static RepositoryUCOBETException create(final String userMessage, final String technicalMessage,
                                             final Exception rootException, final TelemetryService telemetryService) {
        return new RepositoryUCOBETException(userMessage, technicalMessage, rootException, telemetryService);
    }

    public static RepositoryUCOBETException create(final String userMessage, final String technicalMessage,
                                             final TelemetryService telemetryService) {
        return new RepositoryUCOBETException(userMessage, technicalMessage, new Exception(), telemetryService);
    }

    public static RepositoryUCOBETException create(final String userMessage, final TelemetryService telemetryService) {
        return new RepositoryUCOBETException(userMessage, userMessage, new Exception(), telemetryService);
    }

    private void registerInTelemetry(String userMessage, String technicalMessage) {
        if (telemetryService != null) {
            telemetryService.trackException(this);

            Map<String, String> properties = new HashMap<>();
            properties.put(MessageHelper.getMessage("M050"), userMessage);
            properties.put(MessageHelper.getMessage("M051"), technicalMessage);
            telemetryService.trackEvent(MessageHelper.getMessage("M052"), properties);
        }
    }
}
