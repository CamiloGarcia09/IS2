package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class CityNameFormatIsNotValidException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    public CityNameFormatIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityNameFormatIsNotValidException create(){
        var userMessage = "City name format is not valid";
        return new CityNameFormatIsNotValidException(userMessage);
    }
}
