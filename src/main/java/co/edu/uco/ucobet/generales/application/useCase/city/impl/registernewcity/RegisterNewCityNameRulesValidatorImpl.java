package co.edu.uco.ucobet.generales.application.useCase.city.impl.registernewcity;

import co.edu.uco.ucobet.generales.application.useCase.city.RegisterNewCityNameRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.rules.*;
import org.springframework.stereotype.Service;

@Service
public final class RegisterNewCityNameRulesValidatorImpl implements RegisterNewCityNameRulesValidator {

    private final CityNameIsNotNullRule cityNameIsNotNullRule;
    private final CityNameIsNotEmptyRule cityNameIsNotEmptyRule;
    private final CityNameLengthIsValidRule cityNameLengthIsValidRule;
    private final CityNameFormatIsValidRule cityNameFormatIsValidRule;
    private final CityNameForStateDoesNotExistsRule cityNameForStateDoesNotExistsRule;

    public RegisterNewCityNameRulesValidatorImpl(final CityNameIsNotNullRule cityNameIsNotNullRule,
                                                 final CityNameIsNotEmptyRule cityNameIsNotEmptyRule,
                                                 final CityNameLengthIsValidRule cityNameLengthIsValidRule,
                                                 final CityNameFormatIsValidRule cityNameFormatIsValidRule,
                                                 final CityNameForStateDoesNotExistsRule cityNameForStateDoesNotExistsRule) {
        this.cityNameIsNotNullRule = cityNameIsNotNullRule;
        this.cityNameIsNotEmptyRule = cityNameIsNotEmptyRule;
        this.cityNameLengthIsValidRule = cityNameLengthIsValidRule;
        this.cityNameFormatIsValidRule = cityNameFormatIsValidRule;
        this.cityNameForStateDoesNotExistsRule = cityNameForStateDoesNotExistsRule;
    }

    @Override
    public void validate(final CityDomain data) {

        cityNameIsNotNullRule.validate(data.getName());
        cityNameIsNotEmptyRule.validate(data.getName());
        cityNameLengthIsValidRule.validate(data.getName());
        cityNameFormatIsValidRule.validate(data.getName());
        cityNameForStateDoesNotExistsRule.validate(data);
    }

}
