package com.demospring.demoexceptions.repository;

import com.demospring.demoexceptions.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements IBookRepository {
    private List<Book> listaBooks = new ArrayList<>(){{
        add(new Book(1L, "¿Como programar?", "Programador"));
        add(new Book(2L, "¿Como no programar?", "Programador"));
    }};

    @Override
    public List<Book> traerTodos() {
        return listaBooks;
    }

    @Override
    public Book findById(Long id) {
        return this.listaBooks.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }
}
