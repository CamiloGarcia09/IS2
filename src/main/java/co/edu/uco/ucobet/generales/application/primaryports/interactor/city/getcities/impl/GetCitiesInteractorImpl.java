package co.edu.uco.ucobet.generales.application.primaryports.interactor.city.getcities.impl;

import co.edu.uco.ucobet.generales.application.primaryports.dto.GetCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.getcities.GetCitiesInteractor;
import co.edu.uco.ucobet.generales.application.primaryports.mapper.CityDTOMapper;
import co.edu.uco.ucobet.generales.application.usecase.city.getcities.GetCities;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GetCitiesInteractorImpl implements GetCitiesInteractor {

    private final GetCities getCities;

    public GetCitiesInteractorImpl(final GetCities getCities) {
        this.getCities = getCities;
    }

    @Override
    public List<GetCityDTO> execute(GetCityDTO data) {
        return getCities.execute(null).stream()
                .map(CityDTOMapper.INSTANCE::toListCityDTO)
                .toList();
    }

}
