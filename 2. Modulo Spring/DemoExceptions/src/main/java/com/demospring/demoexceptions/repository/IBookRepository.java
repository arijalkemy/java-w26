package com.demospring.demoexceptions.repository;

import com.demospring.demoexceptions.model.Book;

import java.util.List;

public interface IBookRepository {
    List<Book> traerTodos();
    Book findById(Long id);
}
