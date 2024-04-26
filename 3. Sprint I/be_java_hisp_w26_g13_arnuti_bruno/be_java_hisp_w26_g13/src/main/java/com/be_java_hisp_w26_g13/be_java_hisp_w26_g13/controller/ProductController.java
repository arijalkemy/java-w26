package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.controller;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PostDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PromoPostCountDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PromoPostDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.IUserRepository;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service.IPostService;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping ("/promo-post")
    public ResponseEntity<?> createPromoPost(@RequestBody PromoPostDTO promoPostDto){
        return new ResponseEntity<>(postService.createPromo(promoPostDto), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDTO> getPromoProductCount(@RequestParam("user_id") int userId) {
        return new ResponseEntity<>(postService.getPromoProductCount(userId), HttpStatus.OK);
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

    @GetMapping("/promo/desc-by-discount")
    public ResponseEntity<List<PostDTO>> getAllPromoPostsSortedByDiscountDesc() {
        return new ResponseEntity<>(postService.getAllPromoPostsSortedByDiscountDesc(), HttpStatus.OK);
    }

    @PutMapping("/promo/{postId}/set-discount")
    public ResponseEntity<?> setDiscountToNonPromoPost(@PathVariable Integer postId, @RequestParam double discount) {
        return new ResponseEntity<>(postService.setDiscountToPost(postId, discount), HttpStatus.OK);
    }

    @PutMapping("/promo/{postId}/remove-discount")
    public ResponseEntity<?> removeDiscountToNonPromoPost(@PathVariable Integer postId) {
        return new ResponseEntity<>(postService.removeDiscountToPost(postId), HttpStatus.OK);
    }


}
