package org.bootcamp.blog.service;

import org.bootcamp.blog.dto.BlogDTO;
import org.bootcamp.blog.exception.ResourceAlreadyExistsException;
import org.bootcamp.blog.exception.ResourceNotFoundException;
import org.bootcamp.blog.model.BlogEntity;
import org.bootcamp.blog.repository.IBlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    private final IBlogRepository blogRepository;

    public BlogService(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public String createBlog(BlogDTO blogDTO) {
        BlogEntity blogEntity = new BlogEntity(blogDTO.getId(), blogDTO.getTitle(), blogDTO.getAuthor(), blogDTO.getDate());
        if (blogRepository.getBlog(blogEntity.getId()) != null) {
            throw new ResourceAlreadyExistsException("Blog with id " + blogDTO.getId() + " already exists");
        }
        return "Blog created successfully";
    }

    @Override
    public BlogDTO getBlog(int id) {
        BlogEntity blogEntity = blogRepository.getBlog(id);
        if (blogEntity == null) {
            throw new ResourceNotFoundException("Blog with id " + id + " does not exist");
        }
        return new BlogDTO(blogEntity.getId(), blogEntity.getTitle(), blogEntity.getAuthor(), blogEntity.getDate());
    }

    @Override
    public List<BlogDTO> getBlogs() {
        List<BlogEntity> blogEntities = blogRepository.getBlogs();
        return blogEntities.stream()
                .map(blogEntity -> new BlogDTO(blogEntity.getId(), blogEntity.getTitle(), blogEntity.getAuthor(), blogEntity.getDate()))
                .toList();
    }
}
