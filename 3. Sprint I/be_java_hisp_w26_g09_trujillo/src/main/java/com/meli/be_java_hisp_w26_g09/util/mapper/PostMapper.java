package com.meli.be_java_hisp_w26_g09.util.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w26_g09.dto.PostDTO;
import com.meli.be_java_hisp_w26_g09.dto.PostForListDTO;
import com.meli.be_java_hisp_w26_g09.dto.ProductDTO;
import com.meli.be_java_hisp_w26_g09.dto.PromoProductsDTO;
import com.meli.be_java_hisp_w26_g09.entity.Post;
import com.meli.be_java_hisp_w26_g09.entity.Product;
import org.springframework.stereotype.Component;
import com.meli.be_java_hisp_w26_g09.entity.User;

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

    public List<PostForListDTO> postListToPostForListDTOS(List<Post> followedPostsLastTwoWeeks)
    {
        ObjectMapper mapper = new ObjectMapper();
        List<PostForListDTO> postForListDTOS = new ArrayList<>();
        followedPostsLastTwoWeeks.forEach(post -> postForListDTOS.add(new PostForListDTO(post.getUserId(),
                post.getId(),
                post.getDate(),
                mapper.convertValue(post.getProduct(), ProductDTO.class),
                post.getCategory(),
                post.getPrice())));
        return  postForListDTOS;
    }

    public PostDTO postCreatedListToPostForListDTOS(PostDTO post)
    {
        ObjectMapper mapper = new ObjectMapper();

        return new PostDTO(post.getUserId(),
                post.getUserId(),
                post.getUserName(),
                post.getDate(),
                mapper.convertValue(post.getProduct(), ProductDTO.class),
                post.getCategory(),
                post.getPrice(),
                post.getHasPromo(),
                post.getDiscount()
        );
    }

    public PromoProductsDTO postPromoProduct(User user, int count)
    {
        return new PromoProductsDTO(user.getUserId(), user.getUserName(), count);
    }

}
