package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.telemetryservice.config;

import co.edu.uco.ucobet.generales.application.secondaryports.service.keyvault.VaultService;
import com.microsoft.applicationinsights.TelemetryClient;
import com.microsoft.applicationinsights.TelemetryConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationInsightsConfig {

    private VaultService vaultService;

    public ApplicationInsightsConfig(VaultService vaultService) {
        this.vaultService = vaultService;
    }

    @Bean
    public TelemetryClient telemetryClient() {
        String instrumentationKey = System.getenv(vaultService.getSecretValue("instrumentationKey"));
        if (instrumentationKey == null) {
            instrumentationKey = vaultService.getSecretValue("insightskey");
        }
        TelemetryConfiguration configuration = TelemetryConfiguration.getActive();
        configuration.setInstrumentationKey(instrumentationKey);
        return new TelemetryClient(configuration);
    }
}