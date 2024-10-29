package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class CityIsBeingUseException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    public CityIsBeingUseException(final String userMessage ) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityIsBeingUseException create(){
        var userMessage = "City is already being used";
        return new CityIsBeingUseException(userMessage);
    }
}
