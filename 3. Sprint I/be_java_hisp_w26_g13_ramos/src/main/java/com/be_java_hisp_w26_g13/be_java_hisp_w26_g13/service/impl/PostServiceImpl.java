package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service.impl;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.ExceptionDto;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PostDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PostPromoDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.ProductDTO;
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
    public ExceptionDto create(PostPromoDTO postPromoDTO) {
        if(isBadRequestPostPromoDto(postPromoDTO)){ throw new BadRequestException("The request is invalid or missing required data."); }

        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        Post post = mapper.convertValue(postPromoDTO, Post.class);

        if(userRepository.findById(post.getUserId()) == null){
            throw new NotFoundException("User with id " + post.getUserId() + " does not exist.");
        } if(productRepository.findById(post.getProduct().getProductId()) == null){
            throw new NotFoundException("User with id " + post.getProduct().getProductId() + " does not exist.");
        } if(post.getDate().isBefore(LocalDate.now())){
            throw  new IncorrectDateException("The provided date in the post is before the current date.");
        }

        postRepository.create(post);
        List<User> userList =userRepository.getAll();
        for (User user: userList){
            if (user.getUserId() == post.getUserId()){
                user.getPosts().add(post);
            }
        }
        return new ExceptionDto("The promo has been successfully created");
    }

    private Boolean isBadRequestPostDto(PostDTO postDto){
        return postDto.getDate() == null || postDto.getDate().isEmpty() ||
                postDto.getPrice() <= 0 ||
                postDto.getCategory() <= 0 ||
                postDto.getUserId() <= 0 ||
                postDto.getProduct() == null || isBadRequestProductDto(postDto.getProduct());
    }


    private Boolean isBadRequestPostPromoDto(PostPromoDTO postPromoDto){
        return postPromoDto.getDate() == null || postPromoDto.getDate().isEmpty() ||
                postPromoDto.getPrice() <= 0 ||
                postPromoDto.getCategory() <= 0 ||
                postPromoDto.getUserId() <= 0 ||
                postPromoDto.getProduct() == null ||
                isBadRequestProductDto(postPromoDto.getProduct())||
                !postPromoDto.isHasPromo() ||
                postPromoDto.getDiscount()==null ||
                postPromoDto.getDiscount() <= 0.0 ||
                postPromoDto.getDiscount() > 1;
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
