package org.example.blog.repository.imp;

import org.example.blog.dto.BlogRequestDTO;
import org.example.blog.model.EntradaBlog;
import org.example.blog.repository.IBlogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositoryImp implements IBlogRepository {
    List<EntradaBlog> blogs;

    public BlogRepositoryImp() {
        this.blogs = new ArrayList<>();
    }

    @Override
    public List<EntradaBlog> getBlogs() {
        return blogs;
    }

    @Override
    public int saveBlog(BlogRequestDTO blog) {
        blogs.add(new EntradaBlog(blog));
        return blog.getId();
    }

    @Override
    public boolean blogExist(int id) {
        if(blogs.stream()
                .anyMatch(existingBlog -> existingBlog.getId() == id)
        ){
            return true;
        }
        return false;
    }

    @Override
    public boolean blogExist(BlogRequestDTO blog) {
        if(blogs.stream()
                .anyMatch(existingBlog -> existingBlog.getId() == blog.getId())
        ){
            return true;
        }
        return false;
    }
}
