package dev.kraaakilo.socialclub.controllers;

import dev.kraaakilo.socialclub.dto.PostDTO;
import dev.kraaakilo.socialclub.models.Post;
import dev.kraaakilo.socialclub.requests.PostRequest;
import dev.kraaakilo.socialclub.services.MappingService;
import dev.kraaakilo.socialclub.services.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/auth/posts")
@RequiredArgsConstructor
public class PostController {
    final PostService postService;
    final MappingService mappingService;
    @GetMapping
    public List<PostDTO> getPosts(@RequestParam(defaultValue = "0") int page){
        return this.mappingService.getAllPostsDTO(page);
    }
    @PostMapping
    public ResponseEntity<PostDTO> create(@Valid @RequestBody PostRequest postRequest){
        PostDTO postDTO = this.mappingService.convertEntityToDTO(
                this.postService.createPost(postRequest)
        );
        return ResponseEntity.ok(postDTO);
    }
}
