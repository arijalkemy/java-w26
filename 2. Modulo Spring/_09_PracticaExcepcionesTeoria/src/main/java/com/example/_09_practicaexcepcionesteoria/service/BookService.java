package com.example._09_practicaexcepcionesteoria.service;

import com.example._09_practicaexcepcionesteoria.entity.Book;
import com.example._09_practicaexcepcionesteoria.exceptions.NotFoundException;
import com.example._09_practicaexcepcionesteoria.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    @Autowired
    IBookRepository iBookRepository;


    @Override
    public List<Book> getAll() {
        return iBookRepository.getAll();
    }

    @Override
    public Book findById(Long id) {
        Book book = iBookRepository.findById(id);
        if(book == null)
            throw new NotFoundException("No se encontro el libro con el id " + id);

        return book;
    }
}
