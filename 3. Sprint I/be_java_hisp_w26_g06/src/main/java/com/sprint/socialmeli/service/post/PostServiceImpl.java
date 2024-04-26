package com.sprint.socialmeli.service.post;

import com.sprint.socialmeli.dto.post.FollowedProductsResponseDTO;
import com.sprint.socialmeli.dto.post.PostDTO;
import com.sprint.socialmeli.dto.post.PostResponseDTO;
import com.sprint.socialmeli.dto.post.ProductDTO;
import com.sprint.socialmeli.entity.Customer;
import com.sprint.socialmeli.entity.Post;
import com.sprint.socialmeli.entity.Product;
import com.sprint.socialmeli.exception.BadRequestException;
import com.sprint.socialmeli.exception.NotFoundException;
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
    public void createPost(PostDTO postDTO) {
        UserChecker.checkAndGetSeller(postDTO.getUser_id());
        Post newPost = parsePostDTO(postDTO);
        this.postRepository.save(newPost, postDTO.getUser_id());
    }

    /**
     *
     * @param postDTO A DTO with the post information
     * @return the post entity
     * @throws BadRequestException if the format is not valid
     * Maps a post dto to post entity
     */
    private static Post parsePostDTO(PostDTO postDTO) {
        try {
            Product product = new Product(
                    postDTO.getProduct().getProduct_id(),
                    postDTO.getProduct().getProduct_name(),
                    postDTO.getProduct().getType(),
                    postDTO.getProduct().getColor(),
                    postDTO.getProduct().getBrand(),
                    postDTO.getProduct().getNotes()
            );
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(postDTO.getDate(), formatter);
            return new Post(product, date, postDTO.getCategory(), postDTO.getPrice());
        } catch (DateTimeException | IllegalArgumentException e) {
            throw new BadRequestException("Formato inválido " + e.getMessage());
        }
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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


        LocalDate now = LocalDate.now();
        LocalDate weekPoint = now.minusWeeks(2);
        for (Integer sellerId : customer.getFollowed()) {
            postResponseDTOList.addAll(postRepository.findBySellerId(sellerId)
                    .stream()
                    .filter(post -> post.getPostDate().isAfter(weekPoint))
                    .map(p -> new PostResponseDTO(
                            sellerId,
                            p.getId(),
                            formatter.format(p.getPostDate()),
                            new ProductDTO(
                                    p.getProduct().getId(),
                                    p.getProduct().getName(),
                                    p.getProduct().getType(),
                                    p.getProduct().getBrand(),
                                    p.getProduct().getColor(),
                                    p.getProduct().getNotes()),
                            p.getCategory(),
                            p.getPrice())).toList());
        }

        if (order != null){
            DateOrderType orderType = DateOrderType.valueOf(order.toUpperCase());
            postResponseDTOList = sortList(postResponseDTOList, orderType);
        }

        return new FollowedProductsResponseDTO(customer_id, postResponseDTOList);
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
