package dev.petiton.urlshortener.service;

import dev.petiton.urlshortener.entity.Url;
import dev.petiton.urlshortener.exception.UrlNotFoundException;
import dev.petiton.urlshortener.repository.UrlRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UrlService {
  private static final int CODE_LENGTH = 6;

  private final UrlRepository urlRepository;

  public UrlService(UrlRepository urlRepository) {
    this.urlRepository = urlRepository;
  }

  public Url createShortUrl(String originalUrl) {
    while (true) {
      try {
        String shortCode = RandomStringUtils.secure().nextAlphanumeric(CODE_LENGTH);
        return urlRepository.save(new Url(shortCode, originalUrl));
      } catch (DataIntegrityViolationException ignored) {

      }
    }
  }

  public Url resolve(String shortCode) {
    Url url =
        urlRepository
            .findByShortCode(shortCode)
            .orElseThrow(() -> new UrlNotFoundException(shortCode));

    url.incrementClickCount();
    urlRepository.save(url);
    return url;
  }
}
