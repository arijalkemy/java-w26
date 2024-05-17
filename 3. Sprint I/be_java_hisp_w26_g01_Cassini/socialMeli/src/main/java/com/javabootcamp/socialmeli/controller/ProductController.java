package com.javabootcamp.socialmeli.controller;

import com.javabootcamp.socialmeli.dto.*;
import com.javabootcamp.socialmeli.enums.OrderType;
import com.javabootcamp.socialmeli.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javabootcamp.socialmeli.service.PostService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity<Void> postPost(@RequestBody PostDto post){
        postService.addPost(post);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/post-list")
    public ResponseEntity<Void> addPostList(@RequestBody List<PostDto> postList){
        postService.addPostList(postList);
        return ResponseEntity.ok().build();
    }
    /**
     * Este método aplica descuento a todas las publicaciones de un vendedor
     *
     */

    @PutMapping("/add-promo")
    public ResponseEntity<Void> modifyPromoPost(@RequestBody ProductsPromoDto productsPromoDto){
        productService.modifyPromoPost(productsPromoDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/promo-post")
    public ResponseEntity<Void> postPostPromo(@RequestBody PostPromoDto post){
        postService.addPostPromo(post);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<LastPostDto> getPostFromLastTwoWeeks(@PathVariable("userId") int userId, @RequestParam(required = false) OrderType order){

        LastPostDto response;
        if(!Objects.isNull(order)){
            response = productService.getPostFromLastTwooWeeksOrder(userId, order);
        }
        else{
            response = productService.getPostFromLastTwoWeeks(userId);
        }
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PostPromoRespDto> getQuantityProductsPromo(@RequestParam("user_id") Integer userId){
        return ResponseEntity.ok(productService.getQuantityProductsPromo(userId));
    }



}
