package com.meli.be_java_hisp_w26_g09.util.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w26_g09.dto.PostDTO;
import com.meli.be_java_hisp_w26_g09.dto.PostForListDTO;
import com.meli.be_java_hisp_w26_g09.dto.ProductDTO;
import com.meli.be_java_hisp_w26_g09.entity.Post;
import com.meli.be_java_hisp_w26_g09.entity.Product;
import com.meli.be_java_hisp_w26_g09.exception.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostMapper {
    public Post postDTOtoPost(PostDTO post) {
        Product product = new Product(post.getProduct().getProductId(),
                post.getProduct().getProductName(),
                post.getProduct().getType(),
                post.getProduct().getBrand(),
                post.getProduct().getColor(),
                post.getProduct().getNotes());
        return new Post(0, post.getUserId(),
                post.getDate(),
                product,
                post.getCategory(),
                post.getPrice(),
                post.getHasPromo(),
                post.getDiscount());
    }

    public PostDTO postToPostDTO(Post post) {
        ProductDTO product = new ProductDTO(post.getProduct().getProductId(),
                post.getProduct().getProductName(),
                post.getProduct().getType(),
                post.getProduct().getBrand(),
                post.getProduct().getColor(),
                post.getProduct().getNotes());
        return new PostDTO(post.getId(),
                post.getUserId(),
                post.getDate(),
                product,
                post.getCategory(),
                post.getPrice(),
                post.getHasPromo(),
                post.getDiscount());
    }

    public List<PostForListDTO> postListToPostForListDTOS(List<Post> followedPostsLastTwoWeeks) {
        ObjectMapper mapper = new ObjectMapper();
        List<PostForListDTO> postForListDTOS = new ArrayList<>();
        followedPostsLastTwoWeeks.forEach(post -> postForListDTOS.add(new PostForListDTO(post.getUserId(),
                post.getId(),
                post.getDate(),
                mapper.convertValue(post.getProduct(), ProductDTO.class), post.getCategory(), post.getPrice())));
        return postForListDTOS;
    }

    public List<PostDTO> listPostToListPostDTO(List<Post> posts) {
        List<PostDTO> postResult = new ArrayList<>();
        for (Post post : posts) {
            postResult.add(postToPostDTO(post));
        }
        return postResult;
    }

    public Post mergePostDTOToPost(PostDTO postDTO, Post post){
        if(postDTO.getUserId()!= null){
            post.setUserId(postDTO.getUserId());
        }
        if(postDTO.getDate()!= null){
            post.setDate(postDTO.getDate());
        }
        if(postDTO.getPrice()!= null){
            post.setPrice(postDTO.getPrice());
        }
        if(postDTO.getCategory()!= null){
            post.setCategory(postDTO.getCategory());
        }
        if(postDTO.getHasPromo()!= null){
            post.setHasPromo(postDTO.getHasPromo());
        }
        if(postDTO.getDiscount()!= null){
            post.setDiscount(postDTO.getDiscount());
        }
        if(postDTO.getProduct()!= null){
            ProductMapper productMapper = new ProductMapper();
            post.setProduct(productMapper.productDTOtoProduct(postDTO.getProduct()));
        }
        return post;
    }

}
