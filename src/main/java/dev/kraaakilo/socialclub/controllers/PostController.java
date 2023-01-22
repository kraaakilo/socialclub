package dev.kraaakilo.socialclub.controllers;

import dev.kraaakilo.socialclub.dto.PostDTO;
import dev.kraaakilo.socialclub.models.Post;
import dev.kraaakilo.socialclub.requests.PostRequest;
import dev.kraaakilo.socialclub.services.MappingService;
import dev.kraaakilo.socialclub.services.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    final PostService postService;
    final MappingService mappingService;
    @GetMapping
    public List<PostDTO> getPosts(){
        return this.mappingService.getAllPostsDTO();
    }
    @PostMapping
    public void create(@Valid @RequestBody PostRequest postRequest){
        this.postService.createPost(postRequest);
    }
}
