package co.edu.uco.ucobet.generales.application.secondaryports.mapper;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.StateEntity;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StateEntityMapper {

    StateEntityMapper INSTANCE = Mappers.getMapper(StateEntityMapper.class);

    StateEntity toEntity(StateDomain domain);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "country", target = "country")  // Ajusta el mapeo si es necesario
    StateDomain toDomain(StateEntity entity);

    List<StateEntity> toEntityList(List<StateDomain> domainCollection);
    List<StateDomain> toDomainList(List<StateEntity> entityCollection);
}
