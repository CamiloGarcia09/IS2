package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.state;

import co.edu.uco.ucobet.generales.application.primaryports.dto.GetStateDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.state.getstate.GetStatesInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.UCOBETException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.SanitizerHelper;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.state.GetStateResponse;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/general/api/v1/states")
public class GetStatesController {

    private final GetStatesInteractor getStatesInteractor;

    public GetStatesController(GetStatesInteractor getStatesInteractor) {
        this.getStatesInteractor = getStatesInteractor;
    }

    @GetMapping
    public ResponseEntity<GetStateResponse> execute() {
        var httpStatusCode = HttpStatus.OK;
        var stateResponse = new GetStateResponse();

        try {
            // Ejecuta el interactor para obtener la lista de ciudades
            List<GetStateDTO> states = getStatesInteractor.execute(null);
            stateResponse.setDatos(states);
            var mensajeUsuario = MessageHelper.getMessage("M022");
            stateResponse.getMensajes().add(mensajeUsuario);

        } catch (final UCOBETException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            stateResponse.getMensajes().add(excepcion.getUserMessage());
            excepcion.printStackTrace();

        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = MessageHelper.getMessage("M023");
            stateResponse.getMensajes().add(mensajeUsuario);
            excepcion.printStackTrace();
        }

        return new ResponseEntity<>(stateResponse, httpStatusCode);
    }
}