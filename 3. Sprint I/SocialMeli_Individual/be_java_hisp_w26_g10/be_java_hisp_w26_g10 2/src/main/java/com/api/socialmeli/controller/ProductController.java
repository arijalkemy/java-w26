package com.api.socialmeli.controller;

import com.api.socialmeli.dto.PostDto;
import com.api.socialmeli.dto.PromoPostDto;
import com.api.socialmeli.entity.Post;
import com.api.socialmeli.service.IPostService;
import com.api.socialmeli.service.ISellerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    // MCaldera - Se inyecta el servio correspondiente a la creacion de posts
    @Autowired
    IPostService postService;
    @Autowired
    ISellerService sellerService;

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts(){
        return new ResponseEntity<List<Post>>(postService.getAll(), HttpStatus.OK);
    }

    // MCaldera - Endpoint correspondiente a creacion de posts
    @PostMapping("/post")
    public ResponseEntity<?> NewPost(@RequestBody PostDto postDto){
        return new ResponseEntity(this.postService.publishPost(postDto), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PromoPostDto> newPromoPost(@RequestBody PromoPostDto promoPostDto){
        return new ResponseEntity<PromoPostDto>(postService.publishPromoPost(promoPostDto), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count/user/{userId}")
    public ResponseEntity<?> getAllPromoPostByUser(@PathVariable Integer userId){
        return new ResponseEntity<>(sellerService.getPromoProductBySeller(userId), HttpStatus.OK);
    }
}
