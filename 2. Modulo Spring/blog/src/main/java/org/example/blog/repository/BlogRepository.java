package org.example.blog.repository;


import org.example.blog.dto.BlogDTO;
import org.example.blog.entity.BlogEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class BlogRepository implements IBlogRespository{

    private final static List<BlogEntity> blogList = new ArrayList<>();

    @Override
    public BlogEntity saveBlog(BlogEntity blog) {
        BlogEntity blogEntity = new BlogEntity();

        AtomicBoolean isId = new AtomicBoolean(false);

        blogList.stream().forEach(blogEntity1 -> {
            if (blog.getId().equals(blogEntity1.getId())) {
                isId.set(true);
            }
        });

        if (!isId.get()) {
            blogEntity.setId(blog.getId());
            blogEntity.setTitulo(blog.getTitulo());
            blogEntity.setAutor(blog.getAutor());
            blogEntity.setFecha(blog.getFecha());

            blogList.add(blogEntity);
        }
        return blogEntity;
    }

    @Override
    public BlogEntity blogById(Long id) {
        List<BlogEntity> blogById = blogList.stream()
                .filter(blogDTO -> blogDTO.getId().equals(id)).toList();
        return blogById.get(0);
    }

    @Override
    public List<BlogEntity> blogsAll() {
        return blogList;
    }


}
