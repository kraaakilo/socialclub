package dev.kraaakilo.socialclub.services;

import dev.kraaakilo.socialclub.models.Comment;
import dev.kraaakilo.socialclub.models.Post;
import dev.kraaakilo.socialclub.repositories.CommentRepository;
import dev.kraaakilo.socialclub.repositories.PostRepository;
import dev.kraaakilo.socialclub.requests.CommentRequest;
import dev.kraaakilo.socialclub.requests.PostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostService postService;

    public void createComment(Comment comment) {
        this.commentRepository.save(comment);
    }

    public void createComment(CommentRequest commentRequest) {
        Comment comment = commentRequest.toComment();
        comment.setPost(this.postService.getPost(commentRequest.post_id));
        this.commentRepository.save(comment);
    }
}
