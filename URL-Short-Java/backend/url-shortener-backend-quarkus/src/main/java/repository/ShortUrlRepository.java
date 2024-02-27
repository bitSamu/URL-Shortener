package repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import model.UrlEntity;
import service.UrlShortenerService;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Repository class for managing URL entities.
 */
@ApplicationScoped
public class ShortUrlRepository {
    @PersistenceContext
    EntityManager em;

    @Inject
    UrlShortenerService service;

    @Inject
    @ConfigProperty(name = "domain.shorten.url")
    private String domain;

    /**
     * Creates a new URL entity with the shortend url in the database.
     *
     * @param urlEntity the URL entity to be created
     */
    @Transactional
    public void addURLPair(UrlEntity urlEntity) {
        urlEntity.setShortUrl(domain + service.shortenUrl(urlEntity.getOriginalUrl()));
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

    /**
     * Retrieves the original URL to a given short URL
     *
     * @param shortUrl The short URL to get the corresponding URL
     * @return Either the original URL or null, if the original URL to the given URL does not exist
     */
    public String getOriginalUrl(String shortUrl){
        return em.createQuery("SELECT u.originalUrl FROM UrlEntity u WHERE u.shortUrl = :shortUrl", String.class)
                .setParameter("shortUrl", shortUrl)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }
}
