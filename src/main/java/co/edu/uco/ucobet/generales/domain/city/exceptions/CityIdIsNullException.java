package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class CityIdIsNullException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityIdIsNullException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityIdIsNullException create(){
        var usserMessage = "El ID de la ciudad es nulo";
        return new CityIdIsNullException(usserMessage);
    }
}