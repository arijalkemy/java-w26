package com.sprint.socialmeli.service.post;

import com.sprint.socialmeli.dto.post.*;
import com.sprint.socialmeli.entity.Customer;
import com.sprint.socialmeli.entity.Post;
import com.sprint.socialmeli.entity.Product;
import com.sprint.socialmeli.entity.Seller;
import com.sprint.socialmeli.exception.BadRequestException;
import com.sprint.socialmeli.exception.NotFoundException;
import com.sprint.socialmeli.repository.post.IPostRepository;
import com.sprint.socialmeli.repository.user.IUsersRepository;
import com.sprint.socialmeli.utils.DateOrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSException;

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

    @Override
    public Integer createPost(PostDTO postDTO) {
        boolean userNotFound = this.usersRepository
                .findSellerByPredicate(c -> c.getUser().getUserId().equals(postDTO.getUser_id()))
                .isEmpty();
        if (userNotFound) {
            throw new BadRequestException("Seller with id: " + postDTO.getUser_id() + " does not exist");
        } else {
            Post newPost = parsePostDTO(postDTO);
            this.postRepository.save(newPost, postDTO.getUser_id());
            return newPost.getId();
        }
    }

    @Override
    public void createPromoPost(PromoPostRequestDTO post) {
        Integer postId = this.createPost(post);
        if (post.getHas_promo()) {
            this.postRepository.saveDiscountByPostId(postId, post.getDiscount());
        }
    }

    // INDIVIDUAL
    @Override
    public PromoCountResponseDTO getPromoCountBySellerId(Integer sellerId) {
        PromoListResponseDTO aux = this.getPromoPostListBySellerId(sellerId);

        return new PromoCountResponseDTO(
                aux.getUser_id(),
                aux.getUser_name(),
                aux.getPosts().size()
        );

    }

    // BONUS
    @Override
    public PromoListResponseDTO getPromoPostListBySellerId(Integer sellerId) {
        Seller seller = findSellerById(sellerId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<PromoPostResponseDTO> posts = this.postRepository
                .findBySellerId(sellerId)
                .stream().filter(p -> this.postRepository.getPromoPostMap().get(p.getId()) != null)
                .map(p ->  new PromoPostResponseDTO(
                                sellerId,
                                p.getId(),
                                formatter.format(p.getPostDate()),
                                new ProductDTO(p.getProduct().getId(),
                                        p.getProduct().getName(),
                                        p.getProduct().getType(),
                                        p.getProduct().getBrand(),
                                        p.getProduct().getColor(),
                                        p.getProduct().getNotes()
                                ),
                                p.getCategory(),
                                p.getPrice(),
                                true,
                                this.postRepository.getPromoPostMap().get(p.getId())
                        )
                )
                .toList();

        return new PromoListResponseDTO(
                seller.getUser().getUserId(),
                seller.getUser().getUserName(),
                posts
        );

    }

    @Override
    public FollowedProductsResponseDTO getFollowedProductsList(Integer customer_id, String order){
        List<Customer> customers = usersRepository
                .findCustomerByPredicate(c -> c.getUser().getUserId().equals(customer_id));

        if (customers.isEmpty()) {
            throw new NotFoundException("Customer with ID: " + customer_id + " not found");
        }

        if(!isValidOrderType(order)){
            throw new BadRequestException("Invalid order type: " + order);
        }

        List<PostResponseDTO> postResponseDTOList = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate now = LocalDate.now();
        LocalDate weekPoint = now.minusWeeks(2);
        for (Integer sellerId : customers.get(0).getFollowed()) {
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

    // -------------

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

    private boolean isValidOrderType(String orderType) {
        return orderType == null || Arrays.stream(DateOrderType.values())
                .anyMatch(type -> type.name().equalsIgnoreCase(orderType));
    }

    // INDIVIDUAL
    private Seller findSellerById(Integer sellerId) {
        return this.usersRepository
                .findSellerByPredicate(c -> c.getUser().getUserId().equals(sellerId))
                .stream().findFirst()
                .orElseThrow(() -> new NotFoundException("Seller with ID: " + sellerId + " not found"));
    }

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

}
