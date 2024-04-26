package com.sprint.socialmeli.service.post;

import com.sprint.socialmeli.dto.post.*;
import com.sprint.socialmeli.entity.Customer;
import com.sprint.socialmeli.entity.Post;
import com.sprint.socialmeli.entity.Seller;
import com.sprint.socialmeli.exception.BadRequestException;
import com.sprint.socialmeli.exception.NotFoundException;
import com.sprint.socialmeli.repository.post.IPostRepository;
import com.sprint.socialmeli.repository.user.IUsersRepository;
import com.sprint.socialmeli.utils.DateOrderType;
import com.sprint.socialmeli.utils.Parser;
import com.sprint.socialmeli.utils.UserChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if (userNotFound) {
            throw new BadRequestException("Seller with id: " + postDTO.getUser_id() + " does not exist");
        } else {
            Post newPost = Parser.parsePostDTO(postDTO);
            this.postRepository.save(newPost, postDTO.getUser_id());
        }
    }

    @Override
    public FollowedProductsResponseDTO getFollowedProductsList(Integer customer_id, String order) {
        List<Customer> customers = usersRepository
                .findCustomerByPredicate(c -> c.getUser().getUserId().equals(customer_id));

        if (customers.isEmpty()) {
            throw new NotFoundException("Customer with ID: " + customer_id + " not found");
        }

        if (!isValidOrderType(order)) {
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

        if (order != null) {
            DateOrderType orderType = DateOrderType.valueOf(order.toUpperCase());
            postResponseDTOList = sortList(postResponseDTOList, orderType);
        }

        return new FollowedProductsResponseDTO(customer_id, postResponseDTOList);
    }

    @Override
    public NewPromoDTO createPostWithPromo(PromoPostDTO promo) {
        UserChecker.checkAndGetSeller(promo.getUser_id());

        Post newPost = Parser.parsePostWithPromoDTO(promo);
        this.postRepository.save(newPost, promo.getUser_id());
        return new NewPromoDTO(newPost.getId());
    }

    @Override
    public PromoCountResponseDTO getPromosCountById(Integer seller_id) {
        Seller seller = UserChecker.checkAndGetSeller(seller_id);

        int counter = 0;
        List<Post> posts = postRepository.findBySellerId(seller_id);
        if (!posts.isEmpty()) {
            counter = (int) posts.stream().filter(Post::isHasPromo).count();
        }
        return Parser.parsePromoCountDto(seller, counter);
    }

    @Override
    public PromoListDTO getPromosListById(Integer seller_id) {
        Seller seller = UserChecker.checkAndGetSeller(seller_id);

        List<Post> posts = postRepository.findBySellerId(seller_id);

        List<PromoResponseDTO> promos = posts.stream().filter(Post::isHasPromo).map(p ->
                Parser.parsePromoResponseDTO(seller_id, p)
        ).toList();

        return Parser.parsePromoListDTO(promos, seller);
    }

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

    private boolean isValidOrderType(String orderType) {
        return orderType == null || Arrays.stream(DateOrderType.values())
                .anyMatch(type -> type.name().equalsIgnoreCase(orderType));
    }

}
