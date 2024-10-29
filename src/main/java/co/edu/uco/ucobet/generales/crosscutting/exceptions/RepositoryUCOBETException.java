package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public class RepositoryUCOBETException extends UCOBETException {

    private static final long serialVersionUID = 1L;

    public RepositoryUCOBETException(final String userMessage, final String technicalMessage,
                                     final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.REPOSITORY);
    }

    public static RepositoryUCOBETException create (final String userMessage, final String technicalMessage,
                                                          final Exception rootException) {
        return new RepositoryUCOBETException(userMessage, technicalMessage, rootException);
    }

    public static RepositoryUCOBETException create (final String userMessage, final String technicalMessage){
        return new RepositoryUCOBETException(userMessage, technicalMessage, new Exception());
    }

    public static RepositoryUCOBETException create (final String userMessage){
        return new RepositoryUCOBETException(userMessage, userMessage, new Exception());
    }
}
