package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.city;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.UCOBETException;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.RegisterCityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/general/api/v1/cities")
public class RegisterNewCityController {

    private final RegisterNewCityInteractor registerNewCityInteractor;

    public RegisterNewCityController(final RegisterNewCityInteractor registerNewCityInteractor) {
        this.registerNewCityInteractor=registerNewCityInteractor;
    }

    @PostMapping
    public ResponseEntity<RegisterCityResponse> execute(@RequestBody RegisterNewCityDTO dto) {

        var httpStatusCode = HttpStatus.ACCEPTED;
        var cityResponse = new RegisterCityResponse();

        try {
            registerNewCityInteractor.execute(dto);
            var mensajeUsuario = "Ciudad creada exitosamente";
            cityResponse.getMensajes().add(mensajeUsuario);

        } catch (final UCOBETException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            cityResponse.getMensajes().add(excepcion.getUserMessage());
            excepcion.printStackTrace();

        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

            var mensajeUsuario = "se ha presentado un prblema tratando de registar la nueva Ciudad";
            cityResponse.getMensajes().add(mensajeUsuario);
            excepcion.printStackTrace();

        }

        return new ResponseEntity<>(cityResponse, httpStatusCode);
    }
}
