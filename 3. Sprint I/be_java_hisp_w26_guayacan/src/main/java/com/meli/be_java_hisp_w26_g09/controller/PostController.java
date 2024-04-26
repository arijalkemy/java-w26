package com.meli.be_java_hisp_w26_g09.controller;

import com.meli.be_java_hisp_w26_g09.dto.PostDTO;
import com.meli.be_java_hisp_w26_g09.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    IPostService postService;

    @PostMapping("/post")
    public ResponseEntity<?> postCreatePost(@RequestBody PostDTO post) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.addPost(post));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedUsersPostsLastTwoWeeks(@PathVariable Integer userId,
                                                               @RequestParam(required = false) String order) {
        if (order == null || order.isEmpty())
            return ResponseEntity.ok(postService.findFollowedPostsLastTwoWeeks(userId));

        return ResponseEntity.ok(postService.findFollowedPostsLastTwoWeeksSorted(userId, order));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> postCreateProductInPromoPost(@RequestBody PostDTO post) {
        return ResponseEntity.ok().body(postService.addProductInPromoPost(post));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getAmountOfProductsInPromoBySeller(@RequestParam Integer user_id) {
        return ResponseEntity.ok().body(postService.countProductsInPromoBySeller(user_id));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<?> getProductsInPromoBySeller(@RequestParam Integer user_id) {
        return ResponseEntity.ok().body(postService.findProductsInPromoBySeller(user_id));
    }

}
