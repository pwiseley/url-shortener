package dev.petiton.urlshortener.dto;

import dev.petiton.urlshortener.entity.Url;

public record UrlResponse(String shortCode, String originalUrl, String shortUrl) {

  public static UrlResponse fromEntity(Url url, String baseUrl) {
    return new UrlResponse(
        url.getShortCode(), url.getOriginalUrl(), baseUrl + "/" + url.getShortCode());
  }
}
