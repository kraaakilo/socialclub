package dev.kraaakilo.socialclub.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationExceptionController {
    @GetMapping("/unauthenticated")
    public ResponseEntity<Object> unauthenticated() {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamps", Instant.now());
        body.put("message", "Unauthenticated");
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }
}
