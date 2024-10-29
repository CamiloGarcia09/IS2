package co.edu.uco.ucobet.generales.application.useCase.city.registercity.impl.registernewcityvalidator;

import co.edu.uco.ucobet.generales.application.useCase.city.registercity.RegisterNewCityStateRulesValidator;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistsRule;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotDefaultValueRule;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotNullRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class RegisterNewCityStateRulesValidatorImpl implements RegisterNewCityStateRulesValidator {

    private final StateDoesExistsRule stateDoesExistsRule;
    private final StateIdIsNotDefaultValueRule stateIdIsNotDefaultValueRule;
    private final StateIdIsNotNullRule stateIdIsNotNullRule;

    public RegisterNewCityStateRulesValidatorImpl(final StateDoesExistsRule stateDoesExistsRule,
                                                  final StateIdIsNotDefaultValueRule stateIdIsNotDefaultValueRule,
                                                  final StateIdIsNotNullRule stateIdIsNotNullRule) {
        this.stateDoesExistsRule = stateDoesExistsRule;
        this.stateIdIsNotDefaultValueRule = stateIdIsNotDefaultValueRule;
        this.stateIdIsNotNullRule = stateIdIsNotNullRule;
    }

    @Override
    public void validate(final UUID stateId) {

        stateDoesExistsRule.validate(stateId);
        stateIdIsNotDefaultValueRule.validate(stateId);
        stateIdIsNotNullRule.validate(stateId);
    }

}
