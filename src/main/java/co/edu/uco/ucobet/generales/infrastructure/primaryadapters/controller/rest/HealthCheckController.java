package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest;

import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;
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

    public HealthCheckController(MessageHelper messageHelper) {
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> healthCheck() {
        Map<String, Object> response = new HashMap<>();

        try {
            response.put(MessageHelper.getMessage("M062"),
                    MessageHelper.getMessage("M061"));
            response.put(MessageHelper.getMessage("M063"), new Date());
            response.put(MessageHelper.getMessage("M064"), MessageHelper.getMessage("M065"));

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put(MessageHelper.getMessage("M062"), MessageHelper.getMessage("M066"));
            response.put(MessageHelper.getMessage("M067"), e.getMessage());
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
        }
    }
}
