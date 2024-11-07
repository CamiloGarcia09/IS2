package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

import java.util.HashMap;
import java.util.Map;

public class RepositoryUCOBETException extends UCOBETException {

    private static final long serialVersionUID = 1L;

    public RepositoryUCOBETException(final String userMessage, final String technicalMessage,
                                     final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.REPOSITORY);
        registerInTelemetry(userMessage, technicalMessage);
    }

    public static RepositoryUCOBETException create (final String userMessage, final String technicalMessage,
                                                          final Exception rootException) {
        return new RepositoryUCOBETException(userMessage, technicalMessage, rootException);
    }

    public static RepositoryUCOBETException create (final String userMessage, final String technicalMessage){
        return new RepositoryUCOBETException(userMessage, technicalMessage, new Exception());
    }

    public static RepositoryUCOBETException create (final String userMessage){
        return new RepositoryUCOBETException(userMessage, userMessage, new Exception());
    }

    private void registerInTelemetry(String userMessage, String technicalMessage) {
        TelemetryService telemetryService = GlobalTelemetry.getTelemetryService();
        if (telemetryService != null) {

            telemetryService.trackException(this);

            Map<String, String> properties = new HashMap<>();
            properties.put(MessageHelper.getMessage("M050"), userMessage);
            properties.put(MessageHelper.getMessage("M051"), technicalMessage);
            telemetryService.trackEvent(MessageHelper.getMessage("M052"), properties);
        }
    }
}
