package co.edu.uco.ucobet.generales.application.useCase.city.impl.registernewcity;

import co.edu.uco.ucobet.generales.application.useCase.city.RegisterNewCityIdRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesNotExistsRule;
import org.springframework.stereotype.Service;

@Service
public final class RegisterNewCityIdRulesValidatorImpl implements RegisterNewCityIdRulesValidator {

    private final CityIdDoesNotExistsRule cityIdDoesNotExistsRule;

    public RegisterNewCityIdRulesValidatorImpl(final CityIdDoesNotExistsRule cityIdDoesNotExistsRule) {
        this.cityIdDoesNotExistsRule = cityIdDoesNotExistsRule;
    }

    @Override
    public void validate(final CityDomain data) {

        try{
            data.generateId();
            cityIdDoesNotExistsRule.validate(data.getId());
        }catch (final CityIdDoesExistsException exception){
            validate(data);
        }
    }


}
