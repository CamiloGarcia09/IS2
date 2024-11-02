package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.state;

import co.edu.uco.ucobet.generales.application.primaryports.dto.GetStateDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.state.getstate.GetStatesInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.UCOBETException;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.state.GetStateResponse;
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
            stateResponse.getMensajes().add("Lista de Estados obtenida exitosamente.");

        } catch (final UCOBETException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            stateResponse.getMensajes().add(excepcion.getUserMessage());
            excepcion.printStackTrace();

        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            stateResponse.getMensajes().add("Se ha presentado un problema tratando de obtener la lista de ciudades.");
            excepcion.printStackTrace();
        }

        return new ResponseEntity<>(stateResponse, httpStatusCode);
    }
}