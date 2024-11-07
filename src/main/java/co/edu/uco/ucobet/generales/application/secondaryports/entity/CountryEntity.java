package co.edu.uco.ucobet.generales.application.secondaryports.entity;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "Country")
public final class CountryEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    public CountryEntity() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.EMPTY);
    }

    public CountryEntity(final UUID id, final String name) {
        setId(id);
        setName(name);
    }

    public static CountryEntity create(){
        return new CountryEntity();
    }

    public static CountryEntity create(final UUID id){
        return new CountryEntity(id, TextHelper.EMPTY);
    }

    public static CountryEntity create(final UUID id, final String name){
        return new CountryEntity(id, name);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CountryEntity setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
    }

    public CountryEntity setName(String name) {
        this.name = TextHelper.applyTrim(name);
        return this;
    }

}
