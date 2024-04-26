package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.controller;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PostDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PostPromoDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.IUserRepository;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service.IPostService;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService productService;
    @Autowired
    IPostService postService;

    @Autowired
    IUserRepository userRepository;

    @PostMapping ("/post")
    public ResponseEntity<?> createPost(@RequestBody PostDTO postDto){
        return new ResponseEntity<>(postService.create(postDto), HttpStatus.OK);
    }

    //us-0006
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?>followedVendorsLastPosts(@PathVariable int userId, @RequestParam(required = false)String order){
        return new ResponseEntity<>(productService.getPostByFollowedUsers(userId, order), HttpStatus.OK);
    }

    @GetMapping("/test")
    public  ResponseEntity<?> test(){
        return new ResponseEntity<>(userRepository.getAll(), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> createPromoPost(@RequestBody PostPromoDTO postPromoDTO){
        return new ResponseEntity<>(postService.createPromoPost(postPromoDTO), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoPostCount(@RequestParam("user_id") int userId){
        return new ResponseEntity<>(postService.getPromoPostCount(userId), HttpStatus.OK);
    }
    @GetMapping("/post/{userId}/list")
    public ResponseEntity<?> getPostByUser(@PathVariable int userId, @RequestParam(required = false) String month, @RequestParam(required = false) String year){
        return new ResponseEntity<>(postService.getPostByUser(userId, month, year), HttpStatus.OK);
    }

}
