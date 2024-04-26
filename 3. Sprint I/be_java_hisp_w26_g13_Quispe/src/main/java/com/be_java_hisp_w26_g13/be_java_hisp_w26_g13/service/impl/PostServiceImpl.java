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
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IProductRepository productRepository;

    @Autowired
    IPostRepository postRepository;


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

        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
                .build();
        Post post = mapper.convertValue(postDTO, Post.class);
        User user = userRepository.findById(post.getUserId());

        if(user == null){
            throw new NotFoundException("User with id " + post.getUserId() + " does not exist.");
        } if(productRepository.findById(post.getProduct().getProductId()) == null){
            throw new NotFoundException("Product with id " + post.getProduct().getProductId() + " does not exist.");
        } if(post.getDate().isBefore(LocalDate.now())){
            throw  new IncorrectDateException("The provided date in the post is before the current date.");
        }

        postRepository.create(post);
        user.getPosts().add(post);
        return new ExceptionDto("The post has been successfully created");
    }

    @Override
    public PostPromoDTO createPromoPost(PostPromoDTO postPromoDTO) {

        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();

        Post post = mapper.convertValue(postPromoDTO, Post.class);

        User foundSeller = userRepository.findById(postPromoDTO.getUserId());

        if (foundSeller == null) {
            throw new NotFoundException("User with id " + foundSeller.getUserId() + " does not exist.");
        }
        if(isBadRequestPostDto(postPromoDTO)){
            throw new BadRequestException("The request is invalid or missing required data.");
        }

        Optional<Post> postProductId = foundSeller.getPosts().stream()
                .filter(p -> p.getProduct().getProductId() == (postPromoDTO.getProduct().getProductId()) && p.isHasPromo())
                .findFirst();

        if (postProductId.isPresent()) {
            throw new NotFoundException("The product already has a promo post");
        }

        if(postPromoDTO.isHasPromo()){
            if (postPromoDTO.getDiscount() <= 0 || postPromoDTO.getDiscount() >= 100) {
                throw new BadRequestException("The discount must be greater than 0 and less than 100.");
            }
        }

        postRepository.create(post);
        foundSeller.getPosts().add(post);
        return postPromoDTO;
    }

    @Override
    public ResponsePromoPostDTO getPromoPostCount(int userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new NotFoundException("User with id " + userId + " does not exist.");
        }
        int count = 0;
        for (Post post : user.getPosts()) {
            if (post.isHasPromo()) {
                count++;
            }
        }
        return new ResponsePromoPostDTO(user.getUserId(), user.getUserName(), count);
    }

    @Override
    public List<PostPromoDTO> getPostByUser(int userId, String month, String year) {
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        User user = userRepository.findById(userId);

        if (user == null) {
            throw new NotFoundException("User with id " + userId + " does not exist.");
        }
        if(month == null && year == null){
            throw new BadRequestException("The request is invalid or missing required data.");
        }
        if(Integer.parseInt(month) < 1 || Integer.parseInt(month) > 12){
            throw new BadRequestException("The month must be between 1 and 12.");
        }
        if(Integer.parseInt(year) < 0){
            throw new BadRequestException("The year must be greater than 0.");
        }
        if (year.length() != 4) {
            throw new BadRequestException("The year must have 4 digits.");
        }
        List<Post> posts = user.getPosts();
        List<Post> postFilter = posts.stream().filter(post -> post.getDate().getMonthValue() == Integer.parseInt(month) && post.getDate().getYear() == Integer.parseInt(year)).toList();
        List<PostPromoDTO> response = postFilter.stream().map(post -> mapper.convertValue(post, PostPromoDTO.class)).toList();
        return response;
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
