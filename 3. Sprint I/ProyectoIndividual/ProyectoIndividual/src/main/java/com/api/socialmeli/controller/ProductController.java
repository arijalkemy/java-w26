package com.api.socialmeli.controller;

import com.api.socialmeli.dto.PostDto;
import com.api.socialmeli.dto.PromoPostDto;
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

    // MCaldera - se implementa endpoint de us0010 creacion de post con promocion
    @PostMapping("/products/promo-post")
    public ResponseEntity<?> NewPromoPost(@RequestBody PromoPostDto promoPostDto){
        return new ResponseEntity(this.postService.publishPromoPost(promoPostDto), HttpStatus.OK);
    }

    // MCaldera - Se implementa enpoint de us0011 creacion de get de totalizados de posts
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<?> getPromoPosts(@RequestParam Integer user_id){
        return new ResponseEntity(this.postService.getPromoPosts(user_id), HttpStatus.OK);
    }

    // MCaldera - Se implementa endpoint de us0012 retorno de post en promocion
    @GetMapping("/products/promo-post/list")
    public ResponseEntity<?> getPromoBySeller(@RequestParam Integer user_id){
        return new ResponseEntity(this.postService.getPromoBySeller(user_id), HttpStatus.OK);
    }

}
