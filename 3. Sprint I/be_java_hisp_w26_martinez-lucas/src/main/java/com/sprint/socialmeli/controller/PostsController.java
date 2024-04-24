package com.sprint.socialmeli.controller;

import com.sprint.socialmeli.dto.post.PostDTO;
import com.sprint.socialmeli.dto.post.PostPromoCountResponseDTO;
import com.sprint.socialmeli.dto.post.PostPromoListResponseDTO;
import com.sprint.socialmeli.dto.post.PostPromoRequestDTO;
import com.sprint.socialmeli.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostsController {

    @Autowired
    IPostService postService;

    // US0005.
    @PostMapping("/post")
    public ResponseEntity<?> createPost(@RequestBody PostDTO post){
        this.postService.createPost(post);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // US0006.
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedPosts(@PathVariable Integer userId,
                                              @RequestParam(required = false) String order){
        return new ResponseEntity<>(postService.getFollowedProductsList(userId, order), HttpStatus.OK);
    }

    // US00010. INDIVIDUAL Martinez Lucas
    @PostMapping("promo-post")
    public ResponseEntity<?> createPromoPost(@RequestBody PostPromoRequestDTO promoRequestDTO){
        postService.createPromoPost(promoRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // US00011. INDIVIDUAL Martinez Lucas
    @GetMapping("promo-post/count")
    public ResponseEntity<PostPromoCountResponseDTO> getPromoPostBySeller(@RequestParam int user_id){
        PostPromoCountResponseDTO postPromoCount = postService.getPostPromoCount(user_id);
        return new ResponseEntity<>(postPromoCount, HttpStatus.OK);
    }

    // US00012. INDIVIDUAL Martinez Lucas
    @GetMapping("/promo-post/list")
    public ResponseEntity<PostPromoListResponseDTO> getPromoPostListBySeller(@RequestParam int user_id){
        PostPromoListResponseDTO postPromoList = postService.getPostPromoList(user_id);
        return new ResponseEntity<>(postPromoList, HttpStatus.OK);
    }


}
