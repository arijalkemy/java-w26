package com.javabootcamp.socialmeli.controller;

import com.javabootcamp.socialmeli.dto.response.LastPostDto;
import com.javabootcamp.socialmeli.enums.OrderType;
import com.javabootcamp.socialmeli.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javabootcamp.socialmeli.dto.request.PostDto;
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
    public ResponseEntity<Void> postPost(@RequestBody @Valid PostDto post){
        postService.addPost(post);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<LastPostDto> getPostFromLastTwoWeeks(
            @PathVariable("userId")
            @Positive(message = "El id debe ser mayor a cero.") int userId,
            @RequestParam(required = false) OrderType order){

        LastPostDto response;
        if(!Objects.isNull(order)){
            response = productService.getPostFromLastTwooWeeksOrder(userId, order);
        }
        else{
            response = productService.getPostFromLastTwoWeeks(userId);
        }
        return ResponseEntity.status(200).body(response);
    }



}
