package co.edu.uco.ucobet.generales.application.primaryports.interactor.city.impl;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.application.primaryports.mapper.CityDTOMapper;
import co.edu.uco.ucobet.generales.application.useCase.city.RegisterNewCity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterNewCityInteractorImpl implements RegisterNewCityInteractor {

    private final RegisterNewCity registerNewCity;

    public RegisterNewCityInteractorImpl(final RegisterNewCity registerNewCity) {
        this.registerNewCity = registerNewCity;
    }

    @Override
    public void execute(final RegisterNewCityDTO data) {
        final var cityDomain = CityDTOMapper.INSTANCE.toDomain(data);
        registerNewCity.execute(cityDomain);
    }
}
