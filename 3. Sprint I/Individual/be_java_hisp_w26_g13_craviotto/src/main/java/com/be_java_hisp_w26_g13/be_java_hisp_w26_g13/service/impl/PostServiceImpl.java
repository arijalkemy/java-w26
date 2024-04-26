package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service.impl;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.*;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.Post;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.User;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.exception.BadRequestException;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.exception.IncorrectDateException;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.exception.NotFoundException;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.IPostRepository;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.IProductRepository;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.IUserRepository;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service.IPostService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements IPostService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IProductRepository productRepository;

    @Autowired
    IPostRepository postRepository;

    private ObjectMapper getMapper() {
        return JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
                .build();
    }

    /**
     *  Creates a new post based on the provided PostDTO object. This method validates the incoming data,
     *  converts it into a Post entity, and persists it in the database. Various checks are performed during
     *  the creation process to ensure data integrity and consistency.
     *
     * @param postDTO The PostDTO object containing data for creating the post.
     * @return An ExceptionDto object indicating the status of the operation.
     * @throws BadRequestException   if the provided PostDTO is invalid.
     * @throws NotFoundException     if the user or product referenced in the post is not found.
     * @throws IncorrectDateException if the date in the post is before the current date.
     */
    @Override
    public ExceptionDto create(PostDTO postDTO){
        if(isBadRequestPostDto(postDTO)){ throw new BadRequestException("The request is invalid or missing required data."); }

        ObjectMapper mapper = getMapper();
        Post post = mapper.convertValue(postDTO, Post.class);

        validatePostRelationships(post);
        postRepository.create(post);
        User user = userRepository.findById(post.getUserId());
        user.getPosts().add(post);

        return new ExceptionDto("The post has been successfully created");
    }

    private void validatePromotionPost(PromoPostDTO promoPostDTO) {
        if (promoPostDTO.getDate() == null || promoPostDTO.getDate().isEmpty()) {
            throw new BadRequestException("The promotion post date is missing or invalid.");
        }
        if (promoPostDTO.getPrice() <= 0) {
            throw new BadRequestException("The promotion post price cannot be less than zero.");
        }
        if (promoPostDTO.getDiscount() >= 1 || promoPostDTO.getDiscount() <= 0) {
            throw new BadRequestException("The promotion post discount must be between 0 and 1.");
        }
        if (promoPostDTO.getCategory() <= 0) {
            throw new BadRequestException("The promotion post category must be greater than 0");
        }
        if (promoPostDTO.getUserId() < 0) {
            throw new BadRequestException("The promotion post user ID must be a positive integer.");
        }
        if (promoPostDTO.getProduct() == null || isBadRequestProductDto(promoPostDTO.getProduct())) {
            throw new BadRequestException("The product in the promotion post is invalid or missing required data.");
        }
        if (!promoPostDTO.isHasPromo()) {
            throw new BadRequestException("A promotion post must have a promotion.");
        }
    }

    private void validatePostRelationships(Post post) {
        if (userRepository.findById(post.getUserId()) == null) {
            throw new NotFoundException("User with id " + post.getUserId() + " does not exist.");
        }
        if (productRepository.findById(post.getProduct().getProductId()) == null) {
            throw new NotFoundException("Product with id " + post.getProduct().getProductId() + " does not exist.");
        }
        if (post.getDate().isBefore(LocalDate.now())) {
            throw  new IncorrectDateException("The provided date in the post is before the current date.");
        }
    }

    /**
     * Creates a promotion post from the promoPostDTO received. Performs validations regarding the
     * product in the post, which must exist and be valid, and other attributes. The user in the promoPostDTO
     * must exist, and the promo post must have a promotion with a valid discount amount.
     * @param promoPostDTO the promotion post to create.
     * @return a DTO containing a message stating the promo post creation, or throws an exception if
     * there was a validation issue.
     */
    @Override
    public ExceptionDto createWithPromotion(PromoPostDTO promoPostDTO) {
        validatePromotionPost(promoPostDTO);

        ObjectMapper mapper = getMapper();
        Post promoPost = mapper.convertValue(promoPostDTO, Post.class);

        validatePostRelationships(promoPost);
        postRepository.create(promoPost);
        User user = userRepository.findById(promoPost.getUserId());
        user.getPosts().add(promoPost);

        return new ExceptionDto("The post with promotion has been successfully created");
    }

    /**
     * Retrieves all the posts from the postRepository and returns them.
     * @return a list of PromoPostDTO, containing every single post in the database
     * @see PromoPostDTO
     */
    @Override
    public List<PromoPostDTO> getAll() {
        List<Post> posts = postRepository.getAll();
        ObjectMapper mapper = getMapper();
        List<PromoPostDTO> postDtoList = new ArrayList<>();
        posts.forEach(p -> postDtoList.add(mapper.convertValue(p, PromoPostDTO.class)));
        return postDtoList;
    }

    /**
     * Returns the amount of promotion posts the user with the received userId has.
     * @param userId the id of the user to return the promo post count from
     * @return a DTO containing the user id, username, and the amount of promotion posts the user has
     */
    @Override
    public UserPromoPostCountDTO retrieveUserPromoPostCount(Integer userId) {
        User user = userRepository.findById(userId);
        List<Post> userPromoPosts = findUserPromoPosts(userId);
        return new UserPromoPostCountDTO(userId, user.getUserName(), userPromoPosts.size());
    }

    private List<Post> findUserPromoPosts(Integer userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new BadRequestException("User with id " + userId + " does not exist.");
        }
        List<Post> userPosts = postRepository.getPostBy(userId);
        return userPosts.stream().filter(Post::isHasPromo).toList();
    }

    /**
     * Returns the list of promotion posts that the user with the received userId has published.
     * If the user has no promotion posts, returns an empty list.
     * @param userId id of the user to return the promo posts from
     * @return a DTO containing the user id, username and the user's promo post list
     * @see UserPromoPostsDTO
     */
    @Override
    public UserPromoPostsDTO retrieveUserPromoPostList(Integer userId) {
        User user = userRepository.findById(userId);
        List<Post> userPromoPosts = findUserPromoPosts(userId);
        List<PromoPostDTO> promoPostsDTO = new ArrayList<>();
        ObjectMapper mapper = getMapper();
        userPromoPosts.forEach(p -> promoPostsDTO.add(mapper.convertValue(p, PromoPostDTO.class)));

        return new UserPromoPostsDTO(userId, user.getUserName(), promoPostsDTO);
    }

    /**
     * Returns a list of the posts with the maximum discount amount. If there are
     * no promotion products, it returns every available post (discount = 0.0).
     * @return a list of the posts that have the maximum discount
     * @see PromoPostDTO
     */
    @Override
    public List<PromoPostDTO> retrievePostWithMaxDiscount() {
        List<Post> posts = postRepository.getMaxDiscountPosts();
        ObjectMapper mapper = getMapper();
        List<PromoPostDTO> maxDiscountPostsDto = new ArrayList<>();
        posts.forEach(p -> maxDiscountPostsDto.add(mapper.convertValue(p, PromoPostDTO.class)));
        return maxDiscountPostsDto;
    }

    private Boolean isBadRequestPostDto(PostDTO postDto){
        return postDto.getDate() == null || postDto.getDate().isEmpty() ||
                postDto.getPrice() <= 0 ||
                postDto.getCategory() <= 0 ||
                postDto.getUserId() <= 0 ||
                postDto.getProduct() == null || isBadRequestProductDto(postDto.getProduct());
    }

    private boolean isBadRequestProductDto(ProductDTO productDTO){
        return productDTO.getProductId() <= 0 ||
                productDTO.getProductName() == null || productDTO.getProductName().isEmpty() ||
                productDTO.getBrand() == null || productDTO.getBrand().isEmpty() ||
                productDTO.getNotes() == null || productDTO.getNotes().isEmpty() ||
                productDTO.getType() == null || productDTO.getType().isEmpty() ||
                productDTO.getColor() == null || productDTO.getColor().isEmpty();
    }
}
