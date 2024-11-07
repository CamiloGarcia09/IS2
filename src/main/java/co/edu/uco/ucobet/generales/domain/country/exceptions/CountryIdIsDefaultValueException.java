package co.edu.uco.ucobet.generales.domain.country.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public final class CountryIdIsDefaultValueException extends RuleUCOBETException {
    private static final long serialVersionUID = 1L;

    private CountryIdIsDefaultValueException(final String userMessage, final String technicalMessage) {
        super(userMessage, technicalMessage, new Exception());

    }

    public static CountryIdIsDefaultValueException create(){
        var userMessage = MessageHelper.getMessage("M038");
        var technicalMessage = MessageHelper.getMessage("M039");
        return new CountryIdIsDefaultValueException(userMessage, technicalMessage);
    }
}