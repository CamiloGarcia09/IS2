package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public class SendgridUCOBETException extends UCOBETException{

    private static final long serialVersionUID = 1L;

    public SendgridUCOBETException(final String userMessage, final String technicalMessage,
                               final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.GENERAL);
    }

    public static SendgridUCOBETException create (final String userMessage, final String technicalMessage,
                                              final Exception rootException) {
        return new SendgridUCOBETException(userMessage, technicalMessage, rootException);
    }

    public static SendgridUCOBETException create (final String userMessage, final String technicalMessage){
        return new SendgridUCOBETException(userMessage, technicalMessage, new Exception());
    }

    public static SendgridUCOBETException create (final String userMessage){
        return new SendgridUCOBETException(userMessage, userMessage, new Exception());
    }
}
