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


    // US00010. INDIVIDUAL

    /***
     *
     * @param promoRequestDTO dto with the promo post data
     * @return a dto with the id of the post promo created
     */
    @PostMapping("promo-post")
    public ResponseEntity<PostPromoCreatedDto> createPromoPost(@RequestBody PostPromoRequestDTO promoRequestDTO){

        Integer idCreated = postService.createPromoPost(promoRequestDTO);

        return new ResponseEntity<>(new PostPromoCreatedDto(idCreated), HttpStatus.CREATED);

    }

    // US00011. INDIVIDUAL
    /***
     *
     * @param user_id the seller id
     * @return a Dto with the count of promo post which a seller has published
     */
    @GetMapping("promo-post/count")
    public ResponseEntity<PostPromoCountResponseDTO> getPromoPostBySeller(@RequestParam int user_id){

        PostPromoCountResponseDTO postPromoCount = postService.getPostPromoCount(user_id);

        return new ResponseEntity<>(postPromoCount, HttpStatus.OK);

    }

    // US00012. INDIVIDUAL

    /***
     *
     * @param user_id the seller id
     * @return a Dto with the list of promo post which a seller has published
     */
    @GetMapping("/promo-post/list")
    public ResponseEntity<PostPromoListResponseDTO> getPromoPostListBySeller(@RequestParam int user_id){

        PostPromoListResponseDTO postPromoList = postService.getPostPromoList(user_id);

        return new ResponseEntity<>(postPromoList, HttpStatus.OK);

    }

}
