package dev.petiton.urlshortener.exception;

public class UrlNotFoundException extends RuntimeException {

    public UrlNotFoundException(String shortCode) {
        super("No url found for the code : " + shortCode);
    }
}