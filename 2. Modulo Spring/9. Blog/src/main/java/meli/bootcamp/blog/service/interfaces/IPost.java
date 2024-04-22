package meli.bootcamp.blog.service.interfaces;

import meli.bootcamp.blog.dto.PostDTO;
import meli.bootcamp.blog.dto.PostIdDTO;

import java.util.List;

public interface IPost {
    PostIdDTO savePost(PostDTO postDTO);
    PostDTO getPostById(Integer id);
    List<PostDTO> getAllPosts();
}
