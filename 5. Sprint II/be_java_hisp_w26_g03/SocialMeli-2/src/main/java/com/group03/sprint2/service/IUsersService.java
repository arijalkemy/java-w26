package com.group03.sprint2.service;

import com.group03.sprint2.dto.SellerNumberOfFollowersDTO;
import com.group03.sprint2.dto.response.BuyerResponseDTO;
import com.group03.sprint2.dto.response.MessageResponseDTO;
import com.group03.sprint2.dto.response.SellerResponseDTO;

import java.util.Comparator;
import java.util.List;


public interface IUsersService {
    SellerResponseDTO showSellerFollowers(Integer userId, String order);
    SellerNumberOfFollowersDTO getNumberOfFollowers(Integer userId);
    MessageResponseDTO followUser(Integer userId, Integer userIdToFollow);
    MessageResponseDTO unfollowUser(Integer userId, Integer userIdToFollow);
    BuyerResponseDTO showBuyerFollowed(Integer userId, String order);
    <T> List<T> orderByLetter(List<T> list, Comparator<? super T> comparator);
}
