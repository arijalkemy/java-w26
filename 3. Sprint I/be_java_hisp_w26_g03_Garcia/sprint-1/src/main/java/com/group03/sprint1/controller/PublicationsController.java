package com.group03.sprint1.controller;

import com.group03.sprint1.dto.PublicationDTO;
import com.group03.sprint1.dto.response.ResponseIdPublicationsDTO;
import com.group03.sprint1.dto.response.SellerWithPromoCountDTO;
import com.group03.sprint1.dto.response.SellerWithPromoListDTO;
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
        usersService.createPublication(publication);
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


    @PostMapping("/promo-post")
    public ResponseEntity<String> createPromoPublication(@RequestBody PublicationDTO publicationDTO){
        usersService.createPromoPublication(publicationDTO);
        return new ResponseEntity<>("Promo post created succesfully.", HttpStatus.CREATED);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<SellerWithPromoCountDTO> getPromoCountBySeller(@RequestParam Integer userId){
        return ResponseEntity.ok().body(usersService.getPromoCountBySeller(userId));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<SellerWithPromoListDTO> getPromoListBySeller(@RequestParam Integer userId){
        return ResponseEntity.ok().body(usersService.getPromoListBySeller(userId));
    }

}
