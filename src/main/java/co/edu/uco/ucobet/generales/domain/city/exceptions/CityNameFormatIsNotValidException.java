package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class CityNameFormatIsNotValidException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityNameFormatIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityNameFormatIsNotValidException create(){
        var userMessage = "El nombre que estas ingresando, no tiene un formato valido";
        return new CityNameFormatIsNotValidException(userMessage);
    }
}
