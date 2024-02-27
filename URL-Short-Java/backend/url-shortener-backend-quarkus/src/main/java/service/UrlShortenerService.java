package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.xml.bind.DatatypeConverter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Service class for URL shortening functionality.
 */
@ApplicationScoped
public class UrlShortenerService {

    private Map<String, String> urlMap;

    // Define characters allowed in the shortened URL
    private static final String base62alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private char[] base62alphabetArray = base62alphabet.toCharArray();
    private int base = base62alphabetArray.length;

    public UrlShortenerService() {
        this.urlMap = new HashMap<>();
    }

    /**
     * Shortens a URL by generating a unique short code.
     *
     * @param originalUrl The original URL to shorten.
     * @return The shortened URL.
     */
    public String shortenUrl(String originalUrl) {
        // Generate a short URL from the original URL
        String shortUrl = generateShortUrl(originalUrl);
        // Store the mapping between the short URL and the original URL
        urlMap.put(shortUrl, originalUrl);
        // Return the shortened URL
        return shortUrl;
    }

    /**
     * Hashes a URL using MD5 algorithm.
     *
     * @param originalUrl The URL to be hashed.
     * @return The first seven digits of the hexadecimal representation of the hash.
     */
    private String generateShortUrl(String originalUrl) {
        try {
            // Create a MessageDigest instance for MD5 hashing
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(originalUrl.getBytes());
            byte[] digest = md.digest();
            return DatatypeConverter.printHexBinary(digest).toUpperCase().substring(0, 7);
        }
        catch (NoSuchAlgorithmException ignored){}
        return null;
    }
}

