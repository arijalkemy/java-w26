package com.javabootcamp.socialmeli.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.dto.PostPromoDto;
import com.javabootcamp.socialmeli.dto.ProductDto;
import com.javabootcamp.socialmeli.dto.SellerWithCountProductsPromoDto;
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
    public void addPostPromo(PostPromoDto postPromoDto) {
        Post newPost = new Post();

        //Búsqueda de usuario
        User user = userService.searchUserById(postPromoDto.getIdUser());

        //Mapeo de productDto a product
        ProductDto productDto = postPromoDto.getProduct();
        Product product = new Product();
        product.setId(productDto.getId());
        product.setType(productDto.getType());
        product.setName(productDto.getName());
        product.setNotes(productDto.getNotes());
        product.setColor(productDto.getColor());
        product.setBrand(productDto.getBrand());

        Post post = new Post(
                user,
                CONTADOR.getAndIncrement(),
                postPromoDto.getDate(),
                product,
                postPromoDto.getCategory(),
                postPromoDto.getPrice(),
                true,
                postPromoDto.getDiscount());


        postRepository.add(post);
    }

    @Override
    public SellerWithCountProductsPromoDto findCountProductsPromo(int idUser) {

        User user = userService.searchUserById(idUser);

        SellerWithCountProductsPromoDto sellerWithCountProductsPromo = new SellerWithCountProductsPromoDto();
        sellerWithCountProductsPromo.setUserName(user.getUsername());
        sellerWithCountProductsPromo.setUserId(user.getId());
        sellerWithCountProductsPromo.setPromoProductsCount(postRepository.findCountPromoPostByUserId(idUser));

        return sellerWithCountProductsPromo;
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
}
