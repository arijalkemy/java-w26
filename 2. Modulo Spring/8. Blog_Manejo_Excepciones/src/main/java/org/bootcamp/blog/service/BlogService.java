package org.bootcamp.blog.service;

import org.apache.catalina.mapper.Mapper;
import org.bootcamp.blog.dto.BlogDTO;
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
        return blogRepository.createBlog(blogEntity);
    }

    @Override
    public BlogDTO getBlog(int id) {
        BlogEntity blogEntity = blogRepository.getBlog(id);
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
