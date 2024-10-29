package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class CityIdDoesNotExistsException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityIdDoesNotExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityIdDoesNotExistsException create(){
        var usserMessage = "No existe la ciudad con el ID indicado";
        return new CityIdDoesNotExistsException(usserMessage);
    }

}
