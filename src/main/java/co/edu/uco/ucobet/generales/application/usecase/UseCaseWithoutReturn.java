package co.edu.uco.ucobet.generales.application.usecase;

public interface UseCaseWithoutReturn<D>{

    void execute(D domain);
}
