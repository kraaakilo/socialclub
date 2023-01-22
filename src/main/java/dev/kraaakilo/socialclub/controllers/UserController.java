package dev.kraaakilo.socialclub.controllers;

import dev.kraaakilo.socialclub.models.User;
import dev.kraaakilo.socialclub.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    final UserService userService;
    @GetMapping
    public List<User> getUsers(){
        return this.userService.getAllUsers();
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody User user){
        this.userService.createUser(user);
        return ResponseEntity.ok("User created");
    }
}
