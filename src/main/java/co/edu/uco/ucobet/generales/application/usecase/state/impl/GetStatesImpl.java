package co.edu.uco.ucobet.generales.application.usecase.state.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.application.usecase.state.GetStates;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetStatesImpl implements GetStates {

    private final StateRepository stateRepository;

    public GetStatesImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public List<StateDomain> execute(StateDomain domain) {
        return stateRepository.findAll().stream()
                .map(StateEntityMapper.INSTANCE::toDomain)
                .toList();
    }

}
