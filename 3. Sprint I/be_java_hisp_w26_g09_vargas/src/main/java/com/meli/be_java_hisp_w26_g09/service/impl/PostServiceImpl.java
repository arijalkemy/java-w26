package com.meli.be_java_hisp_w26_g09.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.be_java_hisp_w26_g09.dto.*;
import com.meli.be_java_hisp_w26_g09.entity.Post;
import com.meli.be_java_hisp_w26_g09.entity.Role;
import com.meli.be_java_hisp_w26_g09.entity.User;
import com.meli.be_java_hisp_w26_g09.exception.BadRequestException;
import com.meli.be_java_hisp_w26_g09.exception.NotFoundException;
import com.meli.be_java_hisp_w26_g09.repository.IPostRepository;
import com.meli.be_java_hisp_w26_g09.repository.IProductRepository;
import com.meli.be_java_hisp_w26_g09.repository.IUserRepository;
import com.meli.be_java_hisp_w26_g09.service.IPostService;
import com.meli.be_java_hisp_w26_g09.util.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    IProductRepository productRepository;
    @Autowired
    IPostRepository postRepository;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    PostMapper postMapper;


    @Override
    public ResponseDTO addPost(PostDTO post) {
        if (post.getPrice() < 0)
            throw new BadRequestException("The price cannot be negative");

        post.setHasPromo(false);
        if (post.getDiscount() != null && post.getDiscount() != 0.0)
            throw new BadRequestException("Cannot add a promo post on this end point");

        post.setDiscount(0.0);

        if (validate(post))
            throw new BadRequestException("No field can be null");

        Optional<User> user = userRepository.findById(post.getUserId());
        if (user.isEmpty())
            throw new BadRequestException("The user_id does not exist ");

        if (user.get().getRole() == null || user.get().getRole().getIdRole().equals(Role.ID_CUSTOMER))
            throw new BadRequestException("The customer can't create posts ");

        Post postEntity = postMapper.postDTOtoPost(post);
        if (!productRepository.isCreated(postEntity.getProduct()))
            productRepository.createProduct(postEntity.getProduct());

        postRepository.createPost(postEntity);
        return new ResponseDTO("Post has been created");
    }

    @Override
    public ResponseDTO addPostPromo(PostDTO postPromo) {

        if (!(postPromo.getDiscount() > 0.0))
            throw new BadRequestException("Discount should be a positive number.");

        Optional<User> seller = userRepository.findById(postPromo.getUserId());

        if (seller.isEmpty())
            throw new BadRequestException("The user_id does not exist.");

        if (seller.get().getRole().getIdRole().equals(Role.ID_CUSTOMER))
            throw new BadRequestException("The customer can't create posts ");

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        Post post = mapper.convertValue(postPromo, Post.class);

        if (!productRepository.isCreated(post.getProduct()))
            productRepository.createProduct(post.getProduct());

        postRepository.createPost(post);
        return new ResponseDTO("Post with promo has ben created.");
    }

    @Override
    public CountPromosBySellerDTO getCountPromosBySeller(Integer idSeller) {

        Optional<User> optionalUser = userRepository.findById(idSeller);
        if (optionalUser.isEmpty())
            throw new BadRequestException("The user_id does not exist.");

        User seller = optionalUser.get();

        if (seller.getRole().getIdRole().equals(Role.ID_CUSTOMER))
            throw new BadRequestException("The customer has not Posts.");

        List<Post> post = postRepository.filterBySeller(idSeller, true);

        return new CountPromosBySellerDTO(idSeller, seller.getUserName(), post.size());
    }

    @Override
    public PromosBySellerDTO getListPromosBySeller(Integer idSeller) {

        Optional<User> optionalUser = userRepository.findById(idSeller);

        if (optionalUser.isEmpty())
            throw new BadRequestException("The user_id does not exist.");

        User seller = optionalUser.get();

        if (seller.getRole().getIdRole().equals(Role.ID_CUSTOMER))
            throw new BadRequestException("The customer has not Posts.");

        List<Post> post = postRepository.filterBySeller(idSeller, true);

        return new PromosBySellerDTO(idSeller, seller.getUserName(), post);
    }

    @Override
    public ProductFollowedListDTO findFollowedPostsLastTwoWeeks(int userID) {
        Optional<User> user = userRepository.findById(userID);
        if (user.isEmpty()) throw new NotFoundException("The user was not found");
        if (user.get().getFollowed() == null) throw new NotFoundException("The user don't follow no seller");
        List<Post> posts = postRepository.findAll();
        List<Post> followedPosts = new ArrayList<>();
        user.get().getFollowed().forEach(seller -> followedPosts.addAll(posts.stream()
                .filter(post -> post.getUserId().equals(seller.getUserId()))
                .toList()));

        LocalDate twoWeegksAgo = LocalDate.now().minusWeeks(2);

        List<Post> followedPostsLastTwoWeeks = followedPosts.stream()
                .filter(post -> twoWeegksAgo.isBefore(post.getDate())).toList()
                .stream().sorted(Comparator.comparing(Post::getDate).reversed()).toList();

        ProductFollowedListDTO productFollowedListDTO = new ProductFollowedListDTO();
        productFollowedListDTO.setUserId(user.get().getUserId());
        productFollowedListDTO.setPosts(postMapper.postListToPostForListDTOS(followedPostsLastTwoWeeks));
        return productFollowedListDTO;
    }

    @Override
    public ProductFollowedListDTO findFollowedPostsLastTwoWeeksSorted(int userID, String order) {
        ProductFollowedListDTO productFollowedListDTOSorted = findFollowedPostsLastTwoWeeks(userID);

        if (!("date_asc".equalsIgnoreCase(order) || "date_desc".equalsIgnoreCase(order)))
            throw new BadRequestException("Invalid order parameter. Valid values are 'date_asc' or 'date_desc'.");

        if ("date_asc".equalsIgnoreCase(order)) {
            productFollowedListDTOSorted.setPosts(productFollowedListDTOSorted.getPosts()
                    .stream()
                    .sorted(Comparator.comparing(PostForListDTO::getDate))
                    .collect(Collectors.toList()));
        }
        return productFollowedListDTOSorted;
    }


    private boolean validate(PostDTO post) {
        return Stream.of(post.getUserId(),
                post.getDate(),
                post.getProduct(),
                post.getCategory(),
                post.getPrice()).anyMatch(Objects::isNull);
    }
}
