package co.edu.uco.ucobet.generales.application.useCase;

public interface UseCaseWithReturn <D,R>{

    R execute(D domain);
}
