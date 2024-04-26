package com.javabootcamp.socialmeli.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.dto.ProductsPromoDto;
import com.javabootcamp.socialmeli.dto.PromoRequestDto;
import com.javabootcamp.socialmeli.enums.UserType;
import com.javabootcamp.socialmeli.exception.EntityNotFoundException;
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
    public void addPromo(PromoRequestDto promoDto) {
        if (!promoDto.getHasPromo() || promoDto.getDiscount()>=1 || promoDto.getDiscount()<=0 ){
            throw new IllegalActionException("This endopoint must recibe a promo with discount between 0.1 and 0.9");
        };
        ObjectMapper mapper = new ObjectMapper();
        Product product = mapper.convertValue(promoDto.getProduct(), Product.class);
        User user = userService.searchUserById(promoDto.getIdUser());
        //validaciones de si es vendedor y de si efectivamente tiene promo
        if (!user.getUserType().equals(UserType.SELLER)){
            throw new IllegalActionException("the user must be a seller");
        };


        Post post = new Post(
                user,
                CONTADOR.getAndIncrement(),
                promoDto.getDate(),
                product,
                promoDto.getCategory(),
                promoDto.getPrice(),
                //bajo mi punto de vista se puede setear la siguiente propiedad como true por defecto
                promoDto.getHasPromo(),
                promoDto.getDiscount());

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
    public ProductsPromoDto countPromoByIdUSer(Integer idUser) {
         User user= userService.searchUserById(idUser);
         Integer count =postRepository.countPromosByUserID(idUser);
         if (count==0){
             throw  new EntityNotFoundException("the seller doesn't have active promos");
         }
        return new ProductsPromoDto(user.getId(), user.getUsername(), count) ;
    }
}
