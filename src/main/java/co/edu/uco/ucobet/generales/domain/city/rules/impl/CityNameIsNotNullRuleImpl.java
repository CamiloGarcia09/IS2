package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameIsNullException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotNullRule;
import org.springframework.stereotype.Service;

@Service
public final class CityNameIsNotNullRuleImpl implements CityNameIsNotNullRule {

    private final TelemetryService telemetryService;

    public CityNameIsNotNullRuleImpl(TelemetryService telemetryService) {
        this.telemetryService = telemetryService;
    }

    @Override
    public void validate(String data) {
        if (TextHelper.isNull(data)){
            throw CityNameIsNullException.create(telemetryService);
        }
    }
}
