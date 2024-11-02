package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class CityNameForStateDoesExistsException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityNameForStateDoesExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityNameForStateDoesExistsException create(){
        var userMessage = "El nombre de la ciudad para ese Estado ya existe";
        return new CityNameForStateDoesExistsException(userMessage);
    }
}
