package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class CityNameLenghtIsNotValidException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    public CityNameLenghtIsNotValidException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityNameLenghtIsNotValidException create(){
        var userMessage = "City name lenght is not valid";
        return new CityNameLenghtIsNotValidException(userMessage);
    }
}
