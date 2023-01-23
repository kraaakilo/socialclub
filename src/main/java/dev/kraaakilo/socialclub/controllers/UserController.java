package dev.kraaakilo.socialclub.controllers;

import dev.kraaakilo.socialclub.models.User;
import dev.kraaakilo.socialclub.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class UserController {
    final UserService userService;
    @GetMapping("/users")
    public List<User> getUsers(){
        return this.userService.getAllUsers();
    }
    @PostMapping("/register")
    public ResponseEntity<String> create(@RequestBody User user){
        this.userService.createUser(user);
        return ResponseEntity.ok("User created");
    }
}
