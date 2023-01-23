package dev.kraaakilo.socialclub.requests;

import dev.kraaakilo.socialclub.models.Post;
import jakarta.validation.constraints.NotEmpty;

public class PostRequest {
    public Post toPost() {
        return Post.builder()
                .text(this.text)
                .media(this.media)
                .build();
    }
    public String text;
    public String media;
}
