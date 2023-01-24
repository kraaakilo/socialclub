package dev.kraaakilo.socialclub.services;

import dev.kraaakilo.socialclub.dto.PostDTO;
import dev.kraaakilo.socialclub.dto.UserDTO;
import dev.kraaakilo.socialclub.models.Post;
import dev.kraaakilo.socialclub.models.User;
import dev.kraaakilo.socialclub.repositories.LikeRepository;
import dev.kraaakilo.socialclub.repositories.PostRepository;
import dev.kraaakilo.socialclub.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MappingService {
    private final PostService postService;
    private final ModelMapper modelMapper;
    private final LikeRepository likeRepository;
    private final AuthenticatedUserModel auth;

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
                .profile(post.getUser().getProfile())
                .build();
        postDTO.setUser(userDTO);
        postDTO.setLikesCount(post.getLikes() == null ? 0 : post.getLikes().size());
        postDTO.setLikedbyme(
                likeRepository.findLikeByPostAndUser(post, auth.getUser()).isPresent()
        );
        return postDTO;
    }
}
