package dev.kraaakilo.socialclub.config;

import dev.kraaakilo.socialclub.models.User;
import dev.kraaakilo.socialclub.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
public class AppAuthProvider implements AuthenticationProvider {
    public final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public AppAuthProvider(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = this.userDetailsService.loadUserByUsername(username);

        if (password.equals("password")) {
            return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
        } else {
            throw new BadCredentialsException("Invalid credentials");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
