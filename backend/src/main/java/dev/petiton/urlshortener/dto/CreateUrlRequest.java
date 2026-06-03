package dev.petiton.urlshortener.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CreateUrlRequest {
    @NotBlank(message = "Url can't be blank")
    @Pattern(
            regexp = "^https?://.+",
            message = "Url has to start with http:// ou https://"
    )
    private String originalUrl;

    public CreateUrlRequest() {
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}