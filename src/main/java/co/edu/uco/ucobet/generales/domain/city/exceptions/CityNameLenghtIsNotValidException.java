package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class CityNameLenghtIsNotValidException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityNameLenghtIsNotValidException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityNameLenghtIsNotValidException create(){
        var userMessage = "La longitud del nombre de la ciudad no es valido";
        return new CityNameLenghtIsNotValidException(userMessage);
    }
}
