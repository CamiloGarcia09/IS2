package co.edu.uco.ucobet.generales.application.primaryports.interactor.city.listcities.impl;

import co.edu.uco.ucobet.generales.application.primaryports.dto.ListCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.listcities.ListCitiesInteractor;
import co.edu.uco.ucobet.generales.application.primaryports.mapper.CityDTOMapper;
import co.edu.uco.ucobet.generales.application.useCase.city.listcities.ListCities;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ListCitiesInteractorImpl implements ListCitiesInteractor {

    private final ListCities listCities;

    public ListCitiesInteractorImpl(final ListCities listCities) {
        this.listCities = listCities;
    }

    @Override
    public List<ListCityDTO> execute(Void data) {

    return listCities.execute(null).stream()
                .map(CityDTOMapper.INSTANCE::toListCityDTO)
                .collect(Collectors.toList());
    }
}
