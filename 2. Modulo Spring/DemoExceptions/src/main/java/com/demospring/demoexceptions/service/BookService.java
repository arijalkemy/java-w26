package com.demospring.demoexceptions.service;

import com.demospring.demoexceptions.exceptions.NotFoundException;
import com.demospring.demoexceptions.model.Book;
import com.demospring.demoexceptions.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository bookRepository;

    @Override
    public List<Book> traerTodos() {
        return bookRepository.traerTodos();
    }

    @Override
    public Book findById(Long id) {
        Book bookFound = bookRepository.findById(id);
        if(bookFound == null){
            throw new NotFoundException("El libro con el id: " + id + " no existe.");
        }
        return bookFound;
    }
}
