package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/general/api/v1/health")
public class HealthCheckController {

    private MessageService messageService;

    public HealthCheckController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> healthCheck() {
        Map<String, Object> response = new HashMap<>();

        try {
            response.put(messageService.getMessage("M062"),
                    messageService.getMessage("M061"));
            response.put(messageService.getMessage("M063"), new Date());
            response.put(messageService.getMessage("M064"), messageService.getMessage("M065"));

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put(messageService.getMessage("M062"), messageService.getMessage("M066"));
            response.put(messageService.getMessage("M067"), e.getMessage());
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
        }
    }
}
