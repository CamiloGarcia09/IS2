package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class StateIdIsNullException extends RuleUCOBETException {
    private static final long serialVersionUID = 1L;

    private StateIdIsNullException(final String usserMessage) {
        super(usserMessage,usserMessage, new Exception());
    }

    public static StateIdIsNullException create(){
        var userMessage="El Id del estado no puede ser nulo.";
        return new StateIdIsNullException(userMessage);
    }
}
