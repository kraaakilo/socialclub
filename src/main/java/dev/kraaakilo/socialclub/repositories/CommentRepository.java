package dev.kraaakilo.socialclub.repositories;

import dev.kraaakilo.socialclub.models.Comment;
import dev.kraaakilo.socialclub.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
