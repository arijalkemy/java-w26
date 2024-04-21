package com.bootcamp.asinc_primerapractica_dominiolibros.repository;


import com.bootcamp.asinc_primerapractica_dominiolibros.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements IBookRepository {
    List<Book> listaBooks = new ArrayList<Book>() {{
        add(new Book(1L, "Harry Potter", "J K Rowling"));
        add(new Book(2L, "El señor de los anillos", "J R R Tolkien"));
    }};

    @Override
    public List<Book> traerTodos() {
        return listaBooks;
    }

    @Override
    public Book findById(Long id) {
        for (Book book : listaBooks) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
    return null;
    }
}
