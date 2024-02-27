package resource;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UrlResource {
    /**
     * The original URL, where the user gets relocated
     */
    private String originalUrl;

    public UrlResource() {}

    public UrlResource(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    @Override
    public String toString() {
        return "UrlResource [longUrl=" + originalUrl + "]";
    }
}
