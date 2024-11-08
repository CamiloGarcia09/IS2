package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.state;

import co.edu.uco.ucobet.generales.application.primaryports.dto.GetStateDTO;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.Response;

import java.util.ArrayList;

public class GetStateResponse extends Response<GetStateDTO> {

    public GetStateResponse(){
        setMensajes(new ArrayList<>());
        setDatos(new ArrayList<>());
    }
}
