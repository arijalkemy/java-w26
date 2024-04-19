package com.example.ejercicioBlog.service;

import com.example.ejercicioBlog.dto.EntradaBlogDto;
import com.example.ejercicioBlog.model.EntradaBlog;

import java.util.List;

public interface IBlogService {

    List<EntradaBlogDto> getAll();

    EntradaBlogDto findById(Integer id);

    String save(EntradaBlog entradaBlog);
}
