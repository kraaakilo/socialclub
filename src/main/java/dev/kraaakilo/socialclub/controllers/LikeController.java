package dev.kraaakilo.socialclub.controllers;

import dev.kraaakilo.socialclub.requests.LikeRequest;
import dev.kraaakilo.socialclub.services.LikeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/likes")
public class LikeController {
    public final LikeService likeService;
    @PostMapping
    public ResponseEntity<Object> like(@RequestBody @Valid LikeRequest likeRequest) {
        Map<String, Object> response = new HashMap<>();
        if (likeService.addLike(likeRequest)) {
            response.put("message", "added");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response.put("message", "removed");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
