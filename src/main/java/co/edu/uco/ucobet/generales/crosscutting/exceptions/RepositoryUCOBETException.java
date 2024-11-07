package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

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
            // Registrar la excepción en Application Insights
            telemetryService.trackException(this);

            // Opcional: agregar propiedades personalizadas como evento
            Map<String, String> properties = new HashMap<>();
            properties.put("UserMessage", userMessage);
            properties.put("TechnicalMessage", technicalMessage);
            telemetryService.trackEvent("RepositoryUCOBETException Occurred", properties);
        }
    }
}
