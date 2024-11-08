package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameLenghtIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameLengthIsValidRule;
import org.springframework.stereotype.Service;

@Service
public final class CityNameLengthIsValidRuleImpl implements CityNameLengthIsValidRule {

    private static final int MIN_NAME_LENGTH=4;
    private static final int MAX_NAME_LENGTH=90;
    private final TelemetryService telemetryService;
    private final MessageService messageService;

    public CityNameLengthIsValidRuleImpl(final TelemetryService telemetryService,
                                         final MessageService messageService) {
        this.telemetryService = telemetryService;
        this.messageService = messageService;
    }

    @Override
    public void validate(String data) {
        if(data.length()<=MIN_NAME_LENGTH || data.length()>MAX_NAME_LENGTH){
            throw CityNameLenghtIsNotValidException.create(telemetryService, messageService);
        }
    }
}
