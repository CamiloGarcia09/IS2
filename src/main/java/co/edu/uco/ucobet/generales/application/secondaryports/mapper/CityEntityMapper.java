package co.edu.uco.ucobet.generales.application.secondaryports.mapper;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CityEntityMapper {

    CityEntityMapper INSTANCE = Mappers.getMapper(CityEntityMapper.class);

    CityEntity toEntity(CityDomain domain);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "state", target = "state")
    CityDomain toDomain(CityEntity entity);


    List<CityEntity> toEntityList(List<CityDomain> domainCollection);
    List<CityDomain> toDomainList(List<CityEntity> entityCollection);
}
