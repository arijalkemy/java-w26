package org.example.social_meli.controller;

import org.example.social_meli.dto.UserCountResponseDTO;
import org.example.social_meli.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        userService.followUser(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count/")
    @ResponseBody
    public ResponseEntity<UserCountResponseDTO> countUserFollowers(@PathVariable Integer userId) {
        return new ResponseEntity<>(userService.countFollowers(userId), HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}/followers/list")
    public ResponseEntity<?> getFollowers(@PathVariable("userId") Integer userId) {
        return new ResponseEntity<>(userService.getFollowers(userId), HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}/followed/list")
    public ResponseEntity<?> getFollowedUsers(@PathVariable("userId") Integer userId) {
        return new ResponseEntity<>(userService.getFollowedById(userId), HttpStatus.OK);
    }

    @PostMapping("{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> postUnfollowUser(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        return new ResponseEntity<>(userService.unfollowUser(userId, userIdToUnfollow), HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}/followers/list", params = "order")
    public ResponseEntity<?> getOrderFollowers(@PathVariable("userId") Integer userId, @RequestParam("order") String order) {
        return new ResponseEntity<>(userService.getOrderedFollowersById(userId, order), HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}/followed/list", params = "order")
    public ResponseEntity<?> getOrderFollowedUsers(@PathVariable("userId") Integer userId, @RequestParam(value = "order", required = false) String order) {
        return new ResponseEntity<>(userService.getOrderedFollowedById(userId, order), HttpStatus.OK);
    }

}
