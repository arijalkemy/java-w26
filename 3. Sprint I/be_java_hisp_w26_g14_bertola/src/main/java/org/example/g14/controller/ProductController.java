package org.example.g14.controller;

import org.example.g14.dto.CreatePostDto;
import org.example.g14.dto.PromoPostDto;
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
    public ResponseEntity<Void> addPromoPost(@RequestBody CreatePostDto promoPostDto){
        postService.addPromoPost(promoPostDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<Integer> getPromoProdCountByUserId(@RequestParam("user_id") int userId){
        return new ResponseEntity<>(postService.getPromoProdCountByUserId(userId), HttpStatus.OK);
    }
}
