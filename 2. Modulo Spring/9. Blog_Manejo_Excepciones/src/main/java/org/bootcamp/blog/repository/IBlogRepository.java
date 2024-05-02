package org.bootcamp.blog.repository;

import org.bootcamp.blog.dto.BlogDTO;
import org.bootcamp.blog.model.BlogEntity;

import java.util.List;

public interface IBlogRepository {
    List<BlogEntity> getBlogs();
    BlogEntity getBlog(int id);
    String createBlog(BlogEntity blogEntity);
}
