package org.example.SocialMeli2.controller;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.example.SocialMeli2.dto.SellerFollowerDto;
import org.example.SocialMeli2.dto.FollowedSellersDTO;
import org.example.SocialMeli2.service.follow.IFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/users")
public class FollowController {

    @Autowired
    IFollowService followService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    ResponseEntity<?> userIdToFollow(@PathVariable @Min(value = 1, message = "Debe ser un valor positivo") int userId,
                                     @PathVariable @Min(value = 1, message = "Debe ser un valor positivo") int userIdToFollow) {
        followService.userIdToFollow(userId, userIdToFollow);
        return new ResponseEntity<>("follow exitoso" , HttpStatus.OK);
    }
    @GetMapping("/{userId}/followers/count")
    ResponseEntity<?> countFollowers(
            @PathVariable @NotNull(message = "El  id no puede estar vacío.") @Min(value = 1, message = "El id debe ser mayor a cero")  Integer userId) {
        return new ResponseEntity<>(followService.countFollowers(userId), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    ResponseEntity<?> unfollowSeller(
            @PathVariable @NotNull(message = "El  id no puede estar vacío.") @Min(value = 1, message = "El id debe ser mayor a cero") Integer userId,
            @PathVariable @NotNull(message = "El  id no puede estar vacío.") @Min(value = 1, message = "El id debe ser mayor a cero") Integer userIdToUnfollow) {
        followService.unfollowSeller(userId,userIdToUnfollow);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<SellerFollowerDto> getSellerFollowers(
            @PathVariable @Min(value = 1, message = "El id debe ser mayor a cero.") int userId,
            @RequestParam(required = false) String order) {
        return new ResponseEntity<>(followService.getSellerFollowers(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedSellersDTO> getFollowedSellers(
            @PathVariable @Min(value = 1, message = "El id debe ser mayor a cero.") int userId,
            @RequestParam(required = false) String order){
        return new ResponseEntity<>(followService.getFollowedSellers(userId, order), HttpStatus.OK);
    }
}
