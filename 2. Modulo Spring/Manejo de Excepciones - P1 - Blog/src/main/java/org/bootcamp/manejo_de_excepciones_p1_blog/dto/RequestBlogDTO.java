package org.bootcamp.manejo_de_excepciones_p1_blog.dto;

import org.bootcamp.manejo_de_excepciones_p1_blog.entity.Blog;

public class RequestBlogDTO {
    private Integer id;
    private Blog blog;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
