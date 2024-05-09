package com.meli.be_java_hisp_w26_g09.controller;

import com.meli.be_java_hisp_w26_g09.dto.ResponseDTO;
import com.meli.be_java_hisp_w26_g09.dto.UserDTO;
import com.meli.be_java_hisp_w26_g09.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserDTO> getFollowersList(@PathVariable Integer userId,
                                                    @RequestParam(required = false) String order) {
        if (order == null || order.isEmpty())
            return ResponseEntity.ok(userService.getFollowersById(userId));

        return ResponseEntity.ok(userService.getFollowersByIdOrdered(userId, order));
    }


    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserDTO> getFollowedList(@PathVariable Integer userId,
                                             @RequestParam(required = false) String order) {
        if (order == null || order.isEmpty())
            return ResponseEntity.ok(userService.getFollowedById(userId));

        return ResponseEntity.ok(userService.getFollowedByIdOrdered(userId, order));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResponseDTO> postFollow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.follow(userId, userIdToFollow));
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<ResponseDTO> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return ResponseEntity.ok(userService.unfollowUser(userId, userIdToUnfollow));
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserDTO> getFollowersCount(@PathVariable Integer userId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getFollowersCount(userId));
    }
}
