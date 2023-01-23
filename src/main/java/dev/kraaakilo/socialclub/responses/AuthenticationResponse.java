package dev.kraaakilo.socialclub.responses;

import lombok.Builder;

@Builder
public class AuthenticationResponse {
    public boolean success;
    public String token;
}
