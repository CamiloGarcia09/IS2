package co.edu.uco.ucobet.generales.domain.country.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CountryRepository;
import co.edu.uco.ucobet.generales.domain.country.exceptions.CountryDoesNotExistsException;
import co.edu.uco.ucobet.generales.domain.country.rules.CountryDoesExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class CountryDoesExistsRuleImpl implements CountryDoesExistsRule {

    private final CountryRepository countryRepository;

    public CountryDoesExistsRuleImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void validate(UUID data) {
        if(!countryRepository.existsById(data)) {
            throw CountryDoesNotExistsException.create();
        }
    }
}
