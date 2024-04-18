package com.example._09_practicaexcepcionesteoria.repository;

import com.example._09_practicaexcepcionesteoria.entity.BlogPost;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogPostRepository implements IBlogPostRepository {

    static List<BlogPost> blogPosts;
    static {
        blogPosts = new ArrayList<>();
        blogPosts.add(new BlogPost(1, "Blog 1", "Jorge", LocalDate.now()));
        blogPosts.add(new BlogPost(2, "Blog 2", "Pedro", LocalDate.of(2015,03,15)));
        blogPosts.add(new BlogPost(3, "Blog 3", "Rodrigo", LocalDate.of(2020, 06, 22)));
    }
    @Override
    public List<BlogPost> getAll() {
        return blogPosts;
    }

    @Override
    public BlogPost findById(int id) {
        return blogPosts.stream()
                .filter(b->b.getIdBlog() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public int add(BlogPost blogPost) {
        blogPosts.add(blogPost);

        return blogPost.getIdBlog();
    }
}
