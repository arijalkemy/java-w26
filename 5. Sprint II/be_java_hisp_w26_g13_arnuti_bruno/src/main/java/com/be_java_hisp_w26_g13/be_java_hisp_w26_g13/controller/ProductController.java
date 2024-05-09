package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.controller;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PostDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.IUserRepository;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service.IPostService;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service.IProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Validated
public class ProductController {
    @Autowired
    IProductService productService;
    @Autowired
    IPostService postService;

    @Autowired
    IUserRepository userRepository;

    @PostMapping("/post")
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDTO postDto) {
        return new ResponseEntity<>(postService.create(postDto), HttpStatus.OK);
    }

    //us-0006
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> followedVendorsLastPosts(@Min(value = 1, message = "El id debe ser mayor a cero")
                                                      @PathVariable int userId,
                                                      @RequestParam(required = false) String order) {
        return new ResponseEntity<>(productService.getPostByFollowedUsers(userId, order), HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return new ResponseEntity<>(userRepository.getAll(), HttpStatus.OK);
    }
}
