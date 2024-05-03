package com.javabootcamp.socialmeli.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.dto.PostWithPromoDto;
import com.javabootcamp.socialmeli.dto.PromoBySellerDto;
import com.javabootcamp.socialmeli.dto.QuantityPostWithPromoDto;
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
    public PromoBySellerDto findPromosBySellerId(int userId) {

        List<Post> postList = postRepository.findPromosBySellerId(userId);
        User user = userService.searchUserById(userId);
        PromoBySellerDto promo = DtoMapper.postAndUserToPromoBySellerDto(postList,user);
        return promo;
    }

    @Override
    public void addPostWithPromo(PostWithPromoDto postWithPromo) {
        ObjectMapper mapper = new ObjectMapper();
        Product product = mapper.convertValue(postWithPromo.getProduct(), Product.class);
        User user = userService.searchUserById(postWithPromo.getIdUser());
        Post post = new Post(
                user,
                CONTADOR.getAndIncrement(),
                postWithPromo.getDate(),
                product,
                postWithPromo.getCategory(),
                postWithPromo.getPrice(),
                postWithPromo.isHasPromo(),
                postWithPromo.getDiscount());

        postRepository.add(post);
    }

    @Override
    public QuantityPostWithPromoDto countPostWithPromoBySeller(int userId) {
        User user = userService.searchUserById(userId);
        int quantityPost = postRepository.countPostWithPromoBySeller(userId);
        QuantityPostWithPromoDto quantityPostWithPromoDto = DtoMapper.intAndUserToquantityPostWithPromoDto(quantityPost,user);
        return quantityPostWithPromoDto;
    }
}
