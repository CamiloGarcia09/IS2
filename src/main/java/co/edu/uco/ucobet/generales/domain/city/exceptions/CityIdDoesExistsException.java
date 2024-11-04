package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageHelper;

public final class CityIdDoesExistsException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityIdDoesExistsException(final String userMessage, final String technicalMessage) {
        super(userMessage, technicalMessage, new Exception());
    }

    public static CityIdDoesExistsException create(){
        var userMessage = MessageHelper.getMessage("M006");
        var technicalMessage =MessageHelper.getMessage("M025");
        return new CityIdDoesExistsException(userMessage, technicalMessage);
    }
}
