package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;

import java.util.ArrayList;

public class RegisterCityResponse extends Response<RegisterNewCityDTO> {

    public RegisterCityResponse(){
        setMensajes(new ArrayList<String>());
        setDatos(new ArrayList<>());
    }
}
