package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.notificationservice.config;

import co.edu.uco.ucobet.generales.application.secondaryports.service.notification.NotificationService;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.notificationservice.SendgridService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendgridConfig {

    @Value("${keySendgrid}")
    private String apiKey;

    @Bean
    public NotificationService emailService() {
        return new SendgridService(apiKey, null, null);
    }
}
