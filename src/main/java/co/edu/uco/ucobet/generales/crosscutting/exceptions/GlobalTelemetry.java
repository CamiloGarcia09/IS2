package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import org.springframework.stereotype.Component;

@Component
public final class GlobalTelemetry {
    private static TelemetryService telemetryService;

    public GlobalTelemetry(TelemetryService telemetryService) {
        GlobalTelemetry.telemetryService = telemetryService;
    }

    public static TelemetryService getTelemetryService() {
        return telemetryService;
    }
}
