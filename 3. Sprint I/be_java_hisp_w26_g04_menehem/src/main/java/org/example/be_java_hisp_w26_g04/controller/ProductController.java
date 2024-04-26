package org.example.be_java_hisp_w26_g04.controller;

import org.example.be_java_hisp_w26_g04.dto.PostRequestDTO;
import org.example.be_java_hisp_w26_g04.dto.PostResponseDTO;
import org.example.be_java_hisp_w26_g04.dto.PromosCountDTO;
import org.example.be_java_hisp_w26_g04.service.seller.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.GenericDeclaration;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ISellerService sellerService;

    @PostMapping({"/post", "/promo-post"})
    public ResponseEntity<?> createPost(@RequestBody PostRequestDTO post) {
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

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromosCountDTO> getPromosCount(@RequestParam(name = "user_id") int userId) {
        return ResponseEntity.ok(sellerService.findPromos(userId));
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostResponseDTO>> getAllPosts(@RequestParam(required = false, name = "user_id") Integer userId,
                                                             @RequestParam(required = false, name = "has_promo") Boolean hasPromo) {

        return ResponseEntity.ok(sellerService.findAllPosts(userId, hasPromo));
    }

}
