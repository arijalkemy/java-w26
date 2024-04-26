package com.javabootcamp.socialmeli.controller;

import com.javabootcamp.socialmeli.dto.LastPostDto;
import com.javabootcamp.socialmeli.enums.OrderType;
import com.javabootcamp.socialmeli.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.dto.PromoPostDto;
import com.javabootcamp.socialmeli.dto.SellerPromoDto;
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

    @PostMapping("/promo-post")
    public ResponseEntity<Void> postPromoPost(@RequestBody PromoPostDto promoPostDto){
        postService.addPostWithPromo(promoPostDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<SellerPromoDto> getAllPromoPostFromSeller(@RequestParam("user_id") Integer userId){
        return ResponseEntity.ok(postService.countPromoPostBySeller(userId));
    }
}
