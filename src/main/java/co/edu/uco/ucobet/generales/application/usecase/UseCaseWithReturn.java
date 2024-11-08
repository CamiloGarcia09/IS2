package co.edu.uco.ucobet.generales.application.usecase;

public interface UseCaseWithReturn <D,R>{

    R execute(D domain);
}
