package com.example._09_practicaexcepcionesteoria.repository;

import com.example._09_practicaexcepcionesteoria.entity.Book;

import java.util.List;

public interface IBookRepository {
    List<Book> getAll();
    Book findById(Long id);
}
