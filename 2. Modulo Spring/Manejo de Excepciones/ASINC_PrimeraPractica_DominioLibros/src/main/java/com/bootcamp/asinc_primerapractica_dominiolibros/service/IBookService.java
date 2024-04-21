package com.bootcamp.asinc_primerapractica_dominiolibros.service;

import com.bootcamp.asinc_primerapractica_dominiolibros.model.Book;

import java.util.List;

public interface IBookService {

    public List<Book> traerTodos();
    public Book findById(Long id);
}
