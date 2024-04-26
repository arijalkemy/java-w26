package com.group03.sprint1.controller;

import com.group03.sprint1.dto.SellerFollowersDTO;
import com.group03.sprint1.dto.response.BuyerResponseDTO;
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

    /**
     * Permite que un usuario pueda seguir a un vendedor en especifico.
     * @param userId
     * @param userIdToFollow
     * @return Devuelve un status code 200.
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable Integer userId,
                                        @PathVariable Integer userIdToFollow) {
        usersService.followUser(userId, userIdToFollow);
        return ResponseEntity.ok().build();
    }

    /**
     * Obtiene el resultado de la cantidad de usuarios que siguen a un determinado vendedor.
     * @param userId
     * @return Devuelve un objeto con la cantidad de de usuarios que sigue el vendedor.
     */
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<SellerFollowersDTO> getFollowersCount(@PathVariable Integer userId) {
        SellerFollowersDTO sellerFollowersDTO= usersService.getFollowers(userId);
        return new ResponseEntity<SellerFollowersDTO>(sellerFollowersDTO, HttpStatus.OK);
    }

    /**
     * Obtiene un listado de todos los usuarios que siguen a un determinado vendedor.
     * En caso de que reciba un parametro "order" como query param, la lista se ordenará alfabeticamente ascendente o
     * descendente segun corresponda.
     * @param userId
     * @param order
     * @return Devuelve una lista de usuarios que sigue a un vendedor.
     */
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<SellerResponseDTO> getFollowersList(@PathVariable Integer userId,
                                                              @RequestParam(required = false) String order) {
        SellerResponseDTO sellerResponseDTO = usersService.showSellerFollowers(userId, order);
        return ResponseEntity.ok().body(sellerResponseDTO);
    }

    /**
     * Obtiene un listado de todos los vendedores a los cuales sigue un determinado usuario.
     * En caso de que reciba un parametro "order" como query param, la lista se ordenará alfabeticamente ascendente o
     * descendente segun corresponda.
     * @param userId
     * @param order
     * @return Devuelve una lista de usuarios a los cuales sigue un usuario.
     */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<BuyerResponseDTO> getFollowedList(@PathVariable Integer userId,
                                                            @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(usersService.showBuyerFollowed(userId, order));
    }

    /**
     * Permite que un usuario pueda dejar de seguir a un vendedor en especifico.
     * @param userId
     * @param userIdToUnfollow
     * @return Devuelve un status code 200.
     */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable Integer userId,
                                          @PathVariable Integer userIdToUnfollow) {
        usersService.unfollowUser(userId, userIdToUnfollow);
        return ResponseEntity.ok().build();
    }
}
