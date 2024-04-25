package org.example.g14.controller;

import org.example.g14.dto.CountOfPostsWithPromoResponseDto;
import org.example.g14.dto.CreatePostDto;
import org.example.g14.service.IPostService;
import org.example.g14.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IPostService postService;

    @PostMapping("/post")
    public ResponseEntity<Void> createPost(
        @RequestBody CreatePostDto createPostDto
    ) {
        postService.add(createPostDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<List<PostDto>> getPostsFromFollowed(@PathVariable("user_id") int userId,
                                                              @RequestParam(required = false) String order){
        List<PostDto> posts = postService.getPostsFromFollowed(userId, order);
        return ResponseEntity.ok(posts);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<Void> createPostWithPromo(
        @RequestBody CreatePostDto createPostDto
    ) {
        postService.addWithPromo(createPostDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<CountOfPostsWithPromoResponseDto> getCountOfPostsWithPromo(
        @RequestParam int user_id
    ) {
        return new ResponseEntity<>(
            postService.calculateCountOfPostsWithPromo(user_id),
            HttpStatus.OK
        );
    }

    @PutMapping("/post/pause")
    public ResponseEntity<Void> pausePosts(
        @RequestParam int user_id
    ) {
        postService.pausePosts(user_id);
        return ResponseEntity.ok().build();
    }
}
