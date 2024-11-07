package co.edu.uco.ucobet.generales.application.primaryports.dto;

import java.util.UUID;

public final class GetStateDTO {

    private UUID id;
    private String name;
    private CountryDTO country;

    public GetStateDTO(final UUID id, final String name, final CountryDTO country) {
        setId(id);
        setName(name);
        setCountry(country);
    }

    public static GetStateDTO create(UUID id, String name, CountryDTO country) {
        return new GetStateDTO(id, name, country);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }
}
