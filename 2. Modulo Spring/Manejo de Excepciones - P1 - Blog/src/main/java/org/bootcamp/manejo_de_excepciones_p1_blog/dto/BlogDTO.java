package org.bootcamp.manejo_de_excepciones_p1_blog.dto;

import org.bootcamp.manejo_de_excepciones_p1_blog.entity.Blog;

public class BlogDTO {
    private Integer id;
    private Blog blog;

    public BlogDTO() {
    }

    public BlogDTO(Integer id, Blog blog) {
        this.id = id;
        this.blog = blog;
    }

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
