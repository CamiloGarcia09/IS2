package co.edu.uco.ucobet.generales.domain;

public interface DomainRule  <T>{

    void validate (T data);
}
