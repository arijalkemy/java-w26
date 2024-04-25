package org.example.sprint1.controller;

import jakarta.validation.Valid;
import org.example.sprint1.dto.RequestPostDTO;
import org.example.sprint1.dto.RequestPostPromoDTO;
import org.example.sprint1.dto.ResponsePostDTO;
import org.example.sprint1.dto.SellerPromosDTO;
import org.example.sprint1.entity.Seller;
import org.example.sprint1.exception.BadRequestException;
import org.example.sprint1.service.seller.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class SellerController {

    @Autowired
    ISellerService sellerService;

    @Validated
    @PostMapping("/post")
    public ResponseEntity<Void> addPost(@Valid @RequestBody RequestPostDTO postDTO, BindingResult result){
        if(result.hasErrors()){
            throw new BadRequestException("Bad Request");
        }

        sellerService.addPost(postDTO);
        return ResponseEntity.ok().build();
    }

    @Validated
    @PostMapping("/promo-post")
    public ResponseEntity<RequestPostPromoDTO> addPostPromo(@Valid @RequestBody RequestPostPromoDTO postPromoDTO, BindingResult result){
        if(result.hasErrors()){
            throw new BadRequestException("Bad Request");
        }
        sellerService.addPost(postPromoDTO);
        return ResponseEntity.ok().body(postPromoDTO);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Seller>> getAllSellers(){
        return new ResponseEntity<>(sellerService.getSellers(), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ResponsePostDTO> getPostsFromFollowingWithTwoWeeksOld(
            @PathVariable int userId,
            @RequestParam Optional<String> order
    ) {
        return new ResponseEntity<>(sellerService.getPostsFromFollowingWithTwoWeeksOld(userId, order), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<SellerPromosDTO> getSellerPromosCount(@RequestParam int user_id){
        return new ResponseEntity<>(sellerService.getSellersPromosCount(user_id), HttpStatus.OK);
    }

}
