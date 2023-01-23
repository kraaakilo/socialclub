package dev.kraaakilo.socialclub.controllers;

import dev.kraaakilo.socialclub.config.AppAuthProvider;
import dev.kraaakilo.socialclub.dto.UserDTO;
import dev.kraaakilo.socialclub.models.User;
import dev.kraaakilo.socialclub.repositories.UserRepository;
import dev.kraaakilo.socialclub.requests.LoginRequest;
import dev.kraaakilo.socialclub.responses.AuthenticationResponse;
import dev.kraaakilo.socialclub.services.JWTService;
import dev.kraaakilo.socialclub.services.MappingService;
import dev.kraaakilo.socialclub.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class AuthenticationController {
    public final AppAuthProvider authProvider;
    public final UserService userService;
    public final UserRepository userRepository;
    public final JWTService jwtService;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> create(@RequestBody User userRequest) {
        this.userService.createUser(userRequest);
        String token = this.jwtService.generateToken(userRequest);
        UserDTO user = UserDTO.fromUser(this.userRepository.findByEmail(userRequest.getEmail()).orElseThrow());
        return ResponseEntity.ok(AuthenticationResponse.builder().user(user).success(true).token(token).build());
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        String token = this.jwtService.generateToken(authProvider.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password)
        ));
        UserDTO user = UserDTO.fromUser(this.userRepository.findByEmail(loginRequest.username).orElseThrow());
        return ResponseEntity.ok(AuthenticationResponse.builder().user(user).success(true).token(token).build());
    }
}
