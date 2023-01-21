package dev.kraaakilo.socialclub.controllers;

import dev.kraaakilo.socialclub.models.User;
import dev.kraaakilo.socialclub.services.UserService;
import lombok.RequiredArgsConstructor;
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
    public void create(@RequestBody User user){
        this.userService.createUser(user);
    }
}
