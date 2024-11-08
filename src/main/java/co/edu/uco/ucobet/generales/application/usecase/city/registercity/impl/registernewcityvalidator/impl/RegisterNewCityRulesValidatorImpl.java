package co.edu.uco.ucobet.generales.application.usecase.city.registercity.impl.registernewcityvalidator.impl;

import co.edu.uco.ucobet.generales.application.usecase.city.registercity.RegisterNewCityIdRulesValidator;
import co.edu.uco.ucobet.generales.application.usecase.city.registercity.RegisterNewCityNameRulesValidator;
import co.edu.uco.ucobet.generales.application.usecase.city.registercity.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.application.usecase.city.registercity.RegisterNewCityStateRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import org.springframework.stereotype.Service;

@Service
public final class RegisterNewCityRulesValidatorImpl implements RegisterNewCityRulesValidator {

    private final RegisterNewCityIdRulesValidator registerNewCityIdRulesValidator;
    private final RegisterNewCityNameRulesValidator registerNewCityNameRulesValidator;
    private final RegisterNewCityStateRulesValidator registerNewCityStateRulesValidator;


    public RegisterNewCityRulesValidatorImpl(final RegisterNewCityIdRulesValidator registerNewCityIdRulesValidator,
                                             final RegisterNewCityNameRulesValidator registerNewCityNameRulesValidator,
                                             final RegisterNewCityStateRulesValidator registerNewCityStateRulesValidator) {
        this.registerNewCityIdRulesValidator = registerNewCityIdRulesValidator;
        this.registerNewCityNameRulesValidator = registerNewCityNameRulesValidator;
        this.registerNewCityStateRulesValidator = registerNewCityStateRulesValidator;
    }

    @Override
    public void validate(final CityDomain data) {
        registerNewCityIdRulesValidator.validate(data);
        registerNewCityNameRulesValidator.validate(data);
        registerNewCityStateRulesValidator.validate(data.getState().getId());
    }

}
