package dev.petiton.urlshortener.controller;

import dev.petiton.urlshortener.dto.CreateUrlRequest;
import dev.petiton.urlshortener.dto.UrlResponse;
import dev.petiton.urlshortener.entity.Url;
import dev.petiton.urlshortener.service.UrlService;
import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/urls")
public class UrlController {

  private final UrlService urlService;

  public UrlController(UrlService urlService) {
    this.urlService = urlService;
  }

  @PostMapping
  public ResponseEntity<UrlResponse> create(@Valid @RequestBody CreateUrlRequest request) {
    Url created = urlService.createShortUrl(request.getOriginalUrl());
    String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
    UrlResponse body = UrlResponse.fromEntity(created, baseUrl);

    return ResponseEntity.status(HttpStatus.CREATED).body(body);
  }
}
