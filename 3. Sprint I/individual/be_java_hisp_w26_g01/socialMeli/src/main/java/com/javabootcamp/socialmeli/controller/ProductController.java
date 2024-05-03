package com.javabootcamp.socialmeli.controller;

import com.javabootcamp.socialmeli.dto.LastPostDto;
import com.javabootcamp.socialmeli.dto.PostWithPromoDto;
import com.javabootcamp.socialmeli.enums.OrderType;
import com.javabootcamp.socialmeli.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.service.PostService;

import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final PostService postService;



    @PostMapping("/post")
    public ResponseEntity<Void> postPost(@RequestBody PostDto post) {
        postService.addPost(post);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<LastPostDto> getPostFromLastTwoWeeks(@PathVariable("userId") int userId, @RequestParam(required = false) OrderType order) {

        LastPostDto response;
        if (!Objects.isNull(order)) {
            response = productService.getPostFromLastTwooWeeksOrder(userId, order);
        } else {
            response = productService.getPostFromLastTwoWeeks(userId);
        }
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<?> getPromosBySellerId(@RequestParam("user_id") int userId) {
        return new ResponseEntity<>(postService.findPromosBySellerId(userId), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<Void> postPostWithPromo(@RequestBody PostWithPromoDto post){
        postService.addPostWithPromo(post);
        return ResponseEntity.ok().build();
    }

    @GetMapping("promo-post/count")
    public ResponseEntity<?> getQuantityOfPostWithPromoBySeller(@RequestParam("user_id") int userId) {
        return new ResponseEntity<>(postService.countPostWithPromoBySeller(userId), HttpStatus.OK);
    }

}
