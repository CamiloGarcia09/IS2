package co.edu.uco.ucobet.generales.application.primaryports.interactor.state.getstate.impl;


import co.edu.uco.ucobet.generales.application.primaryports.dto.GetStateDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.state.getstate.GetStatesInteractor;
import co.edu.uco.ucobet.generales.application.primaryports.mapper.StateMapper;
import co.edu.uco.ucobet.generales.application.useCase.state.getstates.GetStates;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GetStatesInteractorImpl implements GetStatesInteractor {

    private final GetStates getStates;

    public GetStatesInteractorImpl(GetStates getStates) {
        this.getStates = getStates;
    }

    @Override
    public List<GetStateDTO> execute(GetStateDTO data) {
        return getStates.execute(null).stream()
                .map(StateMapper.INSTANCE::toListStateDomain)
                .collect(Collectors.toList());
    }
}
