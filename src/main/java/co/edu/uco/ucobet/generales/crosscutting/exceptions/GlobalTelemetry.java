package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import org.springframework.stereotype.Component;

@Component
public class GlobalTelemetry {

    private final TelemetryService telemetryService;

    public GlobalTelemetry(TelemetryService telemetryService) {
        this.telemetryService = telemetryService;
    }

    public TelemetryService getTelemetryService() {
        return telemetryService;
    }
}
