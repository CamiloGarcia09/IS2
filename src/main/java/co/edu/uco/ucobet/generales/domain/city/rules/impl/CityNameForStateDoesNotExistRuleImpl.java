package co.edu.uco.ucobet.generales.domain.city.rules.impl;
import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameForStateDoesExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameForStateDoesNotExistsRule;
import org.springframework.stereotype.Service;

@Service
public final class CityNameForStateDoesNotExistRuleImpl implements CityNameForStateDoesNotExistsRule {
    private final CityRepository cityRepository;

    public CityNameForStateDoesNotExistRuleImpl(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void validate(CityDomain data) {
        var cityEntityFilter= CityEntity.create().setName(data.getName()).setState(StateEntityMapper.INSTANCE.toEntity(data.getState()));
        var resultados= cityRepository.findByFilter(cityEntityFilter);

        if (!resultados.isEmpty()) {
            throw CityNameForStateDoesExistsException.create();
        }
    }
}
