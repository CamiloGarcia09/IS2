package co.edu.uco.ucobet.generales.application.primaryports.interactor.city.registercity.impl;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.registercity.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.application.primaryports.mapper.CityDTOMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.service.sanitizer.SanitizationService;
import co.edu.uco.ucobet.generales.application.useCase.city.registercity.RegisterNewCity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterNewCityInteractorImpl implements RegisterNewCityInteractor {

    private final RegisterNewCity registerNewCity;
    private final SanitizationService sanitizationService;


    public RegisterNewCityInteractorImpl(RegisterNewCity registerNewCity, SanitizationService sanitizationService) {
        this.registerNewCity = registerNewCity;
        this.sanitizationService = sanitizationService;
    }

    @Override
    public void execute(final RegisterNewCityDTO data) {
        // Sanitizar los campos relevantes en el DTO antes de convertirlo al dominio
        //La sanitización realmente solo es necesaria para los campos que pueden
        // contener texto arbitrario ingresado por el usuario
        data.setCityName(sanitizationService.sanitize(data.getCityName()));

        final var cityDomain = CityDTOMapper.INSTANCE.toDomain(data);
        registerNewCity.execute(cityDomain);
    }
}
