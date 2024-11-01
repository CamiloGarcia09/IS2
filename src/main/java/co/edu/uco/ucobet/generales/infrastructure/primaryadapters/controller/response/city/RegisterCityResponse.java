package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.city;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.Response;

import java.util.ArrayList;

public class RegisterCityResponse extends Response<RegisterNewCityDTO> {

    public RegisterCityResponse(){
        setMensajes(new ArrayList<String>());
        setDatos(new ArrayList<>());
    }
}
