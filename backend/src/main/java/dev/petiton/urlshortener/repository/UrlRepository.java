package dev.petiton.urlshortener.repository;

import dev.petiton.urlshortener.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByShortCode(String shortCode);
    boolean existsByShortCode(String shortCode);
}
