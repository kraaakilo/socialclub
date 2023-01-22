package dev.kraaakilo.socialclub.services;

import dev.kraaakilo.socialclub.models.Like;
import dev.kraaakilo.socialclub.models.Post;
import dev.kraaakilo.socialclub.models.User;
import dev.kraaakilo.socialclub.repositories.LikeRepository;
import dev.kraaakilo.socialclub.repositories.PostRepository;
import dev.kraaakilo.socialclub.repositories.UserRepository;
import dev.kraaakilo.socialclub.requests.LikeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {
    public final LikeRepository likeRepository;
    public final PostService postService;
    public final UserService userService;

    public boolean addLike(LikeRequest likeRequest) {
        User user = this.userService.getUser(likeRequest.user_id);
        Post post = this.postService.getPost(likeRequest.post_id);
        Optional<Like> optionalLike = this.likeRepository.findLikeByPostAndUser(post, user);
        if (optionalLike.isEmpty()) {
            Like like = Like.builder()
                    .post(post)
                    .user(user)
                    .build();
            this.likeRepository.save(like);
            return true;
        } else {
            this.likeRepository.delete(optionalLike.get());
            return false;
        }
    }
}
