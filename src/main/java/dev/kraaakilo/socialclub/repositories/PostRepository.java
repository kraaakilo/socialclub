package dev.kraaakilo.socialclub.repositories;

import dev.kraaakilo.socialclub.models.Post;
import dev.kraaakilo.socialclub.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAll();
    Page<Post> findAll(Pageable pageable);
}
