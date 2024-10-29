package co.edu.uco.ucobet.generales.application.useCase.city.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.mapper.CityEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.useCase.city.ListCities;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public final class ListCitiesImpl implements ListCities {

    private final CityRepository cityRepository;

    public ListCitiesImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CityDomain> execute(Void domain) {
        return cityRepository.findAll().stream()
                .map(CityEntityMapper.INSTANCE::toDomain)
                .collect(Collectors.toList());
    }

}
