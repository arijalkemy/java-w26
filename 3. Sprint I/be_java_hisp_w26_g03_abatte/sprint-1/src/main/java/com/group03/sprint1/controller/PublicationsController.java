package com.group03.sprint1.controller;

import com.group03.sprint1.dto.PublicationDTO;
import com.group03.sprint1.dto.response.*;
import com.group03.sprint1.service.IPublicationsService;
import com.group03.sprint1.service.IUsersService;
import com.group03.sprint1.service.implementation.PublicationsServiceImpl;
import com.group03.sprint1.service.implementation.UsersServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class PublicationsController {

    private final IPublicationsService productsService;

    public PublicationsController(PublicationsServiceImpl publicationsService) {
        this.productsService = publicationsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<SellersWithPublicationDTO>> getAllProducts() {
        return new ResponseEntity<>(productsService.showAllSellers(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<MessageResponseDTO> createPublication(@RequestBody PublicationDTO publication) {
        return new ResponseEntity<>(productsService.createPublication(publication), HttpStatus.CREATED);
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

    @PostMapping("/promo-post")
    public ResponseEntity<MessageResponseDTO> createPublicationWithPromo(@RequestBody PublicationDTO publication) {
        return new ResponseEntity<>(productsService.createPublicationWithPromotion(publication), HttpStatus.CREATED);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PublicationPromoCountResponseDTO> getPromoCountPublications(@RequestParam Integer user_id) {
        return new ResponseEntity<>(productsService.getPublicationPromoCount(user_id), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PublicationResponseDTO> getPromoListPublications(@RequestParam Integer user_id) {
        return new ResponseEntity<>(productsService.getPublicationsPromo(user_id), HttpStatus.OK);
    }
}
