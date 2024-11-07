package co.edu.uco.ucobet.generales.application.primaryports.dto;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public final class CountryDTO {

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

    public void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    private void setName(final String name) {
        this.name = TextHelper.applyTrim(name);
    }
}
