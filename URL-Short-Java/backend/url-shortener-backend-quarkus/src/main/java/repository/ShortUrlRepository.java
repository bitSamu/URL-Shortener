package repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import model.UrlEntity;

import java.util.List;

/**
 * Repository class for managing URL entities.
 */
@ApplicationScoped
public class ShortUrlRepository {
    @PersistenceContext
    EntityManager em;

    /**
     * Creates a new URL entity in the database.
     *
     * @param urlEntity the URL entity to be created
     */
    @Transactional
    public void addURLPair(UrlEntity urlEntity) {
        em.persist(urlEntity);
    }

    // TODO: 26.02.2024 Implement getURLById Function
    // TODO: 26.02.2024 Implement deleteURL Function


    /**
     * Retrieves all URL entities from the database.
     *
     * @return a list of all URL entities
     */
    public List<UrlEntity> getAllURLPairs() {
        return em.createQuery("SELECT u FROM UrlEntity u", UrlEntity.class).getResultList();
    }
}
