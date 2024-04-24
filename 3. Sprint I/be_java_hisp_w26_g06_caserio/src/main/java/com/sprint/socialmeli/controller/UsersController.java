package com.sprint.socialmeli.controller;

import com.sprint.socialmeli.dto.user.FollowersResponseDTO;
import com.sprint.socialmeli.service.user.IUsersService;
import com.sprint.socialmeli.dto.user.FollowerCountResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    private IUsersService _usersService;

    public UsersController(IUsersService usersService){
        this._usersService = usersService;
    }

    // US0001.
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(
            @PathVariable("userId") Integer userId,
            @PathVariable("userIdToFollow") Integer userIdToFollow) {

        _usersService.follow(userId, userIdToFollow);

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    // US0002.
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowerCountResponseDTO> countFollowers(@PathVariable("userId") Integer userId) {
        FollowerCountResponseDTO followerCount = _usersService.getFollowersCount(userId);
        return new ResponseEntity<>(followerCount, HttpStatus.OK);
    }

    // US0003.
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> listFollowers(@PathVariable("userId") Integer userId,
                                           @RequestParam(required = false) String order) {

        FollowersResponseDTO followers = _usersService.getfollowers(userId, order);

        return new ResponseEntity<>(followers, HttpStatus.OK);
    }

    // US0004.
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> listFollowedUsers(@PathVariable("userId") Integer userId,
                                               @RequestParam(required = false) String order) {
        return new ResponseEntity<>(_usersService.listFollowedUsers(userId, order), HttpStatus.OK);
    }

    // US0007.
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        _usersService.unfollow(userId, userIdToUnfollow);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
