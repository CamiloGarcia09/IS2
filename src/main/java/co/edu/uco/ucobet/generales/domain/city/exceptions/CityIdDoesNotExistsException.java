package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageHelper;

public final class CityIdDoesNotExistsException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityIdDoesNotExistsException(final String userMessage, final String technicalMessage) {
        super(userMessage, technicalMessage, new Exception());
    }

    public static CityIdDoesNotExistsException create(){
        var userMessage = MessageHelper.getMessage("M007");
        var technicalMessage = MessageHelper.getMessage("M026");
        return new CityIdDoesNotExistsException(userMessage, technicalMessage);
    }

}
