package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.city;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.registercity.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.UCOBETException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.SanitizerHelper;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.city.RegisterCityResponse;
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

    @PostMapping("/registerNewCity")
    public ResponseEntity<RegisterCityResponse> execute(@RequestBody RegisterNewCityDTO dto) {

        var httpStatusCode = HttpStatus.ACCEPTED;
        var cityResponse = new RegisterCityResponse();

        try {
            sanitizeRegisterNewCityDTO(dto);
            registerNewCityInteractor.execute(dto);
            var mensajeUsuario = MessageHelper.getMessage("M001");
            cityResponse.getMensajes().add(mensajeUsuario);

        } catch (final UCOBETException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            cityResponse.getMensajes().add(excepcion.getUserMessage());
            excepcion.printStackTrace();

        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

            var mensajeUsuario = MessageHelper.getMessage("M021");
            cityResponse.getMensajes().add(mensajeUsuario);
            excepcion.printStackTrace();

        }

        return new ResponseEntity<>(cityResponse, httpStatusCode);
    }


    private void sanitizeRegisterNewCityDTO(RegisterNewCityDTO dto) {
        if (dto != null) {
            dto.setCityName(SanitizerHelper.sanitizeInput(dto.getCityName()));
        }
    }
}
