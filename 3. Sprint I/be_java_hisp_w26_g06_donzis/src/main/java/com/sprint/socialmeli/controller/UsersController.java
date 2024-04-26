package com.sprint.socialmeli.controller;

import com.sprint.socialmeli.dto.user.FollowedResponseDTO;
import com.sprint.socialmeli.dto.user.FollowersResponseDTO;
import com.sprint.socialmeli.service.user.IUsersService;
import com.sprint.socialmeli.dto.user.FollowerCountResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private IUsersService usersService;

    public UsersController(IUsersService usersService){
        this.usersService = usersService;
    }

    /**
     * Endpoint US0001
     * @param userId Customer user id
     * @param userIdToFollow Seller user id
     * @return String
     * Calls userService to follow a seller
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> follow(
            @PathVariable("userId") Integer userId,
            @PathVariable("userIdToFollow") Integer userIdToFollow) {

        usersService.follow(userId, userIdToFollow);

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    /**
     * Endpoint US0002
     * @param userId Seller user id
     * @return A DTO with the followers count
     * Calls userService to get the followers count from specified user
     */
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowerCountResponseDTO> countFollowers(@PathVariable("userId") Integer userId) {
        FollowerCountResponseDTO followerCount = usersService.getFollowersCount(userId);
        return new ResponseEntity<>(followerCount, HttpStatus.OK);
    }

    /**
     * Endpoint US0003
     * @param userId Seller user id
     * @param order Optional query param to order the followers by name (name_asc, name_desc)
     * @return A DTO with the followers list from specified user
     * Calls userService to get the list of followers
     */
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersResponseDTO> listFollowers(@PathVariable("userId") Integer userId,
                                           @RequestParam(required = false) String order) {

        FollowersResponseDTO followers = usersService.getFollowers(userId, order);

        return new ResponseEntity<>(followers, HttpStatus.OK);
    }

    /**
     * Endpoint US0004
     * @param userId Customer user id
     * @param order Optional query param to order the followed by name (name_asc, name_desc)
     * @return A DTO with the followed list from specified user
     * Calls userService to get the list of followed
     */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedResponseDTO> listFollowedUsers(@PathVariable("userId") Integer userId,
                                                                 @RequestParam(required = false) String order) {
        return new ResponseEntity<>(usersService.listFollowedUsers(userId, order), HttpStatus.OK);
    }

    /**
     * Endpoint US0007
     * @param userId Customer user id
     * @param userIdToUnfollow Seller user id
     * @return String
     * Calls userService to unfollow a seller
     */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        usersService.unfollow(userId, userIdToUnfollow);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
