package resource;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.UrlEntity;
import repository.ShortUrlRepository;

/**
 * JAX-RS resource class for handling URL shortening operations.
 */
@Path("/url")
public class ShortUrlResource {

    @Inject
    ShortUrlRepository shortUrlRepository;


    /**
     * Adds a new URL pair to the database.
     *
     * @param urlEntity the UrlEntity object containing the shortUrl and originalUrl
     * @return a message confirming the addition of the URL pair
     */
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public String addURLPair(UrlEntity urlEntity) {
        shortUrlRepository.addURLPair(urlEntity);
        return "Short URL: " + urlEntity.getShortUrl() + ", Original URL: " + urlEntity.getOriginalUrl();
    }


    /**
     * Retrieves all URL pairs from the database.
     *
     * @return a string representation of all URL pairs
     */
    @GET
    @Path("/getAll")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllURLPairs() {
        return shortUrlRepository.getAllURLPairs().toString();
    }
}