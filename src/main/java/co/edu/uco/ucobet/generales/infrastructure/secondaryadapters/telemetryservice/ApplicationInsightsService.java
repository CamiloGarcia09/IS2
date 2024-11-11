package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.telemetryservice;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import com.microsoft.applicationinsights.TelemetryClient;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ApplicationInsightsService implements TelemetryService {

    private final TelemetryClient telemetryClient;

    public ApplicationInsightsService(TelemetryClient telemetryClient) {
        this.telemetryClient = telemetryClient;
    }

    @Override
    public void trackEvent(String eventName) {
        telemetryClient.trackEvent(eventName);
    }

    @Override
    public void trackEvent(String eventName, Map<String, String> properties) {
        telemetryClient.trackEvent(eventName, properties, null);
    }

    @Override
    public void trackMetric(String metricName, double value) {
        telemetryClient.trackMetric(metricName, value);
    }

    @Override
    public void trackException(Exception exception) {
        telemetryClient.trackException(exception);
    }
}