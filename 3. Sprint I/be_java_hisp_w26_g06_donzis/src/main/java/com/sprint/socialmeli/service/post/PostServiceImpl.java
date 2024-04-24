package com.sprint.socialmeli.service.post;

import com.sprint.socialmeli.dto.post.*;
import com.sprint.socialmeli.dto.user.UserWithPromoPostsDTO;
import com.sprint.socialmeli.entity.*;
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
            Product product = buildProduct(postDTO);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(postDTO.getDate(), formatter);
            return new Post(product, date, postDTO.getCategory(), postDTO.getPrice());
        } catch (DateTimeException | IllegalArgumentException e) {
            throw new BadRequestException("Formato inválido " + e.getMessage());
        }
    }

    private static Product buildProduct(PostDTO postDTO) {
        return new Product(
                postDTO.getProduct().getProduct_id(),
                postDTO.getProduct().getProduct_name(),
                postDTO.getProduct().getType(),
                postDTO.getProduct().getColor(),
                postDTO.getProduct().getBrand(),
                postDTO.getProduct().getNotes()
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

    @Override
    public void createPromoPost(PromoPostRequestDTO post) {
        Seller seller = usersRepository.findSellerByPredicate(s -> s.getUser().getUserId().equals(post.getUser_id()))
                .stream().findFirst().orElse(null);
        if(seller == null){
            throw new NotFoundException("Seller with id: "+ post.getUser_id() +" does not exist");
        }
        if(post.getHas_promo()){
            try{
                PromoPost promoPost = new PromoPost(buildProduct(post),
                        LocalDate.parse(post.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        post.getCategory(),
                        post.getPrice(),
                        post.getDiscount());

                postRepository.save(promoPost, post.getUser_id());
            } catch (DateTimeException | IllegalArgumentException e) {
                throw new BadRequestException("Invalid format: " + e.getMessage());
            }
        } else {
            throw new BadRequestException("Promo post without promo is trying to be created.");
        }
    }

    @Override
    public UserWithPromoPostsDTO getPromoPostsBySeller(Integer userId) {
        Seller seller = usersRepository.findSellerByPredicate(s -> s.getUser().getUserId().equals(userId))
                .stream().findFirst().orElse(null);
        if(seller == null){
            throw new NotFoundException("Seller with id: "+ userId + " does not exist");
        }
        return new UserWithPromoPostsDTO(userId, seller.getUser().getUserName(),
                postRepository.findBySellerId(userId).stream().filter(post -> post instanceof PromoPost).count());
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

}
