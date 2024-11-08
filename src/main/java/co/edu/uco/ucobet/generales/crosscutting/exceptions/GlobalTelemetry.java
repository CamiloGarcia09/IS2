package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import org.springframework.stereotype.Component;

@Component
public class GlobalTelemetry {

    private final TelemetryService telemetryService;

    // Constructor público para permitir inyección de dependencias
    public GlobalTelemetry(TelemetryService telemetryService) {
        this.telemetryService = telemetryService;
    }

    // Método público para obtener el servicio de Telemetría sin usar una variable estática
    public TelemetryService getTelemetryService() {
        return telemetryService;
    }
}
