package com.meli.be_java_hisp_w26_g09.controller;

import com.meli.be_java_hisp_w26_g09.dto.PostDTO;
import com.meli.be_java_hisp_w26_g09.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService productService;

    @PostMapping("/post")
    public ResponseEntity<?> postCreatePost(@RequestBody PostDTO post) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.addNotPromoPost(post));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> postCreatePromoPost(@RequestBody PostDTO post) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.addPromoPost(post));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedUsersPostsLastTwoWeeks(@PathVariable Integer userId,
                                             @RequestParam(required = false) String order) {
        if (order == null || order.isEmpty())
            return ResponseEntity.ok(productService.findFollowedPostsLastTwoWeeks(userId));

        return ResponseEntity.ok(productService.findFollowedPostsLastTwoWeeksSorted(userId,order));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoPostBySeller(@RequestParam Integer userId){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findPromoPostBySeller(userId));
    }

    @GetMapping("get-all-post")
    public ResponseEntity<?> getAllPost(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAllPost());
    }

    @DeleteMapping("delete-post")
    public ResponseEntity<?> deletePostById(@RequestParam Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.deletePost(id));
    }
}
