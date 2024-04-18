package com.w26.blog.repository;

import com.w26.blog.entity.Blog;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository {

    private List<Blog> repository;

    public BlogRepository()
    {
        this.repository = new ArrayList<>();
        this.repository.add(new Blog(1, "Nose 1", "Autor 1", LocalDate.now()));
        this.repository.add(new Blog(2, "Nose 2", "Autor 2", LocalDate.now()));
        this.repository.add(new Blog(3, "Nose 3", "Autor 3", LocalDate.now()));
        this.repository.add(new Blog(4, "Nose 4", "Autor 4", LocalDate.now()));
    }

    public void add(Blog blog)
    {
        this.repository.add(blog);
    }

    public List<Blog> getRepository()
    {
        return this.repository;
    }

}
