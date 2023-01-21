package dev.kraaakilo.socialclub.controllers;

import dev.kraaakilo.socialclub.requests.PostRequest;
import dev.kraaakilo.socialclub.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    final PostService postService;
    @PostMapping
    public void create(@RequestBody PostRequest postRequest){
        this.postService.createPost(postRequest);
    }
}
