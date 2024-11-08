package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.state;

import co.edu.uco.ucobet.generales.application.primaryports.dto.GetStateDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.state.getstate.GetStatesInteractor;
import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.UCOBETException;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.state.GetStateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/general/api/v1/states")
public class GetStatesController {

    private final GetStatesInteractor getStatesInteractor;
    private final TelemetryService telemetryService;
    private final MessageService messageService;

    public GetStatesController(final GetStatesInteractor getStatesInteractor,
                               final TelemetryService telemetryService,
                               final MessageService messageService) {
        this.getStatesInteractor = getStatesInteractor;
        this.telemetryService = telemetryService;
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity<GetStateResponse> execute() {
        var httpStatusCode = HttpStatus.OK;
        var stateResponse = new GetStateResponse();

        try {
            List<GetStateDTO> states = getStatesInteractor.execute(null);
            stateResponse.setDatos(states);
            var mensajeUsuario = messageService.getMessage("M022");
            stateResponse.getMensajes().add(mensajeUsuario);

            Map<String, String> successProps = new HashMap<>();
            successProps.put(messageService.getMessage("M057"), String.valueOf(states.size()));
            telemetryService.trackEvent(messageService.getMessage("M058"), successProps);

        } catch (final UCOBETException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            stateResponse.getMensajes().add(excepcion.getUserMessage());

        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = messageService.getMessage("M023");
            stateResponse.getMensajes().add(mensajeUsuario);
        }

        return new ResponseEntity<>(stateResponse, httpStatusCode);
    }
}