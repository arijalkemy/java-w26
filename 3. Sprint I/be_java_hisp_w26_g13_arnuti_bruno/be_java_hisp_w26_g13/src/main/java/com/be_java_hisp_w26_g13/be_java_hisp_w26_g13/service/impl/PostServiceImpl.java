package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service.impl;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.*;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.Post;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.User;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.exception.BadRequestException;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.exception.IncorrectDateException;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.exception.InvalidOperation;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.exception.NotFoundException;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.IPostRepository;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.IProductRepository;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.IUserRepository;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service.IPostService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {

    @Autowired
    IUserRepository userRepository;
    @Autowired
    IProductRepository productRepository;
    @Autowired
    IPostRepository postRepository;
    @Autowired
    private ProductServiceImpl productServiceImpl;


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

        Post post = convertToEntity(postDTO);

        User user = userRepository.findById(post.getUserId());

        validatePost(post, postDTO, user);

        user.getPosts().add(post);
        
        postRepository.create(post);
        return new ExceptionDto("The post has been successfully created");
    }

    /**
     *  Creates a new promotional post based on the provided PostDTO object. This method validates the incoming data,
     *  converts it into a Post entity, and persists it in the database.
     *
     * @param promoPostDto The PostDTO object containing data for creating the promotional post.
     * @return An ExceptionDto object indicating the status of the operation.
     * @throws BadRequestException   if the provided PostDTO is invalid.
     * @throws NotFoundException     if the user or product referenced in the post is not found.
     * @throws IncorrectDateException if the date in the post is before the current date.
     */
    @Override
    public ExceptionDto createPromo(PromoPostDTO promoPostDto) {

        Post promoPost = convertToEntity(promoPostDto);

        User user = userRepository.findById(promoPost.getUserId());

        validatePost(promoPost, promoPostDto, user);

        user.getPosts().add(promoPost);
        postRepository.create(promoPost);
        return new ExceptionDto("The promotional post has been successfully created");
    }

    /**
     * Retrieves the count of promotional posts for a specific user identified by {@code userId}.
     * This method first verifies whether the user exists and whether the user is a vendor with promotional posts.
     * It then calculates the number of posts that are marked as promotional for the specified user.
     *
     * @param userId The ID of the user for whom promotional post count is requested.
     * @return A {@link PromoPostCountDTO} object containing the user ID, username, and the count of promotional posts.
     * @throws NotFoundException if no user is found with the specified {@code userId}.
     * @throws InvalidOperation if the identified user is not a vendor (i.e., users without posts are not considered vendors).
     */
    @Override
    public PromoPostCountDTO getPromoProductCount(int userId) {
        User user = userRepository.findById(userId);

        if (user == null) {
            throw new NotFoundException("User with id " + userId + " does not exist");
        }

        if(!user.isVendor()){
            throw new InvalidOperation("User with id " + userId + " is not a vendor user, non-vendor users do not have posts");
        }

        PromoPostCountDTO dto = new PromoPostCountDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        dto.setPromoProductsCount((int) user.getPosts().stream().filter(Post::isHas_promo).count());

        return dto;
    }

    /**
     * Retrieves all promotional posts and sorts them by discount in descending order.
     * The method fetches all posts, filters to include only those with promotions,
     * sorts them based on the discount value, maps them to {@link PromoPostDTO},
     * and collects the results into a list.
     *
     * @return a list of {@link PromoPostDTO} representing promotional posts sorted by discount.
     */
    @Override
    public List<PostDTO> getAllPromoPostsSortedByDiscountDesc() {
        return postRepository.getAll().stream()
                .filter(Post::isHas_promo)
                .sorted(Comparator.comparing(Post::getDiscount).reversed())
                .map(post -> new PromoPostDTO(
                        post.getPostId(),
                        post.getUserId(),
                        post.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), // Assuming the date needs to be formatted
                        productServiceImpl.convertToProductDTO(post.getProduct()),
                        post.getCategory(),
                        post.getPrice(),
                        post.isHas_promo(),
                        post.getDiscount()
                ))
                .collect(Collectors.toList());
    }

    /**
     * Sets a new discount for a post, turning it into a promotional post if it wasn't already.
     * Validates the provided discount value and updates the post accordingly.
     * Throws an exception if the post doesn't exist or if the discount is invalid.
     *
     * @param postId The ID of the post to update.
     * @param discount The new discount value to set, must be between 0 and 1.
     * @return an {@link ExceptionDto} indicating the success of the operation.
     * @throws NotFoundException if no post with the given ID exists.
     * @throws BadRequestException if the discount is outside the valid range.
     */
    @Override
    public ExceptionDto setDiscountToPost(Integer postId, double discount) {
        Post post = postRepository.getPostById(postId);

        if(post == null){
            throw new NotFoundException("Post with id " + postId + " does not exist");
        }

        if(!validateDiscount(discount)){
            throw new BadRequestException("Discount must be between 0 and 1.");
        }

        post.setDiscount(discount);
        post.setHas_promo(true);

        return new ExceptionDto("The post is now on discount!");
    }

    /**
     * Removes the discount from a post, effectively turning it off as a promotional post.
     * Throws an exception if the post doesn't exist.
     *
     * @param postId The ID of the post to update.
     * @return an {@link ExceptionDto} indicating that the discount has been removed.
     * @throws NotFoundException if no post with the given ID exists.
     */
    @Override
    public ExceptionDto removeDiscountToPost(Integer postId) {
        Post post = postRepository.getPostById(postId);

        if(post == null){
            throw new NotFoundException("Post with id " + postId + " does not exist");
        }

        post.setDiscount(0.0);
        post.setHas_promo(false);

        return new ExceptionDto("The post is no longer on discount!");
    }

    private Post convertToEntity(PostDTO postDTO) {
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        return mapper.convertValue(postDTO, Post.class);
    }

    private void validatePost(Post post, PostDTO postDTO, User user) {

        if (isBadRequestPostDto(postDTO)) {
            throw new BadRequestException("The request is invalid or missing required data.");
        }

        if (user == null) {
            throw new NotFoundException("User with id " + post.getUserId() + " does not exist.");
        }
        if (productRepository.findById(post.getProduct().getProductId()) == null) {
            throw new NotFoundException("Product with id " + post.getProduct().getProductId() + " does not exist.");
        }
        if (post.getDate().isBefore(LocalDate.now())) {
            throw new IncorrectDateException("The provided date in the post is before the current date.");
        }
        if (!post.isHas_promo() || validateDiscount(post.getDiscount())) {
            throw new BadRequestException("Discount must be between 0 and 1 and has_promo has to be set to true.");
        }
    }

    private boolean validateDiscount(double discount) {
        return discount >= 0 && discount <= 1;
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
