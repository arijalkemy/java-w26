package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.service.impl;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.dto.MessageDto;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.dto.PostDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.entity.Post;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.entity.User;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.exception.BadRequestException;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.exception.IncorrectDateException;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.exception.NotFoundException;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.repository.IPostRepository;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.repository.IProductRepository;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.repository.IUserRepository;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.service.IPostService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
    public MessageDto create(PostDTO postDTO){

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
        user.getPosts().add(post.getPostId());
        return new MessageDto("The post has been successfully created");
    }
}
