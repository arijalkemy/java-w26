package com.example._09_practicaexcepcionesteoria.repository;

import com.example._09_practicaexcepcionesteoria.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements IBookRepository{

    static List<Book> books;
    static {
        books = new ArrayList<>();
        books.add(new Book(1L, "No tiene", "Jorge"));
        books.add(new Book(2L, "Tiene 1", "Pedro"));
        books.add(new Book(3L, "Tiene 2", "Rodrigo"));
    }
    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public Book findById(Long id) {
        return books.stream()
                .filter(b->b.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
