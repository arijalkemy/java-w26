package org.example.g14.controller;

import org.example.g14.dto.CreatePostDto;
import org.example.g14.dto.UserWithPostPromoCount;
import org.example.g14.service.IPostService;
import org.example.g14.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IPostService postService;

    @PostMapping("/post")
    public ResponseEntity<Void> createPost(
        @RequestBody CreatePostDto createPostDto
    ) {
        postService.add(createPostDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<List<PostDto>> getPostsFromFollowed(@PathVariable("user_id") int userId,
                                                              @RequestParam(required = false) String order){
        List<PostDto> posts = postService.getPostsFromFollowed(userId, order);
        return ResponseEntity.ok(posts);
    }

    //10
    @PostMapping("/promo-post")
    public ResponseEntity<Void> createPostPromo(@RequestBody CreatePostDto createPostDto){
        postService.addWithPromo(createPostDto);
        return ResponseEntity.ok().build();
    }

    //11
    @GetMapping("/promo-post")
    public ResponseEntity<UserWithPostPromoCount> getCountOfPromo(@RequestParam("user_id") int userId){
        return new ResponseEntity<>(postService.getCountOfPromo(userId), HttpStatus.OK);
    }

    //12
    @PutMapping("/{user_id}/promo-put/{post_id}")
    public ResponseEntity<?> modifyPostToPromo(@PathVariable("user_id") int userId,
                                               @PathVariable("post_id") int postId){
        return new ResponseEntity<>(postService.putToPromo(userId, postId), HttpStatus.OK);
    }

}
