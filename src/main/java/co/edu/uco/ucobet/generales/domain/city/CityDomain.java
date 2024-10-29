package co.edu.uco.ucobet.generales.domain.city;

import co.edu.uco.ucobet.generales.domain.Domain;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

import java.util.UUID;

public final class CityDomain extends Domain {

    private String name;
    private StateDomain state;

    public CityDomain(final UUID id, final String name, final StateDomain state) {
        super(id);
        setName(name);
        setState(state);
    }

    public String getName() {
        return name;
    }

    public StateDomain getState() {
        return state;
    }

    private void setName(final String name) {
        this.name = name;
    }

    private void setState(final StateDomain state) {
        this.state = state;
    }

}
