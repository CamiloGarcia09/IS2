package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.city;

import co.edu.uco.ucobet.generales.application.primaryports.dto.ListCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.listcities.ListCitiesInteractor;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.ListCityResponse;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.UCOBETException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/general/api/v1/cities")
public class ListCitiesController {

    private final ListCitiesInteractor listCitiesInteractor;

    public ListCitiesController(final ListCitiesInteractor listCitiesInteractor) {
        this.listCitiesInteractor = listCitiesInteractor;
    }

    @GetMapping
    public ResponseEntity<ListCityResponse> execute() {
        var httpStatusCode = HttpStatus.OK;
        var cityResponse = new ListCityResponse();

        try {
            // Ejecuta el interactor para obtener la lista de ciudades
            List<ListCityDTO> cities = listCitiesInteractor.execute(null);
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
