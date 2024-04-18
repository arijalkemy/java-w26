package co.com.mercadolibre.blog.service;

import co.com.mercadolibre.blog.dto.BlogDto;

import java.util.List;

public interface IBlogService {

    Integer save(BlogDto blogDto);
    BlogDto getById(Integer id);
    List<BlogDto> getAll();
}
