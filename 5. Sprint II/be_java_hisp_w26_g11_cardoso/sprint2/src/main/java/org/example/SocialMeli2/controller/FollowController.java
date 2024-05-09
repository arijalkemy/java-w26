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

/**
 * Controlador para las operaciones de seguimiento entre usuarios.
 */
@RestController
@Validated
@RequestMapping("/users")
public class FollowController {

    @Autowired
    IFollowService followService;

    /**
     * Permite a un usuario seguir a otro.
     *
     * @param userId El ID del usuario que quiere seguir a otro.
     * @param userIdToFollow El ID del usuario a seguir.
     * @return Una respuesta HTTP indicando el éxito de la operación.
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    ResponseEntity<?> userIdToFollow(@PathVariable @Min(value = 1, message = "Debe ser un valor positivo") int userId,
                                     @PathVariable @Min(value = 1, message = "Debe ser un valor positivo") int userIdToFollow) {
        followService.userIdToFollow(userId, userIdToFollow);
        return new ResponseEntity<>("follow exitoso" , HttpStatus.OK);
    }

    /**
     * Obtiene el conteo de seguidores de un usuario.
     *
     * @param userId El ID del usuario.
     * @return Una respuesta HTTP con el conteo de seguidores.
     */
    @GetMapping("/{userId}/followers/count")
    ResponseEntity<?> countFollowers(
            @PathVariable @NotNull(message = "El  id no puede estar vacío.") @Min(value = 1, message = "El id debe ser mayor a cero")  Integer userId) {
        return new ResponseEntity<>(followService.countFollowers(userId), HttpStatus.OK);
    }

    /**
     * Permite a un usuario dejar de seguir a otro.
     *
     * @param userId El ID del usuario que quiere dejar de seguir a otro.
     * @param userIdToUnfollow El ID del usuario a dejar de seguir.
     * @return Una respuesta HTTP indicando el éxito de la operación.
     */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    ResponseEntity<?> unfollowSeller(
            @PathVariable @NotNull(message = "El  id no puede estar vacío.") @Min(value = 1, message = "El id debe ser mayor a cero") Integer userId,
            @PathVariable @NotNull(message = "El  id no puede estar vacío.") @Min(value = 1, message = "El id debe ser mayor a cero") Integer userIdToUnfollow) {
        followService.unfollowSeller(userId,userIdToUnfollow);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    /**
     * Obtiene la lista de seguidores de un vendedor.
     *
     * @param userId El ID del vendedor.
     * @param order El orden en el que se desea obtener la lista.
     * @return Una respuesta HTTP con la lista de seguidores.
     */
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<SellerFollowerDto> getSellerFollowers(
            @PathVariable @Min(value = 1, message = "El id debe ser mayor a cero.") int userId,
            @RequestParam(required = false) String order) {
        return new ResponseEntity<>(followService.getSellerFollowers(userId, order), HttpStatus.OK);
    }

    /**
     * Obtiene la lista de vendedores seguidos por un usuario.
     *
     * @param userId El ID del usuario.
     * @param order El orden en el que se desea obtener la lista.
     * @return Una respuesta HTTP con la lista de vendedores seguidos.
     */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedSellersDTO> getFollowedSellers(
            @PathVariable @Min(value = 1, message = "El id debe ser mayor a cero.") int userId,
            @RequestParam(required = false) String order){
        return new ResponseEntity<>(followService.getFollowedSellers(userId, order), HttpStatus.OK);
    }
}
