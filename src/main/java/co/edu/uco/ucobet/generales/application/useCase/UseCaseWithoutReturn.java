package co.edu.uco.ucobet.generales.application.useCase;

public interface UseCaseWithoutReturn<D>{

    void execute(D domain);
}
