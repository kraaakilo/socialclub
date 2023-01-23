package dev.kraaakilo.socialclub.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LikeRequest {
    @NotNull
    public Long post_id;
}
