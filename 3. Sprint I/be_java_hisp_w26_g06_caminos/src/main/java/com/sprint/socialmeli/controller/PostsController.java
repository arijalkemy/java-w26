package com.sprint.socialmeli.controller;

import com.sprint.socialmeli.dto.post.FollowedProductsResponseDTO;
import com.sprint.socialmeli.dto.post.PostDTO;
import com.sprint.socialmeli.dto.post.PromoPostDTO;
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
     * @return an Integer with the post id
     * Calls postService to create new post
     */
    @PostMapping("/post")
    public ResponseEntity<Integer> createPost(@RequestBody PostDTO post){
        Integer idCreated = this.postService.createPost(post);
        return new ResponseEntity<>(idCreated, HttpStatus.OK);
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


    // US00010
    @PostMapping("/promo-post")
    public ResponseEntity<?> createPromoPost(@RequestBody PromoPostDTO post) {
        postService.createPromoPost(post);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // US00011
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoPostCount(@RequestParam(required = false) Integer user_id) {
        if(user_id == null){
            return new ResponseEntity<>(postService.getAllPromoPostCount(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(postService.getPromoPostCount(user_id), HttpStatus.OK);
        }
    }

    @GetMapping("/promo-post/{user_id}/list")
    public ResponseEntity<?> getPromoPosts(@PathVariable Integer user_id){
        return new ResponseEntity<>(postService.getPromoPosts(user_id), HttpStatus.OK);
    }

}
