package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.data.sql.repository;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;

import java.util.List;
import java.util.UUID;

public interface CityRepositoryCustom {

    List<CityEntity> findByFilter(CityEntity filter);
    boolean isCityBeingUsed(UUID cityId);
}
