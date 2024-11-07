package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.telemetryservice.config;

import com.microsoft.applicationinsights.TelemetryClient;
import com.microsoft.applicationinsights.TelemetryConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TelemetryConfig {

    @Bean
    public TelemetryClient telemetryClient() {
        String instrumentationKey = System.getenv("APPLICATION_INSIGHTS_INSTRUMENTATION_KEY");
        if (instrumentationKey == null) {
            instrumentationKey = "e7885e64-ffb4-43bc-948e-6dca19c9a78a";
        }
        TelemetryConfiguration configuration = TelemetryConfiguration.getActive();
        configuration.setInstrumentationKey(instrumentationKey);
        return new TelemetryClient(configuration);
    }
}