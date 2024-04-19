package org.bootcamp.manejo_de_excepciones_p1_blog.entity;

public class Blog {
    private String blogTitle;
    private String nameAutor;
    private String publishDate;

    public Blog() {
    }

    public Blog(int idBlog, String blogTitle, String nameAutor, String publishDate) {
        this.blogTitle = blogTitle;
        this.nameAutor = nameAutor;
        this.publishDate = publishDate;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getNameAutor() {
        return nameAutor;
    }

    public void setNameAutor(String nameAutor) {
        this.nameAutor = nameAutor;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
