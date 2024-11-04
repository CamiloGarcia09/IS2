package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public final class CityNameIsNullException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityNameIsNullException(final String userMessage, final String technicalMessage) {
        super(userMessage, technicalMessage, new Exception());
    }

    public static CityNameIsNullException create(){
        var userMessage = MessageHelper.getMessage("M013");
        var technicalMessage = MessageHelper.getMessage("M031");
        return new CityNameIsNullException(userMessage, technicalMessage);
    }
}
