package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.city;

import co.edu.uco.ucobet.generales.application.primaryports.dto.GetCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.getcities.GetCitiesInteractor;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.city.GetCityResponse;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.UCOBETException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/general/api/v1/cities")
public class GetCitiesController {

    private final GetCitiesInteractor getCitiesInteractor;

    public GetCitiesController(final GetCitiesInteractor getCitiesInteractor) {
        this.getCitiesInteractor = getCitiesInteractor;
    }

    @GetMapping
    public ResponseEntity<GetCityResponse> execute() {
        var httpStatusCode = HttpStatus.OK;
        var cityResponse = new GetCityResponse();

        try {
            // Ejecuta el interactor para obtener la lista de ciudades
            List<GetCityDTO> cities = getCitiesInteractor.execute(null);
            cityResponse.setDatos(cities);
            cityResponse.getMensajes().add("Lista de ciudades obtenida exitosamente.");

        } catch (final UCOBETException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            cityResponse.getMensajes().add(excepcion.getUserMessage());
            excepcion.printStackTrace();

        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            cityResponse.getMensajes().add("Se ha presentado un problema tratando de obtener la lista de ciudades.");
            excepcion.printStackTrace();
        }

        return new ResponseEntity<>(cityResponse, httpStatusCode);
    }
}
