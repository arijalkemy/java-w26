package org.example.youtuber.service;

import org.example.youtuber.dto.BlogDTO;
import org.example.youtuber.exception.BlogAlreadyExistsException;
import org.example.youtuber.exception.BlogNotFoundException;
import org.example.youtuber.model.Blog;
import org.example.youtuber.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public BlogDTO createBlog(BlogDTO blogDTO) {
        if (blogRepository.existsById(blogDTO.getId())) {
            throw new BlogAlreadyExistsException("Blog with id " + blogDTO.getId() + " already exists");
        }

        Blog blog = new Blog(blogDTO.getId(), blogDTO.getTitle(), blogDTO.getAuthor(), blogDTO.getPublicationDate());
        blogRepository.save(blog);
        return blogDTO;
    }

    public BlogDTO getBlogById(Integer id) {
        Blog blog = blogRepository.findById(id);
        if (blog == null) {
            throw new BlogNotFoundException("Blog with id " + id + " not found");
        }
        return new BlogDTO(blog.getId(), blog.getTitle(), blog.getAuthor(), blog.getPublicationDate());
    }

    public List<BlogDTO> getAllBlogs() {
        return blogRepository.findAll().stream()
                .map(blog -> new BlogDTO(blog.getId(), blog.getTitle(), blog.getAuthor(), blog.getPublicationDate()))
                .collect(Collectors.toList());
    }
}
