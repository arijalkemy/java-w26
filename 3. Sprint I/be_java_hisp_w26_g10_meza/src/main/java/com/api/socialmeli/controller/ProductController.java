package com.api.socialmeli.controller;

import com.api.socialmeli.dto.PostDto;
import com.api.socialmeli.dto.PostWithPromoDto;
import com.api.socialmeli.entity.Post;
import com.api.socialmeli.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    // MCaldera - Se inyecta el servio correspondiente a la creacion de posts
    @Autowired
    IPostService postService;

    // MCaldera - Endpoint correspondiente a creacion de posts
    @PostMapping("/products/post")
    public ResponseEntity<?> NewPost(@RequestBody PostDto postDto){
        return new ResponseEntity(this.postService.publishPost(postDto), HttpStatus.OK);
    }

    @PostMapping("/products/promo-post")
    public ResponseEntity<?> promoPostPublication(@RequestBody PostWithPromoDto post){
        postService.postPromo(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<?> countPromotionProducts(@RequestParam(name = "user") Integer user){
        return new ResponseEntity<>(postService.getCountPromotionProducts(user), HttpStatus.OK);
    }
}
