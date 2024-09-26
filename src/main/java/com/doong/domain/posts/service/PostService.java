package com.doong.domain.posts.service;

import com.doong.domain.posts.dto.PostRequestDto;
import com.doong.domain.posts.model.Post;
import com.doong.domain.posts.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postsRepository;

    @Transactional
    public void addPost(PostRequestDto dto){
        Post post = Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
        postsRepository.save(post);
    }

    @Transactional
    public void modifyPost(Long postId, PostRequestDto dto){
        Post findPosts = postsRepository.findById(postId).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 게시물입니다."));

        findPosts.modifyTitle(dto.getTitle());
        findPosts.modifyContent(dto.getContent());
    }

    public Post findPost(Long postId){
        return postsRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));
    }

    public List<Post> findAllPosts(){
        return postsRepository.findAll();
    }
}
