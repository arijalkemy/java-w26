package com.api.socialmeli.controller;

import com.api.socialmeli.dto.PostDto;
import com.api.socialmeli.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    // MCaldera - Se inyecta el servio correspondiente a la creacion de posts
    @Autowired
    IPostService postService;

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

}
