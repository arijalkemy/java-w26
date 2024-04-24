package com.sprint.socialmeli.service.post;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    public void createPost(PostDTO postDTO) {
        boolean userNotFound = this.usersRepository
                .findSellerByPredicate(c -> c.getUser().getUserId().equals(postDTO.getUser_id()))
                .isEmpty();
        if(userNotFound){
            throw new BadRequestException("Seller with id: "+ postDTO.getUser_id() +" does not exist");
        } else{
            Post newPost = parsePostDTO(postDTO);
            this.postRepository.save(newPost, postDTO.getUser_id());
        }
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

            return new Post(product, formatDate(postDTO.getDate()), postDTO.getCategory(), postDTO.getPrice());
        } catch (DateTimeException | IllegalArgumentException e) {
            throw new BadRequestException("Formato inválido " + e.getMessage());
        }
    }

    private static LocalDate formatDate(String postDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(postDate, formatter);
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
                            mapProductToDto(p.getProduct()),
                            p.getCategory(),
                            p.getPrice())).toList());
        }

        if (order != null){
            DateOrderType orderType = DateOrderType.valueOf(order.toUpperCase());
            postResponseDTOList = sortList(postResponseDTOList, orderType);
        }

        return new FollowedProductsResponseDTO(customer_id, postResponseDTOList);
    }

    // US00010. INDIVIDUAL
    @Override
    public void createPromoPost(PostPromoRequestDTO postPromo) {
        Seller seller = findSellerOrThrowError(postPromo.getUser_id());

        Post post = new Post(
                mapProductToEntity(postPromo.getProduct()),
                formatDate(postPromo.getDate()),
                postPromo.getCategory(),
                postPromo.getPrice()
        );

        post.setHas_promo(true);
        post.setDiscount(postPromo.get_discount());

        postRepository.save(post, seller.getUser().getUserId());

    }

    // US00011. INDIVIDUAL
    @Override
    public PostPromoCountResponseDTO getPostPromoCount(int userId) {

        Seller seller = findSellerOrThrowError(userId);

        PostPromoCountResponseDTO postPromoCountResponseDTO = new PostPromoCountResponseDTO(
                seller.getUser().getUserId(),
                seller.getUser().getUserName(),
                postRepository.findPromoBySellerId(userId).size()
        );

        return postPromoCountResponseDTO;
    }

    // US00012. INDIVIDUAL BONUS
    @Override
    public PostPromoListResponseDTO getPostPromoList(int userId) {
        Seller seller = findSellerOrThrowError(userId);


        List<PostPromoDTO> postPromoDtos = postRepository.findPromoBySellerId(userId)
                .stream().map(p -> mapPostToPostPromoDto(p, userId)).toList();

        PostPromoListResponseDTO postPromoListResponseDTO = new PostPromoListResponseDTO(
                seller.getUser().getUserId(),
                seller.getUser().getUserName(),
                postPromoDtos
        );

        return postPromoListResponseDTO;
    }

    private Seller findSellerOrThrowError(int userId) {
        return usersRepository
                .findSellerByPredicate(s -> s.getUser().getUserId().equals(userId))
                .stream()
                .findFirst()
                .orElseThrow(() -> new BadRequestException(
                        "Seller with id: "+ userId +" does not exist")
                );
    }

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

    private static Product mapProductToEntity(ProductDTO productDTO){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(productDTO, Product.class);
    }

    private static ProductDTO mapProductToDto(Product product){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(product, ProductDTO.class);
    }

    private static PostPromoDTO mapPostToPostPromoDto(Post post, int userId){
        return new PostPromoDTO(
                userId,
                post.getId(),
                post.getPostDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                mapProductToDto(post.getProduct()),
                post.getCategory(),
                post.getPrice(),
                post.isHas_promo(),
                post.getDiscount()
        );
    }

}
