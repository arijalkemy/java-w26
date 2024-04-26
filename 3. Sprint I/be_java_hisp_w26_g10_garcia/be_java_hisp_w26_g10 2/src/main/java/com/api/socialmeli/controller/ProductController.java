package com.api.socialmeli.controller;

import com.api.socialmeli.dto.CompletePostDto;
import com.api.socialmeli.dto.PostDto;
import com.api.socialmeli.service.IPostService;
import com.api.socialmeli.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    // MCaldera - Se inyecta el servio correspondiente a la creacion de posts
    @Autowired
    private IPostService postService;

    @Autowired
    private ISellerService iSellerService;

    // MCaldera - Endpoint correspondiente a creacion de posts
    @PostMapping("/post")
    public ResponseEntity<?> NewPost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(this.postService.publishPost(postDto), HttpStatus.OK);
    }

    /*
    US 0006 and US009: Se agrega la función en el controlador para direccionar el endpoint 6 y 9 de la API
    */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getPostsByFollowed(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(postService.getPostsByFollowed(userId, order));
    }

    /*
    US 0011: Se agrega la función en el controlador para devolver el vendedor y las publicaciones
             con productos en promocion
    */
    @GetMapping("/promo-post/list")
    public ResponseEntity<?> getPostsDiscountBySeller(@RequestParam Integer user_id){
        return ResponseEntity.status(HttpStatus.OK).body(iSellerService.getDiscountProductsBySeller(user_id));
    }

    /*
    US 0011: Se agrega la función en el controlador para devolver el vendedor y la cuenta de sus publicaciones
             con productos en promocion
    */
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getCountPostsDiscountBySeller(@RequestParam Integer user_id){
        return ResponseEntity.status(HttpStatus.OK).body(iSellerService.getCountDiscountProductsBySeller(user_id));
    }

    /*
    US 0010: Se agrega la función en el controlador para crear una publicacion con el producto en promocion
    */
    @PostMapping("/promo-post")
    public ResponseEntity<?> NewPromoPost(@RequestBody CompletePostDto postDto){
        postService.publishComplete(postDto);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
