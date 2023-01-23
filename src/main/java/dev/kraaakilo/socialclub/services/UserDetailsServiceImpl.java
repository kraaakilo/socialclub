package dev.kraaakilo.socialclub.services;

import dev.kraaakilo.socialclub.models.User;
import dev.kraaakilo.socialclub.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    public final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByEmail(username).orElseThrow(
                () -> {
                    throw new UsernameNotFoundException("user not found");
                }
        );
    }
}
