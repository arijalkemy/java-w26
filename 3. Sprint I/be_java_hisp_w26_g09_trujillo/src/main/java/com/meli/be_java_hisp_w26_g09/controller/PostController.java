package com.meli.be_java_hisp_w26_g09.controller;

import com.meli.be_java_hisp_w26_g09.dto.PostDTO;
import com.meli.be_java_hisp_w26_g09.service.IPostService;
import com.meli.be_java_hisp_w26_g09.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    IPostService productService;
    @Autowired
    IProductService IproductService;

    @PostMapping("/post")
    public ResponseEntity<?> postCreatePost(@RequestBody PostDTO post) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.addPost(post));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedUsersPostsLastTwoWeeks(@PathVariable Integer userId,
                                                               @RequestParam(required = false) String order) {
        if (order == null || order.isEmpty())
            return ResponseEntity.ok(productService.findFollowedPostsLastTwoWeeks(userId));

        return ResponseEntity.ok(productService.findFollowedPostsLastTwoWeeksSorted(userId,order));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> createPostWithPromo(@RequestBody PostDTO post) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.createPostWithPromo(post));
    }

    @GetMapping("promo-post/count")
    public ResponseEntity<?> getPromoProductsCount(@RequestParam Integer user_id) {
        return ResponseEntity.ok(productService.getPromoProducts(user_id));
    }

    @GetMapping("promo-post/list")
    public ResponseEntity<?> getPromoProductsList(@RequestParam Integer user_id) {
        return ResponseEntity.ok(productService.getAllPromosForId(user_id));
    }
    @GetMapping("/list")
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(IproductService.getAllProducts());
    }
    @GetMapping("/search")
    public ResponseEntity<?> getProductsByName(@RequestParam String name) {
        return ResponseEntity.ok(IproductService.getProductsByName(name));
    }
}