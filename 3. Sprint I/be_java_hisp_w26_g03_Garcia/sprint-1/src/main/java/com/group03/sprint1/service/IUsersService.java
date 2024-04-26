package com.group03.sprint1.service;

import com.group03.sprint1.dto.SellerFollowersDTO;
import com.group03.sprint1.dto.PublicationDTO;
import com.group03.sprint1.dto.SellerDTO;
import com.group03.sprint1.dto.response.*;
import com.group03.sprint1.entity.Publication;

import java.util.Comparator;
import java.util.List;

public interface IUsersService {
    SellerResponseDTO showSellerFollowers(Integer userId, String order);
    SellerFollowersDTO getFollowers(Integer userId);
    void followUser(Integer userId, Integer userIdToFollow);
    void unfollowUser(Integer userId, Integer userIdToFollow);
    BuyerResponseDTO showBuyerFollowed(Integer userId, String order);
    List<SellersWithPublicationDTO> showAllSellers();
    SellerDTO createPublication(PublicationDTO publicationDTO);
    void createPromoPublication(PublicationDTO publicationDTO);
    SellerWithPromoCountDTO getPromoCountBySeller(Integer userId);
    SellerWithPromoListDTO getPromoListBySeller(Integer userId);
    String deletePostOfSeller(Integer userId, Integer postId);
    String updatePostOfSeller(Integer userId, Integer postId, PublicationDTO publication);
    List<BuyerResponseDTO> getListBuyers();
}
