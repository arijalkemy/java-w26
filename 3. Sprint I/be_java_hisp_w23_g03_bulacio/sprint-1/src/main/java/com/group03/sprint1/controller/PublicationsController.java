package com.group03.sprint1.controller;

import com.group03.sprint1.dto.PublicationDTO;
import com.group03.sprint1.dto.response.PublicationListDTO;
import com.group03.sprint1.dto.response.ResponseIdPublicationsDTO;
import com.group03.sprint1.dto.response.SellerPromoCountResponseDTO;
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

    private final IPublicationsService publicationsService;

    private IUsersService usersService;

    public PublicationsController(PublicationsServiceImpl publicationsService, UsersServiceImpl usersServiceImpl) {
        this.publicationsService = publicationsService;
        this.usersService = usersServiceImpl;
    }

    @PostMapping("/post")
    public ResponseEntity<String> createPublication(@RequestBody PublicationDTO publication) {
        usersService.createPublication(publication);
        return new ResponseEntity<>("Post created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ResponseIdPublicationsDTO> getFollowedLastTwoWeeksPublications(@PathVariable Integer userId,
                                                                                         @RequestParam(required = false) String order) {

        ResponseIdPublicationsDTO responseTwoWeeksPublicationsDTO = new ResponseIdPublicationsDTO();

        List<PublicationDTO> publicationsDTOList = publicationsService.findFollowedLastTwoWeeksPublications(userId, order);

        responseTwoWeeksPublicationsDTO.setPublications(publicationsDTOList);
        responseTwoWeeksPublicationsDTO.setUserId(userId);

        return new ResponseEntity<>(responseTwoWeeksPublicationsDTO, HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<String> postPublicationWithPromotion(@RequestBody PublicationDTO publication) {
        usersService.createPublication(publication);
        return new ResponseEntity<>("Post with promotion created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<SellerPromoCountResponseDTO> getSellerPublicationsWithPromotionCount(@RequestParam Integer userId) {
        SellerPromoCountResponseDTO sellerPromoCountResponseDTO = publicationsService.countPublicationsInPromotionForSeller(userId);
        return new ResponseEntity<>(sellerPromoCountResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<PublicationListDTO> getAllPublications(
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) Double minTotal,
            @RequestParam(required = false) Double maxTotal,
            @RequestParam(required = false) String order
    ) {
        PublicationListDTO publicationListDTO = publicationsService.getAllPublications(
                productName,
                minTotal,
                maxTotal,
                order);
        return new ResponseEntity<>(publicationListDTO, HttpStatus.OK);
    }
}
