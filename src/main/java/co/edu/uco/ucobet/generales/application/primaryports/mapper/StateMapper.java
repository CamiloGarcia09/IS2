package co.edu.uco.ucobet.generales.application.primaryports.mapper;

import co.edu.uco.ucobet.generales.application.primaryports.dto.GetCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.dto.GetStateDTO;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;

@Mapper(uses = CountryMapper.class)
public interface StateMapper {

    StateMapper INSTANCE = Mappers.getMapper(StateMapper.class);


    StateDomain toDomain(GetStateDTO dto);

    @Mapping(source = "country", target = "country")
    GetStateDTO toListStateDomain(StateDomain domain);
}
