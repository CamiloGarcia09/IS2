package co.edu.uco.ucobet.generales.application.secondaryports.entity;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table (name = "City")
public final class CityEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "state")
    private StateEntity state;


    public CityEntity() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.EMPTY);
        setState(StateEntity.create());
    }

    public CityEntity(UUID id, String name, StateEntity state) {
        setId(id);
        setName(name);
        setState(state);
    }

    //Se agrega el public si se hace con el metodo mono
    public static CityEntity create() {
        return new CityEntity();
    }

    public static CityEntity create(final UUID id, final String name, final StateEntity state) {
        return new CityEntity(id, name, state);
    }

    public static CityEntity create(final UUID id) {
        return new CityEntity(id, TextHelper.EMPTY, StateEntity.create());
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public StateEntity getState() {
        return state;
    }

    public CityEntity setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
    }

    public CityEntity setName(final String name) {
        this.name = TextHelper.applyTrim(name);
        return this;
    }

    public CityEntity setState(final StateEntity state) {
        this.state = ObjectHelper.getDefault(state, StateEntity.create());
        return this;
    }
}
