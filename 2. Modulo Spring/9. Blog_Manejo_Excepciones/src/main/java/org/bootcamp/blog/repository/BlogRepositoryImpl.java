package org.bootcamp.blog.repository;

import org.bootcamp.blog.model.BlogEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {
    private List<BlogEntity> blogs = new ArrayList<>();

    public BlogRepositoryImpl() {
        blogs = loadBlogs();
    }

    @Override
    public List<BlogEntity> getBlogs() {
        return blogs;
    }

    @Override
    public BlogEntity getBlog(int id) {
        return blogs.stream()
                .filter(blog -> blog.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void createBlog(BlogEntity blogEntity) {
        blogs.add(blogEntity);
    }

    private List<BlogEntity> loadBlogs() {
        return new ArrayList<>(
                List.of(
                        new BlogEntity(1, "First Blog", "Author 1", "01/01/2021"),
                        new BlogEntity(2, "Second Blog", "Author 2", "02/01/2021"),
                        new BlogEntity(3, "Third Blog", "Author 3", "03/01/2021"),
                        new BlogEntity(4, "Fourth Blog", "Author 4", "04/01/2021")
                )
        );
    }
}
