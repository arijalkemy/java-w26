package meli.bootcamp.blog.dto.mapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import meli.bootcamp.blog.dto.PostDTO;
import meli.bootcamp.blog.dto.PostIdDTO;
import meli.bootcamp.blog.entity.Post;

public class Mapper {

    static ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static PostDTO toPostDTO(Post post) {
        return objectMapper.convertValue(post, PostDTO.class);
    }

    public static Post toPost(PostDTO postDTO) {
        return objectMapper.convertValue(postDTO, Post.class);
    }

    public static PostIdDTO toPostIdDTO(Post post) {
        return objectMapper.convertValue(post, PostIdDTO.class);
    }
}
