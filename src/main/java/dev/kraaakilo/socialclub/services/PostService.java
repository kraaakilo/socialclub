package dev.kraaakilo.socialclub.services;

import dev.kraaakilo.socialclub.exceptions.DataNotFoundException;
import dev.kraaakilo.socialclub.models.Post;
import dev.kraaakilo.socialclub.repositories.PostRepository;
import dev.kraaakilo.socialclub.requests.PostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    public void createPost(Post post) {
        this.postRepository.save(post);
    }

    public void createPost(PostRequest postRequest) {
        Post post = postRequest.toPost();
        post.setUser(userService.getUser(postRequest.user_id));
        this.postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return this.postRepository.findAll();
    }

    public Post getPost(Long id) {
        return this.postRepository.findById(id).orElseThrow(() -> {
            throw new DataNotFoundException("Comment Not found");
        });
    }
}
