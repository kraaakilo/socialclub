package dev.kraaakilo.socialclub.controllers;

import dev.kraaakilo.socialclub.config.AppAuthProvider;
import dev.kraaakilo.socialclub.requests.LoginRequest;
import dev.kraaakilo.socialclub.responses.AuthenticationResponse;
import dev.kraaakilo.socialclub.services.JWTService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class AuthenticationController {
    public final AppAuthProvider authProvider;
    public final JWTService jwtService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        String token = jwtService.generateToken(
                authProvider.authenticate(
                        new UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password)
                ));
        return ResponseEntity.ok(AuthenticationResponse.builder().success(true).token(token).build());
    }
}
