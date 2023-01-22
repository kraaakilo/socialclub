package dev.kraaakilo.socialclub.repositories;

import dev.kraaakilo.socialclub.models.Like;
import dev.kraaakilo.socialclub.models.Post;
import dev.kraaakilo.socialclub.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findLikeByPostAndUser(Post post, User user);
}
