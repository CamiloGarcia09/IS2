package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.city;

import co.edu.uco.ucobet.generales.application.primaryports.dto.GetCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.getcities.GetCitiesInteractor;
import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.city.GetCityResponse;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.UCOBETException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/general/api/v1/cities")
public class GetCitiesController {

    private final GetCitiesInteractor getCitiesInteractor;
    private final TelemetryService telemetryService;
    private final MessageService messageService;

    public GetCitiesController(final GetCitiesInteractor getCitiesInteractor,
                               final TelemetryService telemetryService, MessageService messageService) {
        this.getCitiesInteractor = getCitiesInteractor;
        this.telemetryService = telemetryService;
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity<GetCityResponse> execute() {
        var httpStatusCode = HttpStatus.OK;
        var cityResponse = new GetCityResponse();

        try {
            List<GetCityDTO> cities = getCitiesInteractor.execute(null);
            cityResponse.setDatos(cities);
            var mensajeUsuario = messageService.getMessage("M019");
            cityResponse.getMensajes().add(mensajeUsuario);

            Map<String, String> successProps = new HashMap<>();
            successProps.put(messageService.getMessage("M055"), String.valueOf(cities.size()));
            telemetryService.trackEvent(messageService.getMessage("M056"), successProps);

        } catch (final UCOBETException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            cityResponse.getMensajes().add(excepcion.getUserMessage());

        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = messageService.getMessage("M020");
            cityResponse.getMensajes().add(mensajeUsuario);
        }

        return new ResponseEntity<>(cityResponse, httpStatusCode);
    }
}
