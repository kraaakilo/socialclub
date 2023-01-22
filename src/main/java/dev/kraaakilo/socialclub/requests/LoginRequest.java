package dev.kraaakilo.socialclub.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginRequest {
    @NotEmpty
    public String username;
    @NotEmpty
    public String password;
}
