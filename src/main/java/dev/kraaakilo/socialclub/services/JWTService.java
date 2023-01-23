package dev.kraaakilo.socialclub.services;

import dev.kraaakilo.socialclub.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Service
public class JWTService {
    public String extractEmail(String token) {
        return this.getClaims(token).getSubject();
    }

    public Key generateSigningKey() {
        String JWT_S = "482B4D6251655368566D597133743677397A24432646294A404E635266556A57";
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(JWT_S));
    }

    public boolean isTokenValid(String token, UserDetails user) {
        try {
            return !this.getClaims(token).getExpiration().before(new Date())
                    && this.getClaims(token).getSubject().equals(user.getUsername());
        } catch (Exception e) {
            return false;
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(generateSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateToken(User user) {
        return Jwts.builder()
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plusSeconds(10000000)))
                .setId(UUID.randomUUID().toString())
                .setSubject(user.getEmail())
                .signWith(this.generateSigningKey())
                .compact();
    }
    public String generateToken(Authentication token) {
        return Jwts.builder()
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plusSeconds(10000000)))
                .setId(UUID.randomUUID().toString())
                .setSubject(token.getName())
                .signWith(this.generateSigningKey())
                .compact();
    }
}
