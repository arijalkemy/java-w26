package org.example.blog.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.blog.dto.BlogDTO;
import org.example.blog.exceptions.AlreadyExistException;
import org.example.blog.exceptions.NotFoundException;
import org.example.blog.model.EntradaBlog;
import org.example.blog.repository.IRepository;
import org.example.blog.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaBlogServiceImpl implements IEntradaBlogService {

    @Autowired
    IRepository blogRepository;

    @Override
    public Integer create(BlogDTO blogDTO) {
        ObjectMapper mapper = new ObjectMapper();
        EntradaBlog entradaBlog = mapper.convertValue(blogDTO, EntradaBlog.class);
        if (!existEntradaBlog(entradaBlog.getId())) {
            blogRepository.add(entradaBlog);
        } else {
            throw new AlreadyExistException("Ya existe una entrada con ese ID");
        }
        return entradaBlog.getId();
    }

    @Override
    public BlogDTO findById(int id) {
        EntradaBlog blog = blogRepository.getById(id);
        BlogDTO blogDTO;
        if (blog != null) {
            ObjectMapper mapper = new ObjectMapper();
            blogDTO = mapper.convertValue(blog, BlogDTO.class);
        } else {
            throw new NotFoundException("No existe una entrada con ese ID");
        }
        return blogDTO;
    }

    @Override
    public List<BlogDTO> findAll() {
        List<EntradaBlog> listEntradas = blogRepository.getAll();
        ObjectMapper mapper = new ObjectMapper();
        return listEntradas.stream().map(v -> mapper.convertValue(v, BlogDTO.class)).toList();
    }

    private boolean existEntradaBlog(int id) {
        return blogRepository.getById(id) != null;
    }
}
