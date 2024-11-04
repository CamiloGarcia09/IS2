package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.data.sql.repository;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RepositoryUCOBETException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CityRepositoryCustomImpl implements CityRepositoryCustom {

    private final EntityManager entityManager;

    public CityRepositoryCustomImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<CityEntity> findByFilter(final CityEntity filter) {
        try {
            var criteriaBuilder = entityManager.getCriteriaBuilder();
            var query = criteriaBuilder.createQuery(CityEntity.class);
            var result = query.from(CityEntity.class);

            var predicates = new ArrayList<Predicate>();

            if (!ObjectHelper.isNull(filter)) {
                if (!UUIDHelper.isDefault(filter.getId())) {
                    predicates.add(criteriaBuilder.equal(result.get("id"), filter.getId()));
                }
                if (!TextHelper.isEmpty(filter.getName())) {
                    predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(result.get("name")), filter.getName().toUpperCase()));
                }
                if (!UUIDHelper.isDefault(filter.getState().getId())) {
                    predicates.add(criteriaBuilder.equal(result.get("state").get("id"), filter.getState().getId()));
                }
            }

            query.select(result).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            return entityManager.createQuery(query).getResultList();

        }catch (final Exception exception){
            throw RepositoryUCOBETException.create(MessageHelper.getMessage("M002"),
                    MessageHelper.getMessage("M003"), exception);
        }
    }

    @Override
    public boolean isCityBeingUsed(UUID cityId) {
        try {
            var criteriaBuilder = entityManager.getCriteriaBuilder();
            var query = criteriaBuilder.createQuery(Long.class);
            var root = query.from(CityEntity.class);

            query.select(criteriaBuilder.count(root)).where(criteriaBuilder.equal(root.get("id"), cityId));

            Long count = entityManager.createQuery(query).getSingleResult();

            return count > 0;

        } catch (final Exception exception) {
            throw RepositoryUCOBETException.create(MessageHelper.getMessage("M004"),
                     MessageHelper.getMessage("M005"), exception);
        }
    }
}
