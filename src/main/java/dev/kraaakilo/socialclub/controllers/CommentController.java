package dev.kraaakilo.socialclub.controllers;

import dev.kraaakilo.socialclub.requests.CommentRequest;
import dev.kraaakilo.socialclub.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/comments")
public class CommentController {
    final CommentService commentService;

    @PostMapping
    public void addComment(@RequestBody CommentRequest commentRequest) {
       this.commentService.createComment(commentRequest);
    }
}
