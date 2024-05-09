package com.example.sprint1.controller;

import com.example.sprint1.dto.PostDto;
import com.example.sprint1.service.IPostService;
import com.example.sprint1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    IPostService postService;

    /**
     * US 0005 Create a new Post
     * @param postDto - The DTO containing the necessary information for creating a new post.
     * @return ResponseEntity  - Returns a ResponseEntity object. If the post is successfully created,
     *                         * it returns the post's details with an HTTP 200 OK status. If an error occurs,
     *                         * it returns an error message with an HTTP 400 Bad Request status.
     */
    @PostMapping("/post")
    public ResponseEntity<?> addPost(@RequestBody @Valid PostDto postDto) {
        PostDto response = postService.addPost(postDto);
        return ResponseEntity.ok(response);
    }

    /**
     * US 0006 US 0009
     * Obtain a list of the publications made by the sellers that a user follows in the last two weeks
     * Sort by ascending and descending date
     * @param userId
     * @param order
     * @return
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> followedList (@PathVariable Integer
                                                   userId, @RequestParam(value = "order", required = false) String order){
        return new ResponseEntity<>(postService.selectIfOrderFollowedList(userId,order), HttpStatus.OK);
    }

        /**
         * US 0010
         * Carry out the publication of a new promotional product
         * @param postDto
         * @return
         */
        @PostMapping("/promo-post")
        public ResponseEntity<?> postPromo (@RequestBody @Valid PostDto postDto){
            return new ResponseEntity<>(postService.postPromo(postDto), HttpStatus.CREATED);
        }

        /**
         * US 0011
         * Obtain the number of products on promotion from a certain seller
         * @param user_id
         * @return
         */
        @GetMapping("/promo-post/count")
        public ResponseEntity<?> quantityPromo (@RequestParam Integer user_id){
            return new ResponseEntity<>(postService.quantityPromo(user_id), HttpStatus.OK);
        }


        /**
         * US 0012
         * Obtain a list of all the products on promotion from a certain seller
         * @param user_id
         * @return
         */
        @GetMapping("/promo-post/list")
        public ResponseEntity<?> getPromo (@RequestParam Integer user_id){
            return new ResponseEntity<>(postService.getPromo(user_id), HttpStatus.OK);
        }

    /**
     * Obtain a list of all posts
     * @return
     */
    @GetMapping("/posts")
        public ResponseEntity<?> getAllPosts(){
            return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
        }
    }
