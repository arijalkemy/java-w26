package com.sprint.socialmeli.mappers;

import com.sprint.socialmeli.dto.user.FollowedResponseDTO;
import com.sprint.socialmeli.dto.user.FollowerCountResponseDTO;
import com.sprint.socialmeli.dto.user.FollowersResponseDTO;
import com.sprint.socialmeli.dto.user.UserResponseDTO;
import com.sprint.socialmeli.entity.Customer;
import com.sprint.socialmeli.entity.Seller;

import java.util.List;

public class UserMapper {

    public static FollowersResponseDTO mapUserToFollowerResponseDto(Seller seller, List<UserResponseDTO> usersDto) {
        return new FollowersResponseDTO(
                seller.getUser().getUserId(),
                seller.getUser().getUserName(),
                usersDto
        );
    }

    public static FollowerCountResponseDTO mapUserToFollowerCountDto(Seller seller, Integer count) {
        return new FollowerCountResponseDTO(
                seller.getUser().getUserId(),
                seller.getUser().getUserName(),
                count
        );
    }

    public static FollowedResponseDTO mapUserToFollowedResponseDto(Customer customer, List<UserResponseDTO> usersDto) {
        return new FollowedResponseDTO(
                customer.getUser().getUserId(),
                customer.getUser().getUserName(),
                usersDto
        );
    }

    public static UserResponseDTO mapSellerToUserResponseDto(Seller seller){
        return new UserResponseDTO(
                seller.getUser().getUserId(),
                seller.getUser().getUserName()
        );
    }

    public static UserResponseDTO mapCustomerToUserResponseDto(Customer customer){
        return new UserResponseDTO(
                customer.getUser().getUserId(),
                customer.getUser().getUserName()
        );
    }
}
