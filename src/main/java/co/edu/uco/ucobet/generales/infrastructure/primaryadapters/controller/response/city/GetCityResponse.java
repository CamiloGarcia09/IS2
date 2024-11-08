package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.city;

import co.edu.uco.ucobet.generales.application.primaryports.dto.GetCityDTO;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.Response;

import java.util.ArrayList;

public class GetCityResponse extends Response<GetCityDTO> {

    public GetCityResponse(){
        setMensajes(new ArrayList<>());
        setDatos(new ArrayList<>());
    }
}
