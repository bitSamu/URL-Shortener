package resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import repository.ShortUrlRepository;

@Path("/s")
public class URLRedirectResource {

    @Inject
    ShortUrlRepository shortUrlRepository;

    @Inject
    @ConfigProperty(name = "domain.shorten.url")
    private String domain;

    /**
     * Redirects the client to the original URL associated with the provided short URL.
     * If the short URL is not found, returns a NOT FOUND response.
     *
     * @param shortUrl The short URL to be resolved to its original URL.
     * @return A response object containing either a redirection or a NOT FOUND status.
     */
    @GET
    @Path("/{shortUrl}")
    public Response redirectOriginalURL(@PathParam("shortUrl") String shortUrl) {
        // Retrieve the original URL associated with the short URL
        String originalUrl = shortUrlRepository.getOriginalUrl(domain + shortUrl);

        if (originalUrl != null) {
            // If the original URL is found, redirect the client to it
            return Response.seeOther(UriBuilder.fromUri(originalUrl).build()).build();
        } else {
            // If the short URL is not found, return a NOT FOUND response
            return Response.status(Response.Status.NOT_FOUND).entity("Short URL not found").build();
        }
    }
}
