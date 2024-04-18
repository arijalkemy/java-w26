package com.bootcampjava.blogapirest.service;

import com.bootcampjava.blogapirest.model.DTO.EntradBlogDTO;
import com.bootcampjava.blogapirest.model.EntradaBlog;

import java.util.List;

public interface IEntradaBlogService {
    EntradBlogDTO traerUnaPorId(Integer id);
    List<EntradBlogDTO> traerTodas();
    EntradBlogDTO cargarUna(EntradaBlog nuevaEntrada);
}
