package org.example.social_meli.controller;

import org.example.social_meli.dto.PostDTO;
import org.example.social_meli.dto.PromoPostDTO;
import org.example.social_meli.services.IProductService;
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
    public ResponseEntity<?> postProductPost(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(productService.savePost(postDTO), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getSellersPostsFollowedByUser(@PathVariable Integer userId) {
        return new ResponseEntity<>(productService.getSellersPostsFollowedByUser(userId), HttpStatus.OK);
    }

    @GetMapping(value = "/followed/{userId}/list", params = "order")
    public ResponseEntity<?> getOrderedSellersPostsFollowedByUser(@PathVariable Integer userId, @RequestParam String order) {
        return new ResponseEntity<>(productService.getOrderedSellersPostsFollowedByUser(userId, order), HttpStatus.OK);
    }
    @PostMapping("/promo-post")
    public ResponseEntity<?> postPromoProductPost(@RequestBody PromoPostDTO promoPostDTO){
        return new ResponseEntity<>(productService.savePromoPost(promoPostDTO),HttpStatus.OK);
    }
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoPostCountById(@RequestParam Integer user_id){
        return new ResponseEntity<>(productService.getPromoPostCountByUser(user_id), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<?> getPromoPostsByUser(@RequestParam Integer user_id){
        return new ResponseEntity<>(productService.getPromoPostByUser(user_id),HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/promo-post")
    public ResponseEntity<?> getFollowedPromoPostsByUser(@PathVariable Integer userId){
        return new ResponseEntity<>(productService.getFollowedPromoPostByUser(userId), HttpStatus.OK);
    }
}
