package dev.kraaakilo.socialclub.services;

import dev.kraaakilo.socialclub.exceptions.DataNotFoundException;
import dev.kraaakilo.socialclub.exceptions.ResourceAlreadyExistsException;
import dev.kraaakilo.socialclub.models.User;
import dev.kraaakilo.socialclub.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void createUser(User user) {
        this.userRepository.findByEmail(user.getEmail()).ifPresent(
                (userOp) -> {
                    throw new ResourceAlreadyExistsException("");
                }
        );
        this.userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User getUser(Long id) {
        return this.userRepository.findById(id).orElseThrow(() -> {
            throw new DataNotFoundException("User Not found");
        });
    }
}

