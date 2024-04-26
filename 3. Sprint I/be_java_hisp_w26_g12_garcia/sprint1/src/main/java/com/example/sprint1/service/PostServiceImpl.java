package com.example.sprint1.service;

import com.example.sprint1.dto.CountDiscountPostsDto;
import com.example.sprint1.dto.DiscountPostDto;
import com.example.sprint1.dto.PostDto;
import com.example.sprint1.model.Post;
import com.example.sprint1.model.User;
import com.example.sprint1.repository.IPostRepository;
import com.example.sprint1.dto.PostForListDto;
import com.example.sprint1.exception.BadRequestException;
import com.example.sprint1.exception.NotFoundException;
import com.example.sprint1.repository.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {


    private static List<Post> posts = new ArrayList<>();

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private IUserRepository userRepository;

    /**
     * This method should be called when a new post submission is received. It handles validation,
     * conversion, and storage of the post data.
     * Adds a new post to the system after validating and converting the provided PostDto.
     * It checks for the existence of the post ID in the repository before saving to avoid duplicates.
     * @param postDto - The DTO containing all necessary data to create a post.
     * @return PostDto - Returns the PostDto after the post has been successfully added to the repository.
     * @throws IllegalArgumentException - If the postDto validation fails or if a post with the same ID already exists.
     */
    @Override
    public PostDto addPost(PostDto postDto) {
        validatePostDto(postDto); // Validates the necessary fields in the postDto
        Post post = convertDtoToEntity(postDto, false); // Converts postDto to a Post entity
        if (postRepository.findById(post.getId()) != null) {
            throw new IllegalArgumentException("A post with this ID already exists.");
        }
        postRepository.save(post); // Saves the post to the repository
        return postDto; // Returns the PostDto, could be enhanced with more data if needed
    }


    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(int id) {
        return null;
    }

    /**
     * This method is used internally by the addPost method to ensure all required data is valid
     * before proceeding with post creation.
     * @param postDto - The PostDto object containing the data to validate.
     * @throws IllegalArgumentException - If any validation fails.
     */
    private void validatePostDto(PostDto postDto) {
        if (postDto.getUser_id() == null || postDto.getProduct() == null) {
            throw new IllegalArgumentException("User ID and Product must not be null");
        }
        if (postDto.getPrice() < 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        try {
            LocalDate.parse(postDto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (Exception e) {
            throw new IllegalArgumentException("Date format is invalid, should be 'dd-MM-yyyy'");
        }
    }

    /**
     * This method is used internally by the addPost method to convert the DTO received from the API
     * into the entity model for the database.
     * Converts a PostDto to a Post entity. This includes mapping all necessary fields from the DTO to the entity.
     * @param postDto - The PostDto to be converted.
     * @return Post - The Post entity ready to be saved to the repository.
     */
    private Post convertDtoToEntity(PostDto postDto, Boolean promo) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setUser_id(postDto.getUser_id());
        post.setDate(postDto.getDate());
        post.setCategory(postDto.getCategory());
        post.setPrice(postDto.getPrice());
        post.setProduct(postDto.getProduct());
        post.setHas_promo(promo);  // Promotions and Discounts are handled separately
        post.setDiscount(0.0);
        return post;
    }

    // Method to obtain the list of followed posts of a user, sorted by date. REQ. US0006, US0009
    @Override
    public List<PostForListDto> followedList(Integer userId, String order) {
        // Retrieve the list of recent posts (Last two weeks) from the repository for the given user.
        List<Post> sortedList = postRepository.getResentPost(userId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Validations:
        // If the obtained list is empty (No existing user or No pub)
        if (sortedList.isEmpty()) {
            throw new NotFoundException("No se encontró ninguna publicación de las personas seguidas");
        }
        // Check the value of the 'order' parameter.
        List<Post> orderList;
        ObjectMapper mapper = new ObjectMapper();

        if (order == null || order.trim().isEmpty() || order.equals("date_desc")) {
            // If 'order' is null, empty, or "date_desc", sort the list by date in descending order.
             orderList = sortedList.stream()
                    .sorted(Comparator.comparing(post -> LocalDate.parse(((Post) post).getDate())).reversed())
                    .toList();
        } else if (order.equals("date_asc")) {
             orderList = sortedList.stream()
                    .sorted(Comparator.comparing(post -> LocalDate.parse(post.getDate(), formatter))).toList();
        } else {
            // If 'order' is neither "date_desc" nor "date_asc", it's an invalid value.
            throw new BadRequestException("Invalid sorting order: " + order);
        }
        return orderList.stream().map(post -> mapper.convertValue(post, PostForListDto.class)).collect(Collectors.toList());
    }

    /**
     * Calls postDto after checking that the product has a valid discount
     * @param postDto
     * @return postDto fetched from database
     */
    @Override
    public DiscountPostDto postPromo(PostDto postDto) {

        //Creation of mapper
        ObjectMapper mapper = new ObjectMapper();
        //validation
        validatePostDto(postDto);

        if(postRepository.findById(postDto.getId()) != null){
            throw new IllegalArgumentException("Post already in database");
        }

        //Convert to entity and save in datanase
        Post post = convertDtoToEntity(postDto, true);
        postRepository.save(post);

        //Assembly of dto
        DiscountPostDto discountPostDto = new DiscountPostDto(post.getId()
                , post.getUser_id()
                , post.getDate()
                , post.getCategory()
                , post.getPrice()
                , post.getProduct()
                , post.isHas_promo()
                , post.getDiscount());

        //Return mapped post fetched from database
        return discountPostDto;
    }

    /**
     * Search for discount post of given user_id
     * @param user_id
     * @return CountOfDiscountPostsDTO
     */
    @Override
    public CountDiscountPostsDto quantityPromo(Integer user_id) {

        User user = userRepository.findUserById(user_id);

        if(user == null){
            throw new BadRequestException("User not found");
        }

        List<Post> recentPost = postRepository.getResentPost(user_id);


        Long countOfPosts = recentPost.stream().filter(item -> item.getUser_id().equals(user_id)).filter(Post::isHas_promo).count();

        return new CountDiscountPostsDto(user.getId(), user.getUser_name(), countOfPosts);

    }

    @Override
    public Object getPromo(Integer user_id) {

        List<Post> postList = postRepository.getResentPost(user_id).stream().filter(Post::isHas_promo).toList();
        List<DiscountPostDto> discountPostDto = postList.stream().map(item -> new DiscountPostDto(item.getId()
                , item.getUser_id()
                , item.getDate()
                , item.getCategory()
                , item.getPrice()
                , item.getProduct()
                , item.isHas_promo()
                , item.getDiscount()))
                .toList();
        return discountPostDto;
    }
}
