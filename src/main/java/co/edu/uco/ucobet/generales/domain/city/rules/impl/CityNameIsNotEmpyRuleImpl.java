package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameIsEmptyException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotEmptyRule;
import org.springframework.stereotype.Service;

@Service
public final class CityNameIsNotEmpyRuleImpl implements CityNameIsNotEmptyRule {

    private final TelemetryService telemetryService;

    public CityNameIsNotEmpyRuleImpl(TelemetryService telemetryService) {
        this.telemetryService = telemetryService;
    }

    @Override
    public void validate(String data) {
        if (TextHelper.isEmpty(data)) {
            throw CityNameIsEmptyException.create(telemetryService);
        }
    }
}

