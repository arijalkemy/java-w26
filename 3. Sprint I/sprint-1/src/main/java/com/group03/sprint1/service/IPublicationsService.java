package com.group03.sprint1.service;

import com.group03.sprint1.dto.PublicationDTO;
import com.group03.sprint1.dto.SellerDTO;

import java.util.List;

public interface IPublicationsService {

    List<PublicationDTO> findFollowedLastTwoWeeksPublications(Integer userId, String order);

    SellerDTO createPublicationWithPromo(PublicationDTO publicationDTO);
}
