package model;

import jakarta.persistence.*;

@Entity
public class UrlEntity {

    public UrlEntity() {}

    public UrlEntity(Long id, String shortUrl, String originalUrl) {
        this.id = id;
        this.shortUrl = shortUrl;
        this.originalUrl = originalUrl;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The shortend URL in Bas 62 Format
     */
    private String shortUrl;

    /**
     * The original URL, where the user gets relocated
     */
    private String originalUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    @Override
    public String toString() {
        return "UrlEntity [id=" + id + ", shortUrl=" + shortUrl + ", longUrl=" + originalUrl + "]";
    }
}