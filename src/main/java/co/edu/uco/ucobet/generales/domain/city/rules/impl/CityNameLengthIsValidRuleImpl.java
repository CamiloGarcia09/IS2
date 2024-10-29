package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameLenghtIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameLengthIsValidRule;
import org.springframework.stereotype.Service;

@Service
public final class CityNameLengthIsValidRuleImpl implements CityNameLengthIsValidRule {

    private static final int MIN_NAME_LENGTH=3;
    private static final int MAX_NAME_LENGTH=255;

    @Override
    public void validate(String data) {
        if(data.length()<MIN_NAME_LENGTH || data.length()>MAX_NAME_LENGTH){
            throw CityNameLenghtIsNotValidException.create();
        }
    }
}
