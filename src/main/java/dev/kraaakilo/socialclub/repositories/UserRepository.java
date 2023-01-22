package dev.kraaakilo.socialclub.repositories;

import dev.kraaakilo.socialclub.models.Post;
import dev.kraaakilo.socialclub.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
//    Optional<User> findByPos(Post post);
}
