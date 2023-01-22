package dev.kraaakilo.socialclub.dto;

import dev.kraaakilo.socialclub.models.Comment;
import dev.kraaakilo.socialclub.models.Like;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PostDTO {
    public String text;
    public String media;
    public UserDTO user;
    public List<Comment> comments;
    public int likesCount;
    public Date created;
}
