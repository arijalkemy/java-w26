package com.blog.excercise.repository;

import com.blog.excercise.dto.BlogDTO;
import com.blog.excercise.entity.EntradaBlog;

import java.util.List;

public interface BlogRepository {

    Integer saveNewBlog(EntradaBlog entradaBlog);

    EntradaBlog getBlogsByUserId(Integer userId);

    List<EntradaBlog> getAllBlogs();
}
