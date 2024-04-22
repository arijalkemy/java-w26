package meli.bootcamp.blog.service;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.blog.dto.PostDTO;
import meli.bootcamp.blog.dto.mapper.Mapper;
import meli.bootcamp.blog.dto.PostIdDTO;
import meli.bootcamp.blog.entity.Post;
import meli.bootcamp.blog.exception.DuplicateEntryException;
import meli.bootcamp.blog.exception.NotFoundException;
import meli.bootcamp.blog.repository.BlogRepository;
import meli.bootcamp.blog.service.interfaces.IPost;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostImpl implements IPost {

    private final BlogRepository blog;

    @Override
    public PostIdDTO savePost(PostDTO postDTO) {
        Post findedPost = blog.findAll().stream()
                .filter(post -> post.getId().equals(postDTO.getId()))
                .findFirst()
                .orElse(null);

        if (findedPost != null) {
            throw new DuplicateEntryException("Duplicate post entry");
        }

        Post post = blog.save(Mapper.toPost(postDTO));
        return Mapper.toPostIdDTO(post);
    }

    @Override
    public PostDTO getPostById(Integer id) {
        Post post = blog.findById(id);

        if(post == null) {
            throw new NotFoundException("Post not found");
        }

        return Mapper.toPostDTO(post);
    }

    @Override
    public List<PostDTO> getAllPosts() {
        return blog.findAll().stream().map(Mapper::toPostDTO).toList();
    }
}
