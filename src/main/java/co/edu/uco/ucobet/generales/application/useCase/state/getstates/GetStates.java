package co.edu.uco.ucobet.generales.application.useCase.state.getstates;

import co.edu.uco.ucobet.generales.application.useCase.UseCaseWithReturn;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

import java.util.List;

public interface GetStates extends UseCaseWithReturn<StateDomain, List<StateDomain>> {
}
