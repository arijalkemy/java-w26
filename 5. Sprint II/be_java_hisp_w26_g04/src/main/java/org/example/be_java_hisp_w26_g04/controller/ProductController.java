package org.example.be_java_hisp_w26_g04.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.example.be_java_hisp_w26_g04.dto.PostRequestDTO;
import org.example.be_java_hisp_w26_g04.dto.PostResponseDTO;
import org.example.be_java_hisp_w26_g04.service.seller.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.example.be_java_hisp_w26_g04.util.validation.UtilMinValidation.MIN_USER_ID_MESSAGE;
import static org.example.be_java_hisp_w26_g04.util.validation.UtilMinValidation.MIN_USER_ID_VALUE;

@RestController
@RequestMapping("/products")
@Validated
public class ProductController {
    @Autowired
    ISellerService sellerService;

    @PostMapping("/post")
    public ResponseEntity<?> createPost(@Valid @RequestBody PostRequestDTO post){
        sellerService.createNewPost(post);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<List<PostResponseDTO>> getPostsFromFollower(
            @PathVariable @Min(value = MIN_USER_ID_VALUE, message = MIN_USER_ID_MESSAGE) int userId,
            @RequestParam(required = false, value = "order") String order
    ) {
        return ResponseEntity.ok().body(sellerService.sortGetPostFromFollower(userId, order));

    }

}
