package com.sprint.socialmeli.service.post;

import com.sprint.socialmeli.dto.post.FollowedProductsResponseDTO;
import com.sprint.socialmeli.dto.post.PostDTO;
import com.sprint.socialmeli.dto.post.PostResponseDTO;
import com.sprint.socialmeli.dto.post.PromoPostRequestDTO;
import com.sprint.socialmeli.dto.user.UserWithPromoPostsDTO;
import com.sprint.socialmeli.entity.Customer;
import com.sprint.socialmeli.entity.Post;
import com.sprint.socialmeli.entity.Seller;
import com.sprint.socialmeli.exception.BadRequestException;
import com.sprint.socialmeli.exception.NotFoundException;
import com.sprint.socialmeli.mappers.PostMapper;
import com.sprint.socialmeli.repository.post.IPostRepository;
import com.sprint.socialmeli.repository.user.IUsersRepository;
import com.sprint.socialmeli.utils.DateOrderType;
import com.sprint.socialmeli.utils.UserChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.sprint.socialmeli.mappers.PostMapper.mapPostToPostResponseDto;
import static com.sprint.socialmeli.mappers.PostMapper.mapToEntity;
import static com.sprint.socialmeli.mappers.UserMapper.mapCustomerToFollowedProductsResponseDto;
import static com.sprint.socialmeli.mappers.UserMapper.mapSellerToUserWithPromoPostsDTO;

@Service
public class PostServiceImpl implements IPostService {

    @Autowired
    IPostRepository postRepository;

    @Autowired
    IUsersRepository usersRepository;

    /**
     * @param postDTO A DTO with the post to create
     * @throws BadRequestException if the seller id of the post not exists
     *                             Checks if the seller exists and calls the post repository to save the new post
     */
    @Override
    public Integer createPost(PostDTO postDTO) {
        UserChecker.checkAndGetSeller(postDTO.getUser_id());
        Post newPost = PostMapper.mapToEntity(postDTO);
        this.postRepository.save(newPost, postDTO.getUser_id());

        return newPost.getId();
    }


    /**
     * @param customer_id customer id
     * @param order       Optional String to order the posts by date (date_asc, date_desc)
     * @return A DTO with the list of posts of the followed sellers
     * @throws NotFoundException   if Customer not exists
     * @throws BadRequestException if the order type is not empty and not valid
     */
    @Override
    public FollowedProductsResponseDTO getFollowedProductsList(Integer customer_id, String order) {
        Customer customer = UserChecker.checkAndGetCustomer(customer_id);

        if (!isValidOrderType(order)) {
            throw new BadRequestException("Invalid order type: " + order);
        }

        List<PostResponseDTO> postResponseDTOList = new ArrayList<>();

        LocalDate now = LocalDate.now();
        LocalDate weekPoint = now.minusWeeks(2);
        for (Integer sellerId : customer.getFollowed()) {
            postResponseDTOList.addAll(postRepository.findBySellerId(sellerId)
                    .stream()
                    .filter(post -> post.getPostDate().isAfter(weekPoint))
                    .map(p -> mapPostToPostResponseDto(p, sellerId)).toList());
        }

        if (order != null) {
            DateOrderType orderType = DateOrderType.valueOf(order.toUpperCase());
            postResponseDTOList = sortList(postResponseDTOList, orderType);
        }

        return mapCustomerToFollowedProductsResponseDto(customer, postResponseDTOList);
    }

    @Override
    public Integer createPromoPost(PromoPostRequestDTO post) {
        UserChecker.checkAndGetSeller(post.getUser_id());
        Post promoPost = mapToEntity(post);
        postRepository.save(promoPost, post.getUser_id());
        return promoPost.getId();
    }

    @Override
    public UserWithPromoPostsDTO getPromoPostsBySeller(Integer userId) {
        Seller seller = UserChecker.checkAndGetSeller(userId);
        return mapSellerToUserWithPromoPostsDTO(seller,
                postRepository.findBySellerId(userId).stream().filter(Post::getHasPromo).count());
    }

    /**
     * @param dtos      list of dto to order
     * @param orderType enum (date_asc, date_desc)
     * @return A sorted list of dto according to the order type
     */
    private List<PostResponseDTO> sortList(List<PostResponseDTO> dtos, DateOrderType orderType) {
        return switch (orderType) {
            case DATE_ASC -> dtos.stream()
                    .sorted(Comparator.comparing(PostResponseDTO::getDate))
                    .toList();
            case DATE_DESC -> dtos.stream()
                    .sorted(Comparator.comparing(PostResponseDTO::getDate, Collections.reverseOrder()))
                    .toList();
            default -> dtos;
        };
    }

    /**
     * @param orderType String with the order
     * @return true if is valid order type else return false
     * Checks if the order type matches with the DateOrderType enum
     */
    private boolean isValidOrderType(String orderType) {
        return orderType == null || Arrays.stream(DateOrderType.values())
                .anyMatch(type -> type.name().equalsIgnoreCase(orderType));
    }

}
