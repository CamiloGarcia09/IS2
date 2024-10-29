package co.edu.uco.ucobet.generales.application.secondaryports.repository.custom;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CityRepositoryCustom {

    List<CityEntity> findByFilter(CityEntity filter);
    boolean isCityBeingUsed(UUID cityId);
}
