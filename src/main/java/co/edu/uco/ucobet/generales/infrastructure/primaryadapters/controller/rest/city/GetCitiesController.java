package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.city;

import co.edu.uco.ucobet.generales.application.primaryports.dto.GetCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.getcities.GetCitiesInteractor;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.city.GetCityResponse;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.UCOBETException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;
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

    public GetCitiesController(final GetCitiesInteractor getCitiesInteractor,
                               final TelemetryService telemetryService) {
        this.getCitiesInteractor = getCitiesInteractor;
        this.telemetryService = telemetryService;
    }

    @GetMapping
    public ResponseEntity<GetCityResponse> execute() {
        var httpStatusCode = HttpStatus.OK;
        var cityResponse = new GetCityResponse();

        try {
            List<GetCityDTO> cities = getCitiesInteractor.execute(null);
            cityResponse.setDatos(cities);
            var mensajeUsuario = MessageHelper.getMessage("M019");
            cityResponse.getMensajes().add(mensajeUsuario);

            Map<String, String> successProps = new HashMap<>();
            successProps.put(MessageHelper.getMessage("M055"), String.valueOf(cities.size()));
            telemetryService.trackEvent(MessageHelper.getMessage("M056"), successProps);

        } catch (final UCOBETException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            cityResponse.getMensajes().add(excepcion.getUserMessage());

        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = MessageHelper.getMessage("M020");
            cityResponse.getMensajes().add(mensajeUsuario);
        }

        return new ResponseEntity<>(cityResponse, httpStatusCode);
    }
}
