package org.responseentity.manejoexcepciones1.repository;

import org.responseentity.manejoexcepciones1.entity.BlogEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository {
    private List<BlogEntity> blogs;

    public BlogRepository(){
        this.blogs = new ArrayList<>();
    }

    public void insertBlogEntry(BlogEntity blog) {
        this.blogs.add(blog);
    }

    public BlogEntity getBlogEntityById(int id){
        return this.blogs.stream()
                .filter(blog -> blog.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<BlogEntity> getAllBlogEntries(){
        return this.blogs;
    }
}
