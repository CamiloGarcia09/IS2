package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageHelper;

public final class CityNameForStateDoesExistsException extends RuleUCOBETException {

    private static final long serialVersionUID = 1L;

    private CityNameForStateDoesExistsException(final String userMessage, final String technicalMessage) {
        super(userMessage, technicalMessage, new Exception());
    }

    public static CityNameForStateDoesExistsException create(){
        var userMessage = MessageHelper.getMessage("M011");
        var technicalMessage = MessageHelper.getMessage("M029");
        return new CityNameForStateDoesExistsException(userMessage, technicalMessage);
    }
}
