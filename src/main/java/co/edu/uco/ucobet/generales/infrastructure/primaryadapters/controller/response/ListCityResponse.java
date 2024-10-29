package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response;

import co.edu.uco.ucobet.generales.application.primaryports.dto.ListCityDTO;

import java.util.ArrayList;

public class ListCityResponse extends Response<ListCityDTO> {

    public ListCityResponse(){
        setMensajes(new ArrayList<String>());
        setDatos(new ArrayList<>());
    }
}
