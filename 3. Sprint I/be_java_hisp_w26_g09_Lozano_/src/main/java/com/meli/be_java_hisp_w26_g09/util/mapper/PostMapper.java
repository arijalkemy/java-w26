package com.meli.be_java_hisp_w26_g09.util.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w26_g09.dto.PostDTO;
import com.meli.be_java_hisp_w26_g09.dto.PostForListDTO;
import com.meli.be_java_hisp_w26_g09.dto.ProductDTO;
import com.meli.be_java_hisp_w26_g09.entity.Post;
import com.meli.be_java_hisp_w26_g09.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostMapper {

    ProductMapper productMapper = new ProductMapper();

    ObjectMapper mapper = new ObjectMapper();

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

    public PostDTO convertPostToPostDTO(Post post, Class<PostDTO> postDTOClass){
       PostDTO postDTO = new PostDTO();

       postDTO.setPostId(post.getId());
       postDTO.setCategory(post.getCategory());
       postDTO.setDate(post.getDate());
       postDTO.setDiscount(post.getDiscount());
       postDTO.setUserId(post.getUserId());
       postDTO.setPrice(post.getPrice());
       postDTO.setHasPromo(post.getHasPromo());
       postDTO.setProduct(productMapper.convertProductToProductDTO(post.getProduct()));

       return postDTO;
    }

    public List<PostForListDTO> postListToPostForListDTOS(List<Post> followedPostsLastTwoWeeks)
    {

        List<PostForListDTO> postForListDTOS = new ArrayList<>();
        followedPostsLastTwoWeeks.forEach(post -> postForListDTOS.add(new PostForListDTO(post.getUserId(),
                post.getId(),
                post.getDate(),
                mapper.convertValue(post.getProduct(), ProductDTO.class), post.getCategory(), post.getPrice())));
        return  postForListDTOS;
    }

}
