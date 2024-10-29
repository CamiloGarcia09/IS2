package co.edu.uco.ucobet.generales.application.primaryports.interactor.city;

import co.edu.uco.ucobet.generales.application.primaryports.dto.ListCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.InteractorWithReturn;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.InteractorWithoutReturn;

import java.util.List;

public interface ListCitiesInteractor extends InteractorWithReturn<Void, List<ListCityDTO>> {

}
