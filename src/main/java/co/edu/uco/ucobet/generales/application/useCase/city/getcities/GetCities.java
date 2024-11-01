package co.edu.uco.ucobet.generales.application.useCase.city.getcities;

import co.edu.uco.ucobet.generales.application.useCase.UseCaseWithReturn;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

import java.util.List;

public interface GetCities extends UseCaseWithReturn<CityDomain, List<CityDomain>> {
}
