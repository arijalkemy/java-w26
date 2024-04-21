package com.bootcamp.asinc_primerapractica_dominiolibros.service;

import com.bootcamp.asinc_primerapractica_dominiolibros.exceptions.NotFoundException;
import com.bootcamp.asinc_primerapractica_dominiolibros.model.Book;
import com.bootcamp.asinc_primerapractica_dominiolibros.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    BookRepository bookRepo;

    @Override
    public List<Book> traerTodos() {
        return bookRepo.traerTodos();
    }

    @Override
    public Book findById(Long id) {
        Book libroEncontrado = bookRepo.findById(id);
        if (libroEncontrado == null) {
            throw new NotFoundException("El libro con el id " + id + " no fue encontrado");
        }
        return libroEncontrado;
    }
}
