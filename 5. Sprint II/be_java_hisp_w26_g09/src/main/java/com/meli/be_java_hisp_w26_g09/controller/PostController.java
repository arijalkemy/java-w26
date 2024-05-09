package com.meli.be_java_hisp_w26_g09.controller;

import com.meli.be_java_hisp_w26_g09.dto.PostDTO;
import com.meli.be_java_hisp_w26_g09.service.IPostService;
import jakarta.validation.Valid;
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
    public ResponseEntity<?> postCreatePost(@Valid @RequestBody PostDTO post) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.addPost(post));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedUsersPostsLastTwoWeeks(@PathVariable Integer userId,
                                             @RequestParam(required = false) String order) {
        if (order == null || order.isEmpty())
            return ResponseEntity.ok(postService.findFollowedPostsLastTwoWeeks(userId));

        return ResponseEntity.ok(postService.findFollowedPostsLastTwoWeeksSorted(userId,order));
    }
}
