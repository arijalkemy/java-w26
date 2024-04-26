package com.sprint.socialmeli.service.post;

import com.sprint.socialmeli.dto.post.*;
import com.sprint.socialmeli.entity.Customer;
import com.sprint.socialmeli.entity.Post;
import com.sprint.socialmeli.entity.Seller;
import com.sprint.socialmeli.entity.User;
import com.sprint.socialmeli.exception.BadRequestException;
import com.sprint.socialmeli.exception.NotFoundException;
import com.sprint.socialmeli.mappers.PostMapper;
import com.sprint.socialmeli.repository.post.IPostRepository;
import com.sprint.socialmeli.repository.user.IUsersRepository;
import com.sprint.socialmeli.utils.DateOrderType;
import com.sprint.socialmeli.utils.UserChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;

import static com.sprint.socialmeli.mappers.PostMapper.*;

@Service
public class PostServiceImpl implements IPostService {

    @Autowired
    IPostRepository postRepository;

    @Autowired
    IUsersRepository usersRepository;

    /**
     * @param postDTO A DTO with the post to create
     * @throws BadRequestException if the seller id of the post not exists
     * Checks if the seller exists and calls the post repository to save the new post
     */
    @Override
    public Integer createPost(PostDTO postDTO) {
        UserChecker.checkAndGetSeller(postDTO.getUser_id());
        Post newPost = PostMapper.mapToEntity(postDTO);
        this.postRepository.save(newPost, postDTO.getUser_id());

        return newPost.getId();
    }


    /**
     *
     * @param customer_id customer id
     * @param order Optional String to order the posts by date (date_asc, date_desc)
     * @return A DTO with the list of posts of the followed sellers
     * @throws NotFoundException if Customer not exists
     * @throws BadRequestException if the order type is not empty and not valid
     */
    @Override
    public FollowedProductsResponseDTO getFollowedProductsList(Integer customer_id, String order){
        Customer customer = UserChecker.checkAndGetCustomer(customer_id);

        if(!isValidOrderType(order)){
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

        if (order != null){
            DateOrderType orderType = DateOrderType.valueOf(order.toUpperCase());
            postResponseDTOList = sortList(postResponseDTOList, orderType);
        }

        return new FollowedProductsResponseDTO(customer_id, postResponseDTOList);
    }


    // US00010. INDIVIDUAL

    /***
     *
     * @param postPromo a Dto with the post promo data to create
     * @return an integer with the id created
     */
    @Override
    public Integer createPromoPost(PostPromoRequestDTO postPromo) {

        Seller seller = UserChecker.checkAndGetSeller(postPromo.getUser_id());

        Post post = PostMapper.mapPromoPostRequestToPost(postPromo);

        postRepository.save(post, seller.getUser().getUserId());

        return post.getId();

    }

    // US00011. INDIVIDUAL
    /***
     *
     * @param sellerId
     * @return a Dto with the seller id, name and a count of promo posts
     */
    @Override
    public PostPromoCountResponseDTO getPostPromoCount(int sellerId) {

        Seller seller = UserChecker.checkAndGetSeller(sellerId);

        int countOfPromoPosts = postRepository.findPromoPostsBySellerId(sellerId).size();

        return createPostPromoCountDto(seller, countOfPromoPosts);
    }

    // US00012. INDIVIDUAL BONUS

    /***
     *
     * @param sellerId
     * @return a Dto with the seller id, name and a list of promo posts
     */
    @Override
    public PostPromoListResponseDTO getPostPromoList(int sellerId) {

        Seller seller = UserChecker.checkAndGetSeller(sellerId);

        List<PostPromoDTO> postPromosDto = postRepository.findPromoPostsBySellerId(sellerId)
                .stream().map(p -> mapPostToPostPromoDto(p, sellerId)).toList();

        return createPostPromoListDto(seller, postPromosDto);
    }

    /**
     *
     * @param dtos list of dto to order
     * @param orderType enum (date_asc, date_desc)
     * @return A sorted list of dto according to the order type
     */
    private List<PostResponseDTO> sortList(List<PostResponseDTO> dtos, DateOrderType orderType){
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
     *
     * @param orderType String with the order
     * @return true if is valid order type else return false
     * Checks if the order type matches with the DateOrderType enum
     */
    private boolean isValidOrderType(String orderType) {
        return orderType == null || Arrays.stream(DateOrderType.values())
                .anyMatch(type -> type.name().equalsIgnoreCase(orderType));
    }

}
