package dev.kraaakilo.socialclub.dto;

import dev.kraaakilo.socialclub.models.User;
import lombok.Builder;


@Builder
public class UserDTO {
    public static UserDTO fromUser(User user) {
        return UserDTO.builder()
                .email(user.getEmail())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .profile(user.getProfile())
                .build();
    }

    public String firstname;
    public String lastname;
    public String email;
    public String profile;
}
