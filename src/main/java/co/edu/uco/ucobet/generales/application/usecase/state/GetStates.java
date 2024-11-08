package co.edu.uco.ucobet.generales.application.usecase.state;

import co.edu.uco.ucobet.generales.application.usecase.UseCaseWithReturn;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

import java.util.List;

public interface GetStates extends UseCaseWithReturn<StateDomain, List<StateDomain>> {

}
