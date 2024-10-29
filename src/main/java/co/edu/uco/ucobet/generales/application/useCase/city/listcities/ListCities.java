package co.edu.uco.ucobet.generales.application.useCase.city.listcities;

import co.edu.uco.ucobet.generales.application.useCase.UseCaseWithReturn;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

import java.util.List;

public interface ListCities extends UseCaseWithReturn<Void, List<CityDomain>> {
}
