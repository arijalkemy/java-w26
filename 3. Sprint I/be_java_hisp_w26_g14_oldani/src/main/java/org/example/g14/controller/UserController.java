package org.example.g14.controller;

import org.example.g14.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getListOfFollowedSellers (@PathVariable int userId,
                                                       @RequestParam(required = false) String order){
        return new ResponseEntity<>(userService.getListOfFollowedSellers(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable int userId, @PathVariable int userIdToFollow) {
        return new ResponseEntity<>(userService.follow(userId, userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> countFollowersBySeller(@PathVariable int userId){
        return new ResponseEntity<>(userService.countFollowersBySeller(userId), HttpStatus.OK);
    }
  
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowersList (@PathVariable int userId,
                                               @RequestParam(required = false) String order){
        return new ResponseEntity<>(userService.getAllFolowers(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowSeller(
        @PathVariable("userId") int followerUserId,
        @PathVariable("userIdToUnfollow") int sellerUserId
    ) {
        return ResponseEntity.ok(
            userService.unfollowSeller(followerUserId, sellerUserId)
        );
    }
}
