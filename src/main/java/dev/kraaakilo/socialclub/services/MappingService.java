package dev.kraaakilo.socialclub.services;

import dev.kraaakilo.socialclub.dto.PostDTO;
import dev.kraaakilo.socialclub.dto.UserDTO;
import dev.kraaakilo.socialclub.models.Post;
import dev.kraaakilo.socialclub.models.User;
import dev.kraaakilo.socialclub.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MappingService {
    private final PostService postService;
    private final ModelMapper modelMapper;

    public List<PostDTO> getAllPostsDTO(int page) {
        Page<Post> posts = this.postService.getAllPostsWithPagination(page);
        return posts
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public PostDTO convertEntityToDTO(Post post) {
        PostDTO postDTO = modelMapper.map(post, PostDTO.class);
        UserDTO userDTO = UserDTO.builder()
                .lastname(post.getUser().getLastname())
                .firstname(post.getUser().getFirstname())
                .email(post.getUser().getEmail())
                .build();
        postDTO.setUser(userDTO);
        postDTO.setLikesCount(post.getLikes().size());
        return postDTO;
    }
}
