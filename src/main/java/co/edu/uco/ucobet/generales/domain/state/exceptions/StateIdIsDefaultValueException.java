package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUCOBETException;

public final class StateIdIsDefaultValueException extends RuleUCOBETException {
    private static final long serialVersionUID = 1L;

    private StateIdIsDefaultValueException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static StateIdIsDefaultValueException create(){
        var userMessage = "El estado no pueder ser el valor por defecto";
        return new StateIdIsDefaultValueException(userMessage);
    }
}
