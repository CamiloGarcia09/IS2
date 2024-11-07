package co.edu.uco.ucobet.generales.domain.country.rules.impl;

import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.country.exceptions.CountryIdIsDefaultValueException;
import co.edu.uco.ucobet.generales.domain.country.rules.CountryIdIsNotDefaultValueRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class CountryIdIsNotDefaultValueRuleImpl implements CountryIdIsNotDefaultValueRule {

    @Override
    public void validate(UUID data) {
        if (UUIDHelper.isDefault(data)){
            throw CountryIdIsDefaultValueException.create();
        }
    }
}
