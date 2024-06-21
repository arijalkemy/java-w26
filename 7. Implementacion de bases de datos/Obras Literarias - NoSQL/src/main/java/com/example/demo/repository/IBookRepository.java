package com.example.demo.repository;

import com.example.demo.model.entity.Book;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.List;

@Repository
public interface IBookRepository extends ElasticsearchRepository<Book, String> {

    @Query("{\"match\": {\"author\": \"?0\"}}")
    List<Book> findByAuthor(String author);

    @Query("{\"match\": {\"title\": {\"query\": \"?0\", \"operator\": \"and\"}}}")
    List<Book> findByTitleContaining(String keyword);

    @Query("{\"range\": {\"publicationYear\": {\"lt\": \"?0\"}}}")
    List<Book> findByPublicationYearBefore(Year year);

    @Query("{\"match_all\": {}}")
    List<Book> findTop5ByOrderByPageCountDesc();

    @Query("{\"match\": {\"publisher\": \"?0\"}}")
    List<Book> findByPublisher(String publisher);

}
