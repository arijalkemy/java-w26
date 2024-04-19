package com.example.ejercicioBlog.repository;

import com.example.ejercicioBlog.dto.EntradaBlogDto;
import com.example.ejercicioBlog.model.EntradaBlog;

import java.util.List;

public interface IBlogRepository {

    List<EntradaBlogDto> getAll();

    EntradaBlogDto findById(int id);

    //return true if can create the entry else return false
    boolean save( int id,EntradaBlogDto entradaBlog);
}
