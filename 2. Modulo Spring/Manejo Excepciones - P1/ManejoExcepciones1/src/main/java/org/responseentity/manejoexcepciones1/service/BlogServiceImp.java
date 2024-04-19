package org.responseentity.manejoexcepciones1.service;

import org.responseentity.manejoexcepciones1.dto.BlogDTO;
import org.responseentity.manejoexcepciones1.entity.BlogEntity;
import org.responseentity.manejoexcepciones1.mappers.BlogMapper;
import org.responseentity.manejoexcepciones1.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImp implements BlogService{

    @Autowired
    BlogRepository blogRepository;

    @Override
    public String createBlogEntry(BlogDTO blogDto) {
        try {
            BlogEntity blogEntity = BlogMapper.dtoToEntity(blogDto);
            this.blogRepository.insertBlogEntry(blogEntity);
            return "Blog creado correctamente";

        }catch (Exception ex){
            return "Error en la creacion del blog";
        }
    }

    @Override
    public BlogEntity getBlogEntryById(int id) {
        return this.blogRepository.getBlogEntityById(id);
    }

    @Override
    public List<BlogEntity> getAllTheBlogEntries() {
        return this.blogRepository.getAllBlogEntries();
    }
}
