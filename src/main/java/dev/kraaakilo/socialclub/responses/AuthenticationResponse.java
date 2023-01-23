package dev.kraaakilo.socialclub.responses;

import dev.kraaakilo.socialclub.dto.UserDTO;
import dev.kraaakilo.socialclub.models.User;
import lombok.Builder;

@Builder
public class AuthenticationResponse {
    public boolean success;
    public String token;
    public UserDTO user;
}
