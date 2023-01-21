package dev.kraaakilo.socialclub.requests;

import dev.kraaakilo.socialclub.models.Comment;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CommentRequest {
    public Comment toComment() {
        return Comment.builder()
                .content(this.content)
                .media(this.media)
                .build();
    }
    @NotNull
    @NotEmpty
    public Long post_id;
    public String content;
    public String media;
}
