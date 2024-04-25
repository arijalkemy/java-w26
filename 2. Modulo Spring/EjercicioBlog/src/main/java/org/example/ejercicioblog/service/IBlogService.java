package org.example.ejercicioblog.service;

import org.example.ejercicioblog.dto.EntradaBlogDTO;
import org.example.ejercicioblog.dto.ExceptionDTO;
import org.example.ejercicioblog.entity.EntradaBlog;

import java.util.List;

public interface IBlogService {
    public ExceptionDTO addBlog(EntradaBlogDTO blog);
    public List<EntradaBlogDTO> findAll();
    public EntradaBlogDTO findById(int id);
}
