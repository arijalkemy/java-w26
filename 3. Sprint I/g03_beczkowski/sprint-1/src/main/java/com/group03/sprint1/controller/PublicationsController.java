package com.group03.sprint1.controller;

import com.group03.sprint1.dto.PublicationDTO;
import com.group03.sprint1.dto.response.PublicationPromoResponseDTO;
import com.group03.sprint1.dto.response.PublicationResponseDTO;
import com.group03.sprint1.dto.response.ResponseIdPublicationsDTO;
import com.group03.sprint1.dto.response.SellersWithPublicationDTO;
import com.group03.sprint1.service.IPublicationsService;
import com.group03.sprint1.service.IUsersService;
import com.group03.sprint1.service.implementation.PublicationsServiceImpl;
import com.group03.sprint1.service.implementation.UsersServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class PublicationsController {

    private final IPublicationsService productsService;

    private IUsersService usersService;

    public PublicationsController(PublicationsServiceImpl publicationsService, UsersServiceImpl usersServiceImpl) {
        this.productsService = publicationsService;
        this.usersService = usersServiceImpl;
    }

    @GetMapping("/all")
    public ResponseEntity<List<SellersWithPublicationDTO>> getAllProducts() {
        return new ResponseEntity<>(usersService.showAllSellers(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> createPublication(@RequestBody PublicationDTO publication) {
        productsService.createPublication(publication);
        return new ResponseEntity<>("Post created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ResponseIdPublicationsDTO> getFollowedLastTwoWeeksPublications(@PathVariable Integer userId,
                                                                                         @RequestParam(required = false) String order) {
        ResponseIdPublicationsDTO responseTwoWeeksPublicationsDTO = new ResponseIdPublicationsDTO();
        List<PublicationDTO> publicationsDTOList = productsService.findFollowedLastTwoWeeksPublications(userId, order);
        responseTwoWeeksPublicationsDTO.setPublications(publicationsDTOList);
        responseTwoWeeksPublicationsDTO.setUserId(userId);

        return new ResponseEntity<>(responseTwoWeeksPublicationsDTO, HttpStatus.OK);
    }

    /*----------- INDIVIDUAL y BONUS ---------------*/
    @PostMapping("/promo-post")
    public ResponseEntity<String> createPublicationPromo(@RequestBody PublicationDTO publication) {
        productsService.createPublicationPromo(publication);
        return new ResponseEntity<>("Publication promo created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PublicationPromoResponseDTO> getPublicationPromoCount(@RequestParam Integer user_id) {
        return new ResponseEntity<>(productsService.getPublicationPromoCount(user_id), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PublicationResponseDTO> getPublicationsPromo(@RequestParam Integer user_id) {
        return new ResponseEntity<>(productsService.getPublicationsPromo(user_id), HttpStatus.OK);
    }

}
