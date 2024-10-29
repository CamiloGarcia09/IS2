package co.edu.uco.ucobet.generales.domain.state;

import co.edu.uco.ucobet.generales.domain.Domain;
import co.edu.uco.ucobet.generales.domain.country.CountryDomain;

import java.util.UUID;

public final class StateDomain extends Domain {

    private String name;
    private CountryDomain country;

    public StateDomain(final UUID id, final String name, final CountryDomain country) {
        super(id);
        setName(name);
        setCountry(country);
    }

    public static StateDomain create(UUID id,String name,CountryDomain country) {
        return new StateDomain(id, name, country);
    }

    public String getName() {
        return name;
    }

    public CountryDomain getCountry() {
        return country;
    }

    private void setName(final String name) {
        this.name = name;
    }

    private void setCountry(final CountryDomain country) {
        this.country = country;
    }
}
