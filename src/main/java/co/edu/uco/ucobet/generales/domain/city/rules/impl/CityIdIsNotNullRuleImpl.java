package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdIsNullException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotNullRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class CityIdIsNotNullRuleImpl implements CityIdIsNotNullRule {

    private final TelemetryService telemetryService;

    public CityIdIsNotNullRuleImpl(TelemetryService telemetryService) {
        this.telemetryService = telemetryService;
    }

    @Override
    public void validate(UUID data) {
        if (ObjectHelper.isNull(data)){
            throw CityIdIsNullException.create(telemetryService);
        }
    }
}