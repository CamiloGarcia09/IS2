package co.edu.uco.ucobet.generales.application.primaryports.mapper;

import co.edu.uco.ucobet.generales.application.primaryports.dto.CountryDTO;
import co.edu.uco.ucobet.generales.domain.country.CountryDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    CountryDomain toDomain(CountryDTO dto);
}
