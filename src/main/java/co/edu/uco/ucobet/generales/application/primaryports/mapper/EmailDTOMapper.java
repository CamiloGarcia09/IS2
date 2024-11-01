package co.edu.uco.ucobet.generales.application.primaryports.mapper;

import co.edu.uco.ucobet.generales.application.primaryports.dto.SendEmailDTO;
import co.edu.uco.ucobet.generales.domain.EmailData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmailDTOMapper {

    EmailDTOMapper INSTANCE = Mappers.getMapper(EmailDTOMapper.class);

    EmailData toDomain(SendEmailDTO dto);
}