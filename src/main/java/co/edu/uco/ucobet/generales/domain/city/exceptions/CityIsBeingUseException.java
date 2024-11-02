package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class CityIsBeingUseException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityIsBeingUseException(final String userMessage ) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityIsBeingUseException create(){
        var userMessage = "La ciudad ya se encuentra en uso";
        return new CityIsBeingUseException(userMessage);
    }
}
