package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public final class CityNameLenghtIsNotValidException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityNameLenghtIsNotValidException(final String userMessage, final String technicalMessage) {
        super(userMessage, technicalMessage, new Exception());
    }

    public static CityNameLenghtIsNotValidException create(){
        var userMessage = MessageHelper.getMessage("M014");
        var technicalMessage = MessageHelper.getMessage("M032");
        return new CityNameLenghtIsNotValidException(userMessage, technicalMessage);
    }
}
