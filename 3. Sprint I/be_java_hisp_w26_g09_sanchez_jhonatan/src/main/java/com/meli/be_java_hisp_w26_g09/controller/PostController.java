package com.meli.be_java_hisp_w26_g09.controller;

import com.meli.be_java_hisp_w26_g09.dto.PostDTO;
import com.meli.be_java_hisp_w26_g09.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    IPostService productService;

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
    public ResponseEntity<?> savePromoPost(@RequestBody PostDTO postDTO){
        return ResponseEntity.ok().body(productService.savePromoPost(postDTO));
    }

    @GetMapping("/post/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(productService.getAll());
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getCountPromoPostByUserID(@RequestParam Integer user_id){
        return ResponseEntity.ok().body(productService.getCountPromoPostById(user_id));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<?> getListPromPostByUserID(@RequestParam Integer user_id){
        return ResponseEntity.ok().body(productService.getListPromoPostById(user_id));
    }
}
