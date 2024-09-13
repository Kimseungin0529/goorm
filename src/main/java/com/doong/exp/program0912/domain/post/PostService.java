package com.doong.exp.program0912.domain.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service @Slf4j
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public Long createPost(PostDto postDto){
        Post post = Post.builder()
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .build();
        Post savedPost = postRepository.save(post);
        return savedPost.getPostId();
    }
    public void modifyPost(Long postId, PostDto postDto){
        Post findPost = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));
        if(postDto.getContent() != null){
            findPost.modifyTitle(postDto.getTitle());
        }
        if(postDto.getContent() != null){
            findPost.modifyContent(postDto.getContent());
        }
    }

    public PostDto findPostById(Long postId){
        Post findPost = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));

        return PostDto.builder()
                .title(findPost.getTitle())
                .content(findPost.getContent())
                .build();
    }

    public List<PostDto> findAllPost(){
        return postRepository.findAll().stream()
                .map(post -> PostDto.builder()
                        .title(post.getTitle())
                        .content(post.getContent())
                        .build()
                )
                .collect(Collectors.toList());
    }
    public void removePostById(Long postId){
        postRepository.deleteById(postId);
    }
}
