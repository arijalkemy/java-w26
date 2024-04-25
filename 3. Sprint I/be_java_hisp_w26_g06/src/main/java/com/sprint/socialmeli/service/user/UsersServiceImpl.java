package com.sprint.socialmeli.service.user;

import com.sprint.socialmeli.dto.user.FollowersResponseDTO;
import com.sprint.socialmeli.dto.user.UserResponseDTO;
import com.sprint.socialmeli.dto.user.FollowedResponseDTO;
import com.sprint.socialmeli.entity.Customer;
import com.sprint.socialmeli.entity.IFollower;
import com.sprint.socialmeli.entity.Seller;
import com.sprint.socialmeli.repository.user.IUsersRepository;
import com.sprint.socialmeli.exception.*;
import com.sprint.socialmeli.dto.user.FollowerCountResponseDTO;
import com.sprint.socialmeli.utils.NameOrderType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements IUsersService {

    private IUsersRepository _usersRepository;

    public UsersServiceImpl(IUsersRepository usersRepository) {
        this._usersRepository = usersRepository;
    }

    /**
     *
     * @param userId Customer id
     * @param sellerId Seller id
     * @throws ConflictException when a customer already follows the seller
     * Checks if the users exists, and if the user already follows the seller only then
     * calls the follow method from customer.
     */
    @Override
    public void follow(Integer userId, Integer sellerId) {
        IFollower follower = checkAndGetUser(userId, sellerId);

        if( follower.getFollowed().containsKey(sellerId) ){
            throw  new ConflictException("The user already follows the seller: " + sellerId);
        }

        LocalDate now = LocalDate.now();
        follower.follow(sellerId, now);
    }

    /**
     *
     * @param userId Customer id
     * @param sellerId Seller id
     * @return a Customer entity
     * @throws NotFoundException if any of the users not exists in the repository
     * Checks if the users exists in the repository
     */
    private IFollower checkAndGetUser(Integer userId, Integer sellerId) {
        if(Objects.equals(userId, sellerId)){
            throw new BadRequestException("Ids should be different");
        }

        IFollower resp = _usersRepository
                .findCustomerByPredicate(c -> c.getUser().getUserId().equals(userId)).stream()
                .findFirst().orElse(null);

        _usersRepository.findSellerByPredicate(s -> s.getUser().getUserId().equals(sellerId))
                .stream().findFirst()
                .orElseThrow(() -> new NotFoundException("Seller with ID: " + userId + " not found"));

        if (resp == null) {
            resp = _usersRepository.findSellerByPredicate(s -> s.getUser().getUserId().equals(userId))
                    .stream().findFirst()
                    .orElseThrow(() -> new NotFoundException("User with ID: " + userId + " not found"));
        }


        return resp;
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
        IFollower follower = checkAndGetUser(userId, userIdToUnfollow);

        if( follower.getFollowed().get(userIdToUnfollow) == null ) {
            throw new BadRequestException("The user " + userId + " doesn't follow the seller: " + userIdToUnfollow);
        }

        follower.unfollow(userIdToUnfollow);
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
        List<Customer> customers = _usersRepository
                .findCustomerByPredicate(c -> c.getUser().getUserId().equals(userId));

        if (customers.isEmpty()) {
            throw new NotFoundException("Customer with ID: " + userId + " not found");
        }

        if (!isValidOrderType(order)) {
            throw new BadRequestException("Invalid order type: " + order);
        }

        Customer customer = customers.get(0);

        List<Seller> followedSellers = _usersRepository
                .findSellerByPredicate(s -> customer.getFollowed().get(s.getUser().getUserId()) != null);

        List<UserResponseDTO> followed = followedSellers
                .stream()
                .map(s -> new UserResponseDTO(s.getUser().getUserId(), s.getUser().getUserName()))
                .collect(Collectors.toList());

        if (order != null) {
            NameOrderType orderType = NameOrderType.valueOf(order.toUpperCase());
            followed = sortList(followed, orderType);
        }

        return new FollowedResponseDTO(customer.getUser().getUserId(), customer.getUser().getUserName(), followed);
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
    public FollowersResponseDTO getfollowers(Integer sellerId, String orderType) {

        Seller seller = _usersRepository
                .findSellerByPredicate(s -> s.getUser().getUserId().equals(sellerId))
                .stream()
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Seller with ID: " + sellerId + " not found"));


        if (!isValidOrderType(orderType)) {
            throw new BadRequestException("Invalid order type: " + orderType);
        }

        List<Customer> followers = _usersRepository.findCustomerByPredicate(c -> c.getFollowed().get(sellerId) != null );
        List<UserResponseDTO> usersDto = followers
                .stream()
                .map(f -> new UserResponseDTO(f.getUser().getUserId(), f.getUser().getUserName()))
                .toList();

        if (orderType != null) {
            NameOrderType order = NameOrderType.valueOf(orderType.toUpperCase());
            usersDto = sortList(usersDto, order);
        }

        String sellerName = seller.getUser().getUserName();

        return new FollowersResponseDTO(sellerId, sellerName, usersDto);
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
    public FollowerCountResponseDTO getFollowersCount(Integer sellerId, String dateSince, String dateTo) {
        Seller seller = _usersRepository
                .findSellerByPredicate(s -> s.getUser().getUserId().equals(sellerId))
                .stream()
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Seller with ID: " + sellerId + " not found"));

        Integer followersCount = 0;
        if( dateSince == null && dateTo == null ) {
            followersCount = _usersRepository
                    .findCustomerByPredicate(customer -> customer.getFollowed()
                            .get(sellerId) != null )
                    .size();
        } else if ( dateSince.isEmpty() || dateTo.isEmpty() ) {
            throw new BadRequestException("Invalid date");
        }else {
            LocalDate dateSinceFormatter = LocalDate.parse(dateSince, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            LocalDate dateToFormatter = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            followersCount = _usersRepository
                    .findCustomerByPredicate(customer -> {
                        LocalDate date = customer.getFollowed()
                                .get(sellerId);
                        return date != null &&
                                !date.isBefore( dateSinceFormatter ) &&
                                !date.isAfter( dateToFormatter );
                    } )
                    .size();
        }


        return new FollowerCountResponseDTO(
                sellerId,
                seller.getUser().getUserName(),
                followersCount
        );

    }
}
