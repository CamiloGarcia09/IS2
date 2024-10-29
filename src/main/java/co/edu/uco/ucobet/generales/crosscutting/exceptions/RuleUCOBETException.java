package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public class RuleUCOBETException extends UCOBETException {

    private static final long serialVersionUID = 1L;

    public RuleUCOBETException(final String userMessage, final String technicalMessage,
                               final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.RULE);
    }

    public static RuleUCOBETException create (final String userMessage, final String technicalMessage,
                                                    final Exception rootException) {
        return new RuleUCOBETException(userMessage, technicalMessage, rootException);
    }

    public static RuleUCOBETException create (final String userMessage, final String technicalMessage){
        return new RuleUCOBETException(userMessage, technicalMessage, new Exception());
    }

    public static RuleUCOBETException create (final String userMessage){
        return new RuleUCOBETException(userMessage, userMessage, new Exception());
    }
}
