package com.example.ejercicio_obrasliterarias.service.interfaces;

import com.example.ejercicio_obrasliterarias.entities.LiteraryWork;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ILiteraryWorkService {
    List<LiteraryWork> getAll(Pageable pageable);
    List<LiteraryWork> getAllByAuthorName(String authorName, Pageable pageable);
    List<LiteraryWork> getAllByTitle(String title, Pageable pageable);
    List<LiteraryWork> getTop5ByPages(Pageable pageable);
    List<LiteraryWork> getAllBeforeYear(int year, Pageable pageable);
    List<LiteraryWork> getAllByEditorial(String editorial, Pageable pageable);
}
