package com.group03.sprint1.service;

import com.group03.sprint1.dto.SellerNumberOfFollowersDTO;
import com.group03.sprint1.dto.response.BuyerResponseDTO;
import com.group03.sprint1.dto.response.MessageResponseDTO;
import com.group03.sprint1.dto.response.SellerResponseDTO;
import com.group03.sprint1.dto.response.SellersWithPublicationDTO;

import java.util.Comparator;
import java.util.List;

public interface IUsersService {
    SellerResponseDTO showSellerFollowers(Integer userId, String order);
    SellerNumberOfFollowersDTO getFollowers(Integer userId);
    MessageResponseDTO followUser(Integer userId, Integer userIdToFollow);
    MessageResponseDTO unfollowUser(Integer userId, Integer userIdToFollow);
    BuyerResponseDTO showBuyerFollowed(Integer userId, String order);
    <T> List<T> orderByLetter(List<T> list, Comparator<? super T> comparator);
}
