package org.example.be_java_hisp_w26_g04.controller;

import jakarta.validation.constraints.Min;
import org.example.be_java_hisp_w26_g04.dto.BuyerDTO;
import org.example.be_java_hisp_w26_g04.dto.FollowersCountDTO;
import org.example.be_java_hisp_w26_g04.dto.SellerFollowersDTO;
import org.example.be_java_hisp_w26_g04.service.buyer.IBuyerService;
import org.example.be_java_hisp_w26_g04.service.seller.ISellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.example.be_java_hisp_w26_g04.util.validation.UtilValidation.MIN_USER_ID_MESSAGE;
import static org.example.be_java_hisp_w26_g04.util.validation.UtilValidation.MIN_USER_ID_VALUE;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @Autowired
    IBuyerService buyerService;

    @Autowired
    ISellerService sellerService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(
            @PathVariable @Min(value = MIN_USER_ID_VALUE, message = MIN_USER_ID_MESSAGE) int userId,
            @PathVariable @Min(value = MIN_USER_ID_VALUE, message = MIN_USER_ID_MESSAGE) int userIdToFollow
    ) {
        buyerService.followSeller(userId, userIdToFollow);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<SellerFollowersDTO> sortFollowers(
            @RequestParam(required = false) String order,
            @PathVariable @Min(value = MIN_USER_ID_VALUE, message = MIN_USER_ID_MESSAGE) int userId
    ) {
        if (order != null) {
            return ResponseEntity.ok().body(sellerService.sortGetFollowers(userId, order));
        } else {
            return ResponseEntity.ok().body(sellerService.getFollowers(userId));
        }
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCount(
            @PathVariable @Min(value = MIN_USER_ID_VALUE, message = MIN_USER_ID_MESSAGE) int userId
    ) {
        return ResponseEntity.ok(sellerService.findFollowers(userId));
    }


    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<BuyerDTO> sortFollowed(
            @RequestParam(required = false) String order,
            @PathVariable @Min(value = MIN_USER_ID_VALUE, message = MIN_USER_ID_MESSAGE) int userId
    ) {
        if (order != null) {
            return ResponseEntity.ok(buyerService.sortGetFollowed(userId, order));
        } else {
            return ResponseEntity.ok(buyerService.getFollowed(userId));
        }
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(
            @PathVariable @Min(value = MIN_USER_ID_VALUE, message = MIN_USER_ID_MESSAGE) int userId,
            @PathVariable @Min(value = MIN_USER_ID_VALUE, message = MIN_USER_ID_MESSAGE) int userIdToUnfollow
    ) {
        buyerService.unfollowerSeller(userId, userIdToUnfollow);
        return ResponseEntity.ok().build();
    }

}
