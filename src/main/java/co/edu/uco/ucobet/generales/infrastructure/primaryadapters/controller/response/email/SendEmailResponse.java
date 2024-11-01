package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.email;

import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.Response;

import java.util.ArrayList;

public class SendEmailResponse extends Response<String> {

    public SendEmailResponse() {
        setMensajes(new ArrayList<>());
        setDatos(null);
    }

}
