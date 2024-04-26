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
        return ResponseEntity.status(HttpStatus.OK)
                .body(postService.addPost(post));
    }

    @PutMapping("/post/{post_id}")
    public ResponseEntity<?> postCreatePost(@PathVariable Integer post_id,
                                            @RequestBody PostDTO post) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(postService.updatePost(post_id, post));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> postCreatePromoPost(@RequestBody PostDTO post) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(postService.addPromoPost(post));
    }

    @GetMapping("promo-post/count")
    public ResponseEntity<?> getPromoPostCountBySeller(@RequestParam Integer user_id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(postService.findPromoPostCountBySeller(user_id));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedUsersPostsLastTwoWeeks(@PathVariable Integer userId,
                                             @RequestParam(required = false) String order) {
        if (order == null || order.isEmpty())
            return ResponseEntity.ok(postService.findFollowedPostsLastTwoWeeks(userId));

        return ResponseEntity.ok(postService.findFollowedPostsLastTwoWeeksSorted(userId,order));
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<?> getPostById(@PathVariable Integer postId){
        return ResponseEntity.status(HttpStatus.OK).body(postService.findPostById(postId));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<?> getListPromoPromoPostBySeller(@RequestParam Integer user_id){
        return ResponseEntity.status(HttpStatus.OK).body(postService.findPromoPostBySeller(user_id));
    }

    @PutMapping("/post/{postId}/to-promo-post")
    public ResponseEntity<?> putUpdatePostToPromoPost(@PathVariable Integer postId, @RequestBody PostDTO post){
        return ResponseEntity.status(HttpStatus.OK).body(postService.updatePostToPromoPost(postId,post));
    }
}
