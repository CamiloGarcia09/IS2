package co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry;

import java.util.Map;

public interface TelemetryService {
    void trackEvent(String eventName);
    void trackEvent(String eventName, Map<String, String> properties);
    void trackMetric(String metricName, double value);
    void trackException(Exception exception);
}