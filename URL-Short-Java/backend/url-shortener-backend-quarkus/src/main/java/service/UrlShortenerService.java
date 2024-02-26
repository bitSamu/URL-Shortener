package service;

import java.util.HashMap;
import java.util.Map;

/**
 * Service class for URL shortening functionality.
 */
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
     * Generates a unique shortened URL based on the original URL.
     *
     * @param originalUrl The original URL.
     * @return The shortened URL.
     */
    public String generateShortUrl(String originalUrl){
        int urlLength = originalUrl.length();
        int i = 0;
        int counter;
        int result = 0;

        while(i <= urlLength){
            counter = i + 1;
            final int mapped = base62alphabet.indexOf(originalUrl.charAt(i));
            result += result + (mapped * Math.pow(base, urlLength - counter));
            i++;
        }

        return String.valueOf(result);
    }
}

