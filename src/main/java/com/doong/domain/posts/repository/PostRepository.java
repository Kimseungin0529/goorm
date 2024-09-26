package com.doong.domain.posts.repository;

import com.doong.domain.posts.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByTitleAndContent(String title, String Content);
}
