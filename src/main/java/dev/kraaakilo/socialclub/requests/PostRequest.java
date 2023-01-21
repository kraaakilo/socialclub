package dev.kraaakilo.socialclub.requests;

import dev.kraaakilo.socialclub.models.Post;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class PostRequest {
    public Post toPost() {
        return Post.builder()
                .text(this.text)
                .media(this.media)
                .build();
    }

    @NotNull
    @NotEmpty
    public Long user_id;
    public String text;
    public String media;
}
