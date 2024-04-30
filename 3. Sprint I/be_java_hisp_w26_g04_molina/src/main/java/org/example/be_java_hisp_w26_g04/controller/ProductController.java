package org.example.be_java_hisp_w26_g04.controller;

import org.example.be_java_hisp_w26_g04.dto.FollowersCountDTO;
import org.example.be_java_hisp_w26_g04.dto.PostRequestDTO;
import org.example.be_java_hisp_w26_g04.dto.PostResponseDTO;
import org.example.be_java_hisp_w26_g04.service.seller.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ISellerService sellerService;

    @PostMapping("/post")
    public ResponseEntity<?> createPost(@RequestBody PostRequestDTO post){
        sellerService.createNewPost(post);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<List<PostResponseDTO>> getPostsFromFollower(
            @PathVariable int userId,
            @RequestParam(required = false, value = "order") String order
    ) {
        return ResponseEntity.ok().body(sellerService.sortGetPostFromFollower(userId, order));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> createPromoPost(@RequestBody PostRequestDTO post){
        sellerService.createNewPost(post);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoCount(@RequestParam("user_id") int userId) {
        return ResponseEntity.ok(sellerService.getPromoCount(userId));
    }
}
