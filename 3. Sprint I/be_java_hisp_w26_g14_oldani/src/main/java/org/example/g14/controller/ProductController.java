package org.example.g14.controller;

import org.example.g14.dto.CreatePostDto;
import org.example.g14.dto.ProductDto;
import org.example.g14.dto.PromotionProductCountDto;
import org.example.g14.service.IPostService;
import org.example.g14.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Void> createPromoPost(
            @RequestBody CreatePostDto createPostDto
    ) {
        postService.add(createPostDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromotionProductCountDto> getPromotionalProducts(@RequestParam int user_id){
        PromotionProductCountDto post = postService.getPromotionalProducts(user_id);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/by-tag")
    public ResponseEntity<List<ProductDto>> getProductsFromTag(@RequestParam(required = false) String tag){
        return ResponseEntity.ok(postService.getProductsFromTag(tag));
    }
}
