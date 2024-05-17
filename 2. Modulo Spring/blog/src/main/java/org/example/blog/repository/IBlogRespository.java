package org.example.blog.repository;

import org.example.blog.dto.BlogDTO;
import org.example.blog.entity.BlogEntity;

import java.util.List;

public interface IBlogRespository {
    BlogEntity saveBlog(BlogEntity blog);
    BlogEntity blogById(Long id);
    List<BlogEntity> blogsAll();
}
