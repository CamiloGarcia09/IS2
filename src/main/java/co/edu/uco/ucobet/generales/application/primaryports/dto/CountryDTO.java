package co.edu.uco.ucobet.generales.application.primaryports.dto;

import java.util.UUID;

public class CountryDTO {

    private UUID id;
    private String name;

    public CountryDTO(final UUID id, final String name) {
        setId(id);
        setName(name);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private void setName(final String name) {
        this.name = name;
    }
}
