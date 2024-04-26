package com.group03.sprint1.controller;

import com.group03.sprint1.dto.SellerNumberOfFollowersDTO;
import com.group03.sprint1.dto.response.BuyerResponseDTO;
import com.group03.sprint1.dto.response.MessageResponseDTO;
import com.group03.sprint1.dto.response.SellerResponseDTO;
import com.group03.sprint1.service.IUsersService;
import com.group03.sprint1.service.implementation.UsersServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final IUsersService usersService;
  
    public UsersController(UsersServiceImpl usersService) {
        this.usersService = usersService;

    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<MessageResponseDTO> followUser(@PathVariable Integer userId,
                                                         @PathVariable Integer userIdToFollow) {
        return ResponseEntity.ok().body(usersService.followUser(userId, userIdToFollow));
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<SellerNumberOfFollowersDTO> getFollowersCount(@PathVariable Integer userId) {
        SellerNumberOfFollowersDTO sellerNumberOfFollowersDTO = usersService.getFollowers(userId);
        return new ResponseEntity<SellerNumberOfFollowersDTO>(sellerNumberOfFollowersDTO, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<SellerResponseDTO> getFollowersList(@PathVariable Integer userId,
                                                              @RequestParam(required = false) String order) {
        SellerResponseDTO sellerResponseDTO = usersService.showSellerFollowers(userId, order);
        return ResponseEntity.ok().body(sellerResponseDTO);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<BuyerResponseDTO> getFollowedList(@PathVariable Integer userId,
                                                            @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(usersService.showBuyerFollowed(userId, order));
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<MessageResponseDTO> unfollowUser(@PathVariable Integer userId,
                                          @PathVariable Integer userIdToUnfollow) {
        return ResponseEntity.ok().body(usersService.unfollowUser(userId, userIdToUnfollow));
    }

}
