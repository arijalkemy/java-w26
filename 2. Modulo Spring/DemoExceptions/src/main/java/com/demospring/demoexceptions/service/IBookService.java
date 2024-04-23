package com.demospring.demoexceptions.service;

import com.demospring.demoexceptions.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> traerTodos();
    Book findById(Long id);
}
