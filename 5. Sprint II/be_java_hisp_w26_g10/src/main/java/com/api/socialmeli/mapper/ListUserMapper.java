package com.api.socialmeli.mapper;

import com.api.socialmeli.dto.UserDto;
import com.api.socialmeli.entity.Buyer;

import java.util.List;
import java.util.stream.Collectors;

public class ListUserMapper {
    /**
     * @description transform a list of Buyer Entity to UserDTO list
     * @param buyerFollowers
     * @return List<UserDto>
     */
    public static List<UserDto> buyerListToUserDtoList(List<Buyer> buyerFollowers){
        return buyerFollowers.stream()
                .map(buyer -> new UserDto(buyer.getUser_id(), buyer.getUser_name()))
                .collect(Collectors.toList());
    }
}
