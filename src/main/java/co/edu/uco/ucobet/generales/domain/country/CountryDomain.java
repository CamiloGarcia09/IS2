package co.edu.uco.ucobet.generales.domain.country;

import co.edu.uco.ucobet.generales.domain.Domain;

import java.util.UUID;

public final class CountryDomain extends Domain {

    private String name;

    public CountryDomain(final UUID id, final String name) {
        super(id);
        setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(final String name) {
        this.name = name;
    }
}
