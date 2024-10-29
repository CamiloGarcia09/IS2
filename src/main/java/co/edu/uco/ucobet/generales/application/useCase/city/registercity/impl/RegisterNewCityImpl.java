package co.edu.uco.ucobet.generales.application.useCase.city.registercity.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.mapper.CityEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.useCase.city.registercity.RegisterNewCity;
import co.edu.uco.ucobet.generales.application.useCase.city.registercity.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import org.springframework.stereotype.Service;

@Service
public final class RegisterNewCityImpl implements RegisterNewCity {

    private final CityRepository cityRepository;
    private final RegisterNewCityRulesValidator registerNewCityRulesValidator;

    public RegisterNewCityImpl(final CityRepository cityRepository,
                               final RegisterNewCityRulesValidator registerNewCityRulesValidator) {
        this.cityRepository = cityRepository;
        this.registerNewCityRulesValidator = registerNewCityRulesValidator;
    }

    @Override
    public void execute(final CityDomain domain) {

        //Rules validation
        registerNewCityRulesValidator.validate(domain);

        //Metodo Mono
        /*DataMapper De Domain an Entity
        final var cityEntity= CityEntity.create().setId(domain.getId())
                .setName(domain.getName())
                .setState(StateEntityMapper.INSTANCE.toEntity(domain.getState()));*/


        var cityEntity = CityEntityMapper.INSTANCE.toEntity(domain);
        //Save City Entity
        cityRepository.save(cityEntity);

        //Notificar al administrador sobre la creacion de la nueva ciudad
        //¿Como? Notification building block

        //Tegna en cuenta que:
        //1. El correo del administrador esta en un lugar parametrizado (Parameters building block)
        //2. El asunto del correo esta en un lugar parametrizado (Parameters building block)
        //3. El cuerpo del correo esta en un lugar parametrizado (Parameters building block)

        //Cache distribuida Redis
    }
}
