package com.sprint.socialmeli.controller;

import com.sprint.socialmeli.dto.post.*;
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

    /**
     * Endpoint US0010 - Individual
     * @param post PromoPostRequestDTO
     * @return @return an Integer with the post id
     * Calls postService to create new promo post
     */
    @PostMapping("promo-post")
    public ResponseEntity<Integer> createPromoPost(@RequestBody PromoPostRequestDTO post){
        Integer idCreated = this.postService.createPromoPost(post);
        return new ResponseEntity<>(idCreated, HttpStatus.OK);
    }

    /**
     * Endpoint US0011 - Individual
     * @param user_id Seller id
     * @return A DTO with the count of discount posts of a followed seller
     * Calls postService to get the count of the list
     */
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoCountResponseDTO> getPromoPostListCount(
            @RequestParam(required = true) Integer user_id
    ){
        return new ResponseEntity<>(this.postService.getPromoCountBySellerId(user_id), HttpStatus.OK);
    }

    /**
     * Endpoint US0012 - Bonus
     * @param user_id Seller id
     * @return A DTO with the list of discount posts of a followed seller
     * Calls postService to get the list
     */
    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoListResponseDTO> getPromoPostList(
            @RequestParam(required = true) Integer user_id
    ){
        return new ResponseEntity<>(this.postService.getPromoPostListBySellerId(user_id), HttpStatus.OK);
    }

}
