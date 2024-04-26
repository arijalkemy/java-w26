package com.javabootcamp.socialmeli.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.dto.PromoPostDto;
import com.javabootcamp.socialmeli.dto.PromoProductsCountDto;
import com.javabootcamp.socialmeli.enums.UserType;
import com.javabootcamp.socialmeli.exception.IllegalActionException;
import com.javabootcamp.socialmeli.model.Post;
import com.javabootcamp.socialmeli.model.Product;
import com.javabootcamp.socialmeli.model.User;
import com.javabootcamp.socialmeli.repository.PostRepository;
import com.javabootcamp.socialmeli.utils.DtoMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private static final AtomicInteger CONTADOR = new AtomicInteger(1);

    private final PostRepository postRepository;
    private final UserService userService;

    @Override
    public void addPost(PostDto postDto) {

        ObjectMapper mapper = new ObjectMapper();
        Product product = mapper.convertValue(postDto.getProduct(), Product.class);
        User user = userService.searchUserById(postDto.getIdUser());
        if (!user.getUserType().equals(UserType.SELLER)) {
            throw new IllegalActionException("Only sellers can add posts");
        }
        Post post = new Post(
                user,
                CONTADOR.getAndIncrement(),
                postDto.getDate(),
                product,
                postDto.getCategory(),
                postDto.getPrice(),
                false,
                0D);

        postRepository.add(post);
    }

    @Override
    public void addPromoPost(PromoPostDto promoPostDto) {

        ObjectMapper mapper = new ObjectMapper();
        Product product = mapper.convertValue(promoPostDto.getProduct(), Product.class);
        User user = userService.searchUserById(promoPostDto.getIdUser());
        if (!user.getUserType().equals(UserType.SELLER)) {
            throw new IllegalActionException("Only sellers can add posts");
        }
        Post post = new Post(
                user,
                CONTADOR.getAndIncrement(),
                promoPostDto.getDate(),
                product,
                promoPostDto.getCategory(),
                promoPostDto.getPrice(),
                promoPostDto.getHasPromo(),
                promoPostDto.getDiscount()
        );
        System.out.println(post);
        postRepository.add(post);
    }

    @Override
    public PromoProductsCountDto getPromoProductsCount(Integer userId) {
        User user = userService.searchUserById(userId);
        Integer count = postRepository.findPromoPostByUserId(userId).size();
        return new PromoProductsCountDto(userId, user.getUsername(), count);
    }

    @Override
    public List<PostDto> findByTwoWeeksAgo(List<Integer> sellersId) {
        List<Post> posts = postRepository.findByTwoWeeksAgo(sellersId);
        List<PostDto> postDtos = new ArrayList<>();
        if (posts.isEmpty()) {
            return postDtos;
        } else {
            postDtos = posts.stream()
                    .map(DtoMapper::postToPostDto)
                    .toList();
        }
        return postDtos;
    }

    @Override
    public List<PostDto> findByTwoWeeksAgoOrderAsc(List<Integer> sellersId) {
        List<Post> posts = postRepository.findByTwoWeeksAgoOrderAsc(sellersId);
        List<PostDto> postDtos = new ArrayList<>();
        if (posts.isEmpty()) {
            return postDtos;
        } else {
            postDtos = posts.stream()
                    .map(DtoMapper::postToPostDto)
                    .toList();
        }
        return postDtos;
    }

    @Override
    public List<PostDto> findByTwoWeeksAgoOrderDesc(List<Integer> sellersId) {
        List<Post> posts = postRepository.findByTwoWeeksAgoOrderDesc(sellersId);
        List<PostDto> postDtos = new ArrayList<>();
        if (posts.isEmpty()) {
            return postDtos;
        } else {
            postDtos = posts.stream()
                    .map(DtoMapper::postToPostDto)
                    .toList();
        }
        return postDtos;
    }
}
