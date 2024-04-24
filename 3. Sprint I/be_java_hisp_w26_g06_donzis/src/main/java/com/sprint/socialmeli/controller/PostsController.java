package com.sprint.socialmeli.controller;

import com.sprint.socialmeli.dto.post.PostDTO;
import com.sprint.socialmeli.dto.post.PromoPostRequestDTO;
import com.sprint.socialmeli.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostsController {

    @Autowired
    IPostService postService;

    // US0005.
    @PostMapping("/post")
    public ResponseEntity<?> createPost(@RequestBody PostDTO post){
        this.postService.createPost(post);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // US0006.
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedPosts(@PathVariable Integer userId,
                                              @RequestParam(required = false) String order) {
        return new ResponseEntity<>(postService.getFollowedProductsList(userId, order), HttpStatus.OK);
    }

    //US0010
    @PostMapping("/promo-post")
    public ResponseEntity<?> createPromoPost(@RequestBody PromoPostRequestDTO post){
        postService.createPromoPost(post);
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }

    //US0011
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoPostCount(@RequestParam Integer user_id){
        return ResponseEntity.ok(postService.getPromoPostsBySeller(user_id));
    }
}
