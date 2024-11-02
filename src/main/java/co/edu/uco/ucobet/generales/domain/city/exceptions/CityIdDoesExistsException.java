package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class CityIdDoesExistsException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityIdDoesExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityIdDoesExistsException create(){
        var userMessage = "Ya existe la ciudad con el id indicado...";
        return new CityIdDoesExistsException(userMessage);
    }
}
