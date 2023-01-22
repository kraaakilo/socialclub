package dev.kraaakilo.socialclub.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;


@Builder
public class UserDTO {
    public String firstname;
    public String lastname;
    public String email;
}
