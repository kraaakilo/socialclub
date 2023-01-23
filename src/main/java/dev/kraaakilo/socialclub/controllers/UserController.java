package dev.kraaakilo.socialclub.controllers;

import dev.kraaakilo.socialclub.models.User;
import dev.kraaakilo.socialclub.repositories.UserRepository;
import dev.kraaakilo.socialclub.responses.AuthenticationResponse;
import dev.kraaakilo.socialclub.services.JWTService;
import dev.kraaakilo.socialclub.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {
    final UserService userService;
    final UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return this.userService.getAllUsers();
    }
    @GetMapping("/me")
    public ResponseEntity<Map<String,Object>> getMe(Principal principal) {
        Map<String,Object> response = new HashMap<>();
        User user = this.userRepository.findByEmail(principal.getName()).orElseThrow();
        response.put("email",user.getEmail());
        response.put("firstname",user.getFirstname());
        response.put("lastname",user.getLastname());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
