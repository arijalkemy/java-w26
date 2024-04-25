package com.sprint.socialmeli.controller;

import com.sprint.socialmeli.dto.post.FollowedProductsResponseDTO;
import com.sprint.socialmeli.dto.post.PostDTO;
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

    /**
     * Endpoint US0005
     * @param post DTO of post
     * @return Ok Status
     * Calls postService to create new post
     */
    @PostMapping("/post")
    public ResponseEntity<Void> createPost(@RequestBody PostDTO post){
        this.postService.createPost(post);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * Endpoint US0006
     * @param userId Customer user id
     * @param order Optional query param to order the posts by date (date_asc, date_desc)
     * @return A DTO with the list of the posts of a followed seller in the last two weeks
     * Calls postService to get the list of the posts
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedProductsResponseDTO> getFollowedPosts(@PathVariable Integer userId,
                                                                        @RequestParam(required = false) String order){
        return new ResponseEntity<>(postService.getFollowedProductsList(userId, order), HttpStatus.OK);
    }

}
