package com.example._09_practicaexcepcionesteoria.service;

import com.example._09_practicaexcepcionesteoria.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    Book findById(Long id);
}
