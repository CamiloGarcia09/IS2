package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response;

import java.util.ArrayList;

public class SendEmailResponse extends Response<String> {

    public SendEmailResponse() {
        setMensajes(new ArrayList<>());
        setDatos(null);
    }

}
