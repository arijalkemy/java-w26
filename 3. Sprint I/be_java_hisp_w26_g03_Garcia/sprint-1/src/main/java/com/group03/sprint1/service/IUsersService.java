package com.group03.sprint1.service;

import com.group03.sprint1.dto.SellerFollowersDTO;
import com.group03.sprint1.dto.PublicationDTO;
import com.group03.sprint1.dto.SellerDTO;
import com.group03.sprint1.dto.response.BuyerResponseDTO;
import com.group03.sprint1.dto.response.SellerResponseDTO;
import com.group03.sprint1.dto.response.SellerWithPromoDTO;
import com.group03.sprint1.dto.response.SellersWithPublicationDTO;
import com.group03.sprint1.entity.Publication;

import java.util.Comparator;
import java.util.List;

import java.util.List;

public interface IUsersService {
    SellerResponseDTO showSellerFollowers(Integer userId, String order);
    SellerFollowersDTO getFollowers(Integer userId);
    void followUser(Integer userId, Integer userIdToFollow);
    void unfollowUser(Integer userId, Integer userIdToFollow);
    BuyerResponseDTO showBuyerFollowed(Integer userId, String order);
    <T> List<T> orderByLetter(List<T> list, Comparator<? super T> comparator);
    List<SellersWithPublicationDTO> showAllSellers();
    SellerDTO createPublication(PublicationDTO publicationDTO);
    void createPromoPublication(PublicationDTO publicationDTO);
    SellerWithPromoDTO getPromoCountBySeller(Integer userId);
}
