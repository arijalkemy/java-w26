package com.group03.sprint1.service;

import com.group03.sprint1.dto.PublicationDTO;
import com.group03.sprint1.dto.response.PublicationListDTO;
import com.group03.sprint1.dto.response.SellerPromoCountResponseDTO;

import java.util.List;

public interface IPublicationsService {
    SellerPromoCountResponseDTO countPublicationsInPromotionForSeller(Integer userId);
    List<PublicationDTO> findFollowedLastTwoWeeksPublications(Integer userId, String order);

    PublicationListDTO getAllPublications(String productName, Double minTotal, Double maxTotal, String order);
}
