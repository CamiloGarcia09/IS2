package co.edu.uco.ucobet.generales.application.primaryports.mapper;

import co.edu.uco.ucobet.generales.application.primaryports.dto.EmailDataDTO;
import co.edu.uco.ucobet.generales.domain.EmailData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmailDataMapper {

    EmailDataMapper INSTANCE = Mappers.getMapper(EmailDataMapper.class);

    EmailData toDomain(EmailDataDTO dto);
}