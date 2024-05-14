package com.sprint.socialmeli.service.user;

import com.sprint.socialmeli.dto.user.FollowersResponseDTO;
import com.sprint.socialmeli.dto.user.UserResponseDTO;
import com.sprint.socialmeli.dto.user.FollowedResponseDTO;
import com.sprint.socialmeli.entity.Customer;
import com.sprint.socialmeli.entity.Seller;
import com.sprint.socialmeli.mappers.UserMapper;
import com.sprint.socialmeli.repository.user.IUsersRepository;
import com.sprint.socialmeli.exception.*;
import com.sprint.socialmeli.dto.user.FollowerCountResponseDTO;
import com.sprint.socialmeli.utils.NameOrderType;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.sprint.socialmeli.mappers.UserMapper.*;

@Service
public class UsersServiceImpl implements IUsersService {

    private IUsersRepository usersRepository;

    public UsersServiceImpl(IUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     *
     * @param customerId Customer id
     * @param sellerId Seller id
     * @throws ConflictException when a customer already follows the seller
     * Checks if the users exists, and if the user already follows the seller only then
     * calls the follow method from customer.
     */
    @Override
    public void follow(Integer customerId, Integer sellerId) {

        Customer customer = this.checkAndGetCustomer(customerId);
        this.checkAndGetSeller(sellerId);

        if (customer.getFollowed().stream().anyMatch(f -> f.equals(sellerId))) {
            throw new ConflictException("The user already follows the seller: " + sellerId);
        }

        customer.follow(sellerId);
    }

    /**
     *
     * @param userId Customer id
     * @param userIdToUnfollow Seller id
     * @throws BadRequestException when a customer not follows the seller
     * Checks if the users exists, and if the user follows the seller only then
     * calls the unfollow method from customer.
     */
    @Override
    public void unfollow(Integer userId, Integer userIdToUnfollow) {

        Customer customer = this.checkAndGetCustomer(userId);
        this.checkAndGetSeller(userIdToUnfollow);

        if (customer.getFollowed().stream().noneMatch(f -> f.equals(userIdToUnfollow))) {
            throw new BadRequestException("The user " + userId + " doesn't follow the seller: " + userIdToUnfollow);
        }

        customer.unfollow(userIdToUnfollow);
    }

    /**
     *
     * @param userId Customer id
     * @param order Optional String to order the follows by name (name_asc, name_desc)
     * @return a DTO with the follow list by the customer
     * @throws NotFoundException if customer is not found
     * @throws BadRequestException if the order string is not empty and is not valid
     * Calls the repository to get the list of the followed users that matches with the user id
     * and order if the order is present
     */
    @Override
    public FollowedResponseDTO listFollowedUsers(Integer userId, String order) {
        Customer customer = this.checkAndGetCustomer(userId);

        if (!isValidOrderType(order)) {
            throw new BadRequestException("Invalid order type: " + order);
        }

        List<Seller> followedSellers = usersRepository
                .findSellerByPredicate(s -> customer.getFollowed().contains(s.getUser().getUserId()));

        List<UserResponseDTO> followed = followedSellers
                .stream()
                .map(UserMapper::mapUserToUserResponseDto)
                .collect(Collectors.toList());

        if (order != null) {
            NameOrderType orderType = NameOrderType.valueOf(order.toUpperCase());
            followed = sortList(followed, orderType);
        }

        return mapUserToFollowedResponseDto(customer, followed);
    }

    /**
     *
     * @param sellerId Seller id
     * @param orderType Optional String to order the followers by name (name_asc, name_desc)
     * @return a DTO with the follow list
     * @throws NotFoundException if seller is not found
     * @throws BadRequestException if the order string is not empty and is not valid
     * Calls the repository to get the list of the followers users that matches with the user id
     * and order if the order is present
     */
    @Override
    public FollowersResponseDTO getFollowers(Integer sellerId, String orderType) {

        Seller seller = this.checkAndGetSeller(sellerId);

        if (!isValidOrderType(orderType)) {
            throw new BadRequestException("Invalid order type: " + orderType);
        }

        List<Customer> followers = usersRepository.findCustomerByPredicate(c -> c.getFollowed().contains(sellerId));
        List<UserResponseDTO> usersDto = followers
                .stream()
                .map(UserMapper::mapUserToUserResponseDto)
                .toList();

        if (orderType != null) {
            NameOrderType order = NameOrderType.valueOf(orderType.toUpperCase());
            usersDto = sortList(usersDto, order);
        }

        return mapUserToFollowerResponseDto(seller, usersDto);
    }

    /**
     *
     * @param orderType String with the order
     * @return true if is valid order type else return false
     * Checks if the order type matches with the NameOrderType enum
     */
    private boolean isValidOrderType(String orderType) {
        return orderType == null
                || Arrays.stream(NameOrderType.values()).anyMatch(type -> type.name().equalsIgnoreCase(orderType));
    }

    /**
     *
     * @param dtos list of dto to order
     * @param orderType enum (name_asc, name_desc)
     * @return A sorted list of dto according to the order type
     */
    private List<UserResponseDTO> sortList(List<UserResponseDTO> dtos, NameOrderType orderType) {
        return switch (orderType) {
            case NAME_ASC -> dtos.stream().sorted(Comparator.comparing(UserResponseDTO::getUser_name)).toList();
            case NAME_DESC ->
                    dtos
                        .stream()
                        .sorted(Comparator.comparing(UserResponseDTO::getUser_name, Collections.reverseOrder()))
                        .toList();
            default -> dtos;
        };
    }

    /**
     *
     * @param sellerId Seller id
     * @return A DTO with the followers count of a seller
     * @throws NotFoundException if seller not exists
     * Get the count of follows of the customers and matches with seller id
     */
    @Override
    public FollowerCountResponseDTO getFollowersCount(Integer sellerId) {

        Seller seller = this.checkAndGetSeller(sellerId);

        Integer followersCount = usersRepository
                .findCustomerByPredicate(customer -> customer.getFollowed()
                        .stream()
                        .anyMatch(s -> s.equals(sellerId)))
                .size();

        return mapUserToFollowerCountDto(seller, followersCount);

    }

    // ------- Refactor

    /**
     *
     * @param sellerId Seller id
     * @return a Seller entity
     * @throws NotFoundException if any of the users not exists in the repository
     * Checks if the users exists in the repository
     */
    public Seller checkAndGetSeller(Integer sellerId) {
        Seller seller = usersRepository
                .findSellerById(sellerId);

        if (seller == null) {
            throw new NotFoundException("Seller with ID: " + sellerId + " not found");
        }

        return seller;
    }

    /**
     *
     * @param customerId Customer id
     * @return a Customer entity
     * @throws NotFoundException if any of the users not exists in the repository
     * Checks if the users exists in the repository
     */
    public Customer checkAndGetCustomer(Integer customerId) {
        Customer customer = usersRepository
                .findCustomerById(customerId);

        if (customer == null) {
            throw new NotFoundException("Customer with ID: " + customerId + " not found");
        }

        return customer;
    }
}
