package org.mercadolibre.NotNullTeam.controller;

import lombok.RequiredArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.PostWithPromoDTO;
import org.mercadolibre.NotNullTeam.DTO.response.PostCreatedDto;
import org.mercadolibre.NotNullTeam.service.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class PostController {
    final IPostService iPostService;

    @PostMapping("/post")
    public ResponseEntity<?> createPost(@RequestBody PostDTO postDTO) {
        Long postId = iPostService.createPost(postDTO);
        return new ResponseEntity<>(
                new PostCreatedDto(postId, "Post created successfully", LocalDate.now()), HttpStatus.CREATED);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getPostsByWeeksAgo(@PathVariable Long userId,
                                                @RequestParam(required = false, defaultValue = "date_desc") String order){
        return ResponseEntity.ok(iPostService.getPostsByWeeksAgo(userId, order));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> createPostWithPromo(@RequestBody PostWithPromoDTO postWithPromoDTO) {
        Long postId = iPostService.createPostWithPromo(postWithPromoDTO);
        return new ResponseEntity<>(
                new PostCreatedDto(postId, "Post with promo created successfully", LocalDate.now()), HttpStatus.CREATED);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getCantPromosSellersByUserId(@RequestParam(required = true)
                                                          Long user_id){
        return ResponseEntity.ok(iPostService.getCantPromosSellersByUserId(user_id));
    }

    @GetMapping("/promo-posts-week/list")
    public ResponseEntity<?> getTopWeekPromosByUserId(@RequestParam(required = true)
                                                        Long user_id){
        return ResponseEntity.ok(iPostService.getTopWeekPromosByUserId(user_id));
    }

    @GetMapping("/followed/{buyerId}/category/{numberCategory}/list")
    public ResponseEntity<?> getProductsOfMyFollowedByCategory(@PathVariable Long buyerId,
                                                               @PathVariable int numberCategory,
                                                               @RequestParam(required = false, defaultValue = "price_asc")
                                                                   String order){
        return ResponseEntity.ok(iPostService.getProductsOfMyFollowedByCategory(buyerId, numberCategory, order));
    }

    @GetMapping("/followed/{buyerId}/searchProduct/{productName}/results")
    public ResponseEntity<?> getSellerPostByProductName(@PathVariable Long buyerId,
                                                        @PathVariable String productName,
                                                        @RequestParam(required = false, defaultValue = "price_asc")
                                                        String order){
        return ResponseEntity.ok(iPostService.getSellerPostByProductName(buyerId, productName, order));
    }

    @DeleteMapping("/delete/{sellerId}/post/{postId}")
    public ResponseEntity<?> deleteSellerPostByPostId(@PathVariable Long sellerId,
                                                               @PathVariable Long postId){
        iPostService.deleteSellerPostByPostId(sellerId, postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
