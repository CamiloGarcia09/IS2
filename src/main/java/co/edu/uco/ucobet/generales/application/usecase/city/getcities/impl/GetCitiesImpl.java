package co.edu.uco.ucobet.generales.application.usecase.city.getcities.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.mapper.CityEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.usecase.city.getcities.GetCities;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public final class GetCitiesImpl implements GetCities {

    private final CityRepository cityRepository;

    public GetCitiesImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CityDomain> execute(CityDomain domain) {
        return cityRepository.findAll().stream()
                .map(CityEntityMapper.INSTANCE::toDomain)
                .toList();
    }

}
