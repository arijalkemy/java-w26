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
import com.sprint.socialmeli.utils.Parser;
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
    public void createPostWithPromo(PostPromoDTO promo) {
        boolean userNotFound = this.usersRepository
                .findSellerByPredicate(c -> c.getUser().getUserId().equals(promo.getUser_id()))
                .isEmpty();
        if (userNotFound) {
            throw new BadRequestException("Seller with id: " + promo.getUser_id() + " does not exist");
        } else {
            Post newPost = Parser.parsePostWithPromoDTO(promo);
            this.postRepository.save(newPost, promo.getUser_id());
        }
    }

    @Override
    public PromoCountResponseDTO getPromosCountById(Integer seller_id) {
        Seller seller = this.usersRepository
                .findSellerByPredicate(c -> c.getUser().getUserId().equals(seller_id)).stream().findFirst().orElse(null);

        if (seller == null) {
            throw new BadRequestException("Seller with id: " + seller_id + " does not exist");
        } else {
            Integer counter = 0;
            List<Post> posts = postRepository.findBySellerId(seller_id);
            if (!posts.isEmpty()) {
                counter = (int) posts.stream().filter(Post::isHasPromo).count();
            }
            return new PromoCountResponseDTO(counter, seller.getUser().getUserName(), seller_id);
        }
    }

    @Override
    public List<PromoListResponseDTO> getPromosListById(Integer seller_id) {
        Seller seller = this.usersRepository
                .findSellerByPredicate(c -> c.getUser().getUserId().equals(seller_id)).stream().findFirst().orElse(null);

        if (seller == null) {
            throw new BadRequestException("Seller with id: " + seller_id + " does not exist");
        } else {

            List<Post> posts = postRepository.findBySellerId(seller_id);

            return posts.stream().filter(Post::isHasPromo).map(p -> {
                Product pr = p.getProduct();
                return new PromoListResponseDTO(seller_id, p.getPostDate().toString(),
                        new ProductDTO(pr.getId(), pr.getName(), pr.getType(), pr.getBrand(), pr.getColor(), pr.getNotes()),
                        p.getCategory(), p.getPrice(), p.isHasPromo(), p.getDiscount());
            }).toList();

        }
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
