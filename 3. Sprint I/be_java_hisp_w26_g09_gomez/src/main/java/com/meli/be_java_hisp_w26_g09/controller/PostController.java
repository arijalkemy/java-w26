package com.meli.be_java_hisp_w26_g09.controller;

import com.meli.be_java_hisp_w26_g09.dto.PostDTO;
import com.meli.be_java_hisp_w26_g09.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    IPostService postService;

    @PostMapping("/post")
    public ResponseEntity<?> postCreatePost(@RequestBody PostDTO post) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.addPost(post));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedUsersPostsLastTwoWeeks(@PathVariable Integer userId,
                                                               @RequestParam(required = false) String order) {
        if (order == null || order.isEmpty())
            return ResponseEntity.ok(postService.findFollowedPostsLastTwoWeeks(userId));

        return ResponseEntity.ok(postService.findFollowedPostsLastTwoWeeksSorted(userId,order));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> createPostWithDiscount(@RequestBody PostDTO postDTO){
        return ResponseEntity.status(HttpStatus.OK).body(postService.addPostWithDiscount(postDTO));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getPostBySellerId(@RequestParam("user_id") int userId){
        return ResponseEntity.ok(postService.getAllPostsBySeller(userId));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoPostsCountBySeller(@RequestParam("user_id") Integer userId){
        return ResponseEntity.ok(postService.getPromoCountBySeller(userId));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<?> getPromoPostsBySellerId(@RequestParam("user_id") Integer userId){
        return ResponseEntity.ok(postService.getAllPromoPostsBySeller(userId));
    }

    @GetMapping("/category/{categoryId}/list")
    public ResponseEntity<?> getPostsByCategory(@PathVariable Integer categoryId){
        return ResponseEntity.ok(postService.getAllPostByCategory(categoryId));
    }

    @GetMapping("/price")
    public ResponseEntity<?> getPostsByPriceRange(@RequestParam("min_price") Double minPrice,
                                                  @RequestParam("max_price") Double maxPrice){
        return ResponseEntity.ok(postService.getAllPostByPriceRange(minPrice, maxPrice));
    }

    @GetMapping("/brand/{brand}/list")
    public ResponseEntity<?> getPostsByProductBrand(@PathVariable String brand){
        return ResponseEntity.ok(postService.getAllPostsByProductBrand(brand));
    }

    @GetMapping("/name/{name}/list")
    public ResponseEntity<?> getPostsByProductName(@PathVariable String name){
        return ResponseEntity.ok(postService.getAllPostByProductName(name));
    }

    @GetMapping("/type/{type}/color/{color}")
    public ResponseEntity<?> getPostsByProductTypeAndColor(@PathVariable String type,
                                                           @PathVariable String color){
        return ResponseEntity.ok(postService.getAllPostByProductTypeAndColor(type, color));
    }
}