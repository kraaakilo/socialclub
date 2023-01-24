package dev.kraaakilo.socialclub.services;

import dev.kraaakilo.socialclub.models.User;
import dev.kraaakilo.socialclub.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticatedUserModel {
    public final UserRepository userRepository;

    @Bean
    public User getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            return this.userRepository.findByEmail(
                    auth.getName()
            ).orElseThrow();
        }
        return null;
    }
}
