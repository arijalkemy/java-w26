package com.meli.be_java_hisp_w26_g09.controller;
import com.meli.be_java_hisp_w26_g09.dto.CountPromosBySellerDTO;
import com.meli.be_java_hisp_w26_g09.dto.PromosBySellerDTO;
import com.meli.be_java_hisp_w26_g09.dto.ResponseDTO;
import com.meli.be_java_hisp_w26_g09.validation.PostPromoValidator;
import org.springframework.validation.annotation.Validated;

import com.meli.be_java_hisp_w26_g09.dto.PostDTO;
import com.meli.be_java_hisp_w26_g09.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/products")
@Validated
public class PostController {
    @Autowired
    IPostService productService;

    final PostPromoValidator postDTOValidator;

    public PostController(PostPromoValidator postDTOValidator) {
        this.postDTOValidator = postDTOValidator;
    }

    @PostMapping("/post")
    public ResponseEntity<?> postCreatePost(@RequestBody PostDTO post) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.addPost(post));
    }

    @PostMapping("/promo-post")
    public  ResponseEntity<?> postCreatePostPromo(@Validated @RequestBody PostDTO post, BindingResult validationResult)
    {
        postDTOValidator.validate(post, validationResult);
        if (validationResult.hasErrors())
            return ResponseEntity.badRequest().body(validationResult.getAllErrors());

        ResponseDTO response = productService.addPostPromo(post);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedUsersPostsLastTwoWeeks(@PathVariable Integer userId,
                                             @RequestParam(required = false) String order) {
        if (order == null || order.isEmpty())
            return ResponseEntity.ok(productService.findFollowedPostsLastTwoWeeks(userId));

        return ResponseEntity.ok(productService.findFollowedPostsLastTwoWeeksSorted(userId,order));
    }

    @GetMapping("promo-post/count")
    public ResponseEntity<?> getCountPostPromoBySeller(@RequestParam(value = "user_id") Integer userId)
    {
        CountPromosBySellerDTO countPromosBySellerDTO = productService.getCountPromosBySeller(userId);
        return ResponseEntity.status(HttpStatus.OK).body(countPromosBySellerDTO);
    }

    @GetMapping("promo-post/list")
    public ResponseEntity<?> getListPostPromoBySeller(@RequestParam(value = "user_id") Integer userId)
    {
        PromosBySellerDTO countPromosBySellerDTO = productService.getListPromosBySeller(userId);
        return ResponseEntity.status(HttpStatus.OK).body(countPromosBySellerDTO);
    }

}
