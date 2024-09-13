package com.doong.exp.program0912.domain.post;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Tag(name = "Post", description = "Post 관련 API 입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;


    @Operation(
            summary = "게시물 생성",
            description = "게시물을 생성합니다."
    )
    @ApiResponse(
            responseCode = "201",
            description = "게시물 생성을 성공하였습니다."
    )
    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostDto postDto){
        Long postId = postService.createPost(postDto);
        return ResponseEntity.created(URI.create("/posts/" + postId)).build();
    }


    @Operation(
            summary = "게시물 수정",
            description = "게시물을 수정합니다."
    )
    @ApiResponse(
            responseCode = "200",
            description = "게시물 수정을 성공하였습니다."
    )
    @PutMapping("/{id}")
    public ResponseEntity<?> modifyPost(@PathVariable Long id, @RequestBody PostDto postDto){
        postService.modifyPost(id, postDto);
        return ResponseEntity.ok().body("게시물 수정했습니다.");
    }

    @Operation(
            summary = "게시물 삭제",
            description = "게시물을 삭제합니다."
    )
    @ApiResponse(
            responseCode = "204",
            description = "게시물 삭제에 성공했습니다."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id){
        postService.removePostById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "게시물 조회",
            description = "게시물을 조회합니다."
    )
    @ApiResponse(
            responseCode = "200",
            description = "게시물 조회를 성공하였습니다."
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> findPost(@PathVariable Long id){
        return ResponseEntity.ok().body(postService.findPostById(id));
    }

    @Operation(
            summary = "전체 게시물 조회",
            description = "전체 게시물 조회합니다."
    )
    @ApiResponse(
            responseCode = "200",
            description = "전체 게시물 조회를 성공하였습니다."
    )
    @GetMapping
    public ResponseEntity<?> findAllPost(){
        return ResponseEntity.ok().body(postService.findAllPost());
    }
}
