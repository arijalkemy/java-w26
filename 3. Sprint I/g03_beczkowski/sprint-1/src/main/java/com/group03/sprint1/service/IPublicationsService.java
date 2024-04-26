package com.group03.sprint1.service;

import com.group03.sprint1.dto.PublicationDTO;
import com.group03.sprint1.dto.SellerDTO;
import com.group03.sprint1.dto.response.PublicationPromoResponseDTO;
import com.group03.sprint1.dto.response.PublicationResponseDTO;

import java.util.List;

public interface IPublicationsService {

    List<PublicationDTO> findFollowedLastTwoWeeksPublications(Integer userId, String order);
    SellerDTO createPublication(PublicationDTO publicationDTO);
    void createPublicationPromo(PublicationDTO publication);
    PublicationPromoResponseDTO getPublicationPromoCount(Integer userId);
    PublicationResponseDTO getPublicationsPromo(Integer userId);
    List<PublicationPromoResponseDTO> getAllPublicationsPromoCount();
    List<PublicationResponseDTO> getPublicationsWithDiscountGreaterThan(Double discount);
}
