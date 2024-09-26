package com.doong.domain.posts.controller;

import com.doong.domain.posts.dto.PostRequestDto;
import com.doong.domain.posts.model.Post;
import com.doong.domain.posts.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute PostRequestDto request){
        postService.addPost(request);
        return "create";
    }

    @PutMapping("/posts/{id}/edit")
    public String modifyPost(Model model, @PathVariable("id") Long postId, @ModelAttribute PostRequestDto dto){
        postService.modifyPost(postId, dto);
        return "edit";
    }

    @GetMapping("/posts")
    public String showPosts(Model model){
        List<Post> allPosts = postService.findAllPosts();

       /* Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // 사용자 이메일을 모델에 추가
        model.addAttribute("email" ,userDetails.getUsername());*/
        model.addAttribute("posts", allPosts);

        return "list";
    }
}
