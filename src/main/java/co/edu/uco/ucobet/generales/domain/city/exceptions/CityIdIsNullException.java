package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageHelper;

public final class CityIdIsNullException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityIdIsNullException(final String userMessage, final String technicalMessage) {
        super(userMessage, technicalMessage, new Exception());
    }

    public static CityIdIsNullException create(){
        var userMessage = MessageHelper.getMessage("M008");
        var technicalMessage = MessageHelper.getMessage("M027");
        return new CityIdIsNullException(userMessage, technicalMessage);
    }
}