package com.bootcamp.asinc_primerapractica_dominiolibros.repository;

import com.bootcamp.asinc_primerapractica_dominiolibros.model.Book;

import java.util.List;

public interface IBookRepository {

    public List<Book> traerTodos();
    public Book findById(Long id);
}
