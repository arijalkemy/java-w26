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
     * Endpoint US0010
     * @param promo DTO of Promo
     * @return an Integer with the promo id
     * Calls postService to create a new promo and a new post
     */
    @PostMapping("/promo-post")
    public ResponseEntity<Integer> createPromoPost(@RequestBody PromoDTO promo){
        Integer promoId = this.postService.createPromo(promo);
        return new ResponseEntity<>(promoId, HttpStatus.OK);
    }

    /**
     * Endpoint US0011
     * @param user_id Seller user id
     * @return A DTO with Seller id and userName and the count of his products with a promo
     * Calls postService to get the count of promos
     */
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountResponseDTO> getPromoPostCount(@RequestParam Integer user_id){
        return new ResponseEntity<>(postService.getPromoPostCount(user_id), HttpStatus.OK);
    }

    /**
     * Endpoint US0012
     * @param user_id Seller user id
     * @return A DTO with Seller id and userName and the list of his products with a promo
     * Calls postService to get the list of promos
     */
    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPostListResponseDTO> getPromoPostList(@RequestParam Integer user_id){
        return new ResponseEntity<>(postService.getPromoPostList(user_id), HttpStatus.OK);
    }

}
