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

    @PostMapping("/post/promo-post")
    public ResponseEntity<?> postPromoProductPost(@RequestBody PromoPostDTO promoPostDTO) {
        return new ResponseEntity<>(productService.savePromoPost(promoPostDTO), HttpStatus.OK);
    }

    @GetMapping(value = "post/promo-post/count", params = "user_id")
    public ResponseEntity<?> countPromoPostBySeller(@RequestParam("user_id") Integer userId){
        return new ResponseEntity<>(productService.countPromoPostBySeller(userId), HttpStatus.OK);
    }

    @GetMapping(value="post/promo-post/list", params = "user_id")
    public ResponseEntity<?> getPromoPostsBySeller(@RequestParam("user_id") Integer userId){
        return new ResponseEntity<>(productService.getPromoPostsBySeller(userId), HttpStatus.OK);
    }

    @GetMapping(value="post/promo-post/{userId}list", params = "order")
    public ResponseEntity<?> getOrderedPromoPostsBySeller(@PathVariable Integer userId, @RequestParam("order") String order){
        return new ResponseEntity<>(productService.getOrderedPromoPostsBySeller(userId,order), HttpStatus.OK);
    }


    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getSellersPostsFollowedByUser(@PathVariable Integer userId) {
        return new ResponseEntity<>(productService.getSellersPostsFollowedByUser(userId), HttpStatus.OK);
    }

    @GetMapping(value = "/followed/{userId}/list", params = "order")
    public ResponseEntity<?> getOrderedSellersPostsFollowedByUser(@PathVariable Integer userId, @RequestParam String order) {
        return new ResponseEntity<>(productService.getOrderedSellersPostsFollowedByUser(userId, order), HttpStatus.OK);
    }
}
