package dev.kraaakilo.socialclub.requests;

import dev.kraaakilo.socialclub.models.Comment;
import dev.kraaakilo.socialclub.models.Like;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LikeRequest {
    @NotNull
    public Long user_id;
    @NotNull
    public Long post_id;
}
