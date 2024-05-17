package com.javabootcamp.socialmeli.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.dto.PostPromoDto;
import com.javabootcamp.socialmeli.dto.PostPromoRespDto;
import com.javabootcamp.socialmeli.dto.ProductsPromoDto;
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
    public void addPostPromo(PostPromoDto postPromoDto) {
        ObjectMapper mapper = new ObjectMapper();
        Product product = mapper.convertValue(postPromoDto.getProduct(), Product.class);
        User user = userService.searchUserById(postPromoDto.getIdUser());
        Post post = new Post(
                user,
                CONTADOR.getAndIncrement(),
                postPromoDto.getDate(),
                product,
                postPromoDto.getCategory(),
                postPromoDto.getPrice(),
                postPromoDto.isHas_promo(),
                postPromoDto.getDiscount());

        postRepository.add(post);

    }

    @Override
    public List<PostDto> findByTwoWeeksAgo(List<Integer> sellersId) {
        List<Post> posts = postRepository.findByTwoWeeksAgo(sellersId);
        List<PostDto> postDtos = new ArrayList<>();
        if (posts.isEmpty()) {
            return postDtos;
        } else {
            postDtos = posts.stream()
                    .map(p -> DtoMapper.postToPostDto(p))
                    .toList();
        }
        return postDtos;
    }

    @Override
    public void addPostList(List<PostDto> listPostDto) {
        listPostDto.forEach(p -> addPost(p));
    }

    @Override
    public List<PostDto> findByTwoWeeksAgoOrderAsc(List<Integer> sellersId) {
        List<Post> posts = postRepository.findByTwoWeeksAgoOrderAsc(sellersId);
        List<PostDto> postDtos = new ArrayList<>();
        if (posts.isEmpty()) {
            return postDtos;
        } else {
            postDtos = posts.stream()
                    .map(p -> DtoMapper.postToPostDto(p))
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
                    .map(p -> DtoMapper.postToPostDto(p))
                    .toList();
        }
        return postDtos;
    }

    @Override
    public PostPromoRespDto getQuantityProductsPromo(Integer sellerId) {
        User user = userService.searchUserById(sellerId);
        Integer quantityProductsPromo= postRepository.getQuantityProductsPromo(user.getId());
        return new PostPromoRespDto(user.getId(), user.getUsername(),quantityProductsPromo);

    }

    @Override
    public void modifyPromoPost(ProductsPromoDto productsPromoDto) {
        User user = userService.searchUserById(productsPromoDto.getUserId());
        postRepository.modifyPromoPost(productsPromoDto);
    }
}
