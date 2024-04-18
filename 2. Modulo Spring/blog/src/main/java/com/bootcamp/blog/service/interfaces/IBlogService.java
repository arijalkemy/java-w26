package com.bootcamp.blog.service.interfaces;

import com.bootcamp.blog.dto.EntradaBlogDto;

import java.util.List;

public interface IBlogService {

    List<EntradaBlogDto> getAll();

    EntradaBlogDto getById(int id);

    String create(EntradaBlogDto entradaBlogDto);
}
