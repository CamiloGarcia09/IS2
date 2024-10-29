package co.edu.uco.ucobet.generales.application.primaryports.interactor;

public interface InteractorWithReturn  <T, R>{

    R execute(T data);
}
