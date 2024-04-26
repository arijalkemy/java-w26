package com.api.socialmeli.controller;
import java.util.List;
import com.api.socialmeli.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.socialmeli.entity.Buyer;
import com.api.socialmeli.service.IBuyerService;

@RestController
@RequestMapping("/users")
public class SocialMeliController {

    @Autowired
    IBuyerService buyerService;

    @Autowired
    private ISellerService iSellerService;

    @GetMapping()
    public ResponseEntity<List<Buyer>> getAll(){
        return new ResponseEntity<List<Buyer>>(buyerService.getAll(), HttpStatus.OK);
    }

    /*
    US 0001: Se realiza la función del controller para direccionar el punto 1, seguir a un vendedor.
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Buyer> followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        return new ResponseEntity<Buyer>(buyerService.followUser(userId, userIdToFollow), HttpStatus.OK);
    }

    /*
    US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
     */
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getCountOfSellerFollowers(@PathVariable Integer userId){
        return new ResponseEntity<>(iSellerService.getCountOfSellerFollowers(userId), HttpStatus.OK);
    }

    /*
    * US 00003 - Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
    * */
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowersOfSeller(
        @PathVariable("userId") int userId,
        @RequestParam(name = "order", defaultValue = "", required = false) String order)
    {
        return new ResponseEntity<>(iSellerService.getFollowersOfSeller(userId, order), HttpStatus.OK);
    }

    /*
    US 0004 and US0008: Se realiza la función del controller para direccionar el endpoint 4 y el respectivo 8 del API
    */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getFollowedListById(@PathVariable Integer userId,@RequestParam(required = false) String order){
        return ResponseEntity.status(HttpStatus.OK).body(buyerService.GetFollowedListByUser(userId,order));
    }


    /*
    US 0007: Se realiza la función del controller para direccionar el punto 7, dejar de seguir a un vendedor.
    */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable Integer userId,
                                          @PathVariable Integer userIdToUnfollow){
        buyerService.unfollowUser(userId,userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
