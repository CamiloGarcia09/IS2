package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameFormatIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameFormatIsValidRule;
import org.springframework.stereotype.Service;

@Service
public final class CityNameFormatIsValidRuleImpl implements CityNameFormatIsValidRule {

    private final TelemetryService telemetryService;

    public CityNameFormatIsValidRuleImpl(TelemetryService telemetryService) {
        this.telemetryService = telemetryService;
    }

    @Override
    public void validate(String data) {
        if (TextHelper.isEmpty(data) || !TextHelper.containsOnlyLetters(data)) {
            throw CityNameFormatIsNotValidException.create(telemetryService);
        }
    }

}
