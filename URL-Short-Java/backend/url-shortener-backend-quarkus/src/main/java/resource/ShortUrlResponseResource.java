package resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import repository.ShortUrlRepository;

@Path("/s")
public class ShortUrlResponseResource {

    @Inject
    ShortUrlRepository shortUrlRepository;

    @GET
    @Path("/{shortUrl}")
    public Response getAllURLPairs(@PathParam("shortUrl") String shortUrl) {
        String originalUrl = shortUrlRepository.getOriginalUrl(shortUrl);

        if (originalUrl != null) {
            // If the original URL exists, redirect the client to it
            return Response.seeOther(UriBuilder.fromUri(originalUrl).build()).build();
        } else {
            // If the original URL does not exist, return a 404 Not Found response
            return Response.status(Response.Status.NOT_FOUND).entity("Short URL not found").build();
        }
    }
}
