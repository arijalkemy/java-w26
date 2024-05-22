package com.example.ejercicio_obrasliterarias.service.implementations;

import com.example.ejercicio_obrasliterarias.entities.LiteraryWork;
import com.example.ejercicio_obrasliterarias.repository.LiteraryWorkRepository;
import com.example.ejercicio_obrasliterarias.service.interfaces.ILiteraryWorkService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LiteraryWorkService implements ILiteraryWorkService {

    private final LiteraryWorkRepository literaryWorkRepository;

    public LiteraryWorkService(LiteraryWorkRepository literaryWorkRepository) {
        this.literaryWorkRepository = literaryWorkRepository;
    }

    @Override
    public List<LiteraryWork> getAll(Pageable pageable) {
        Page<LiteraryWork> page = literaryWorkRepository.findAll(pageable);
        return page.stream().collect(Collectors.toList());
    }

    @Override
    public List<LiteraryWork> getAllByAuthorName(String authorName, Pageable pageable) {
        Page<LiteraryWork> page = literaryWorkRepository.findAllByAuthor(authorName, pageable);
        return page.stream().collect(Collectors.toList());
    }

    @Override
    public List<LiteraryWork> getAllByTitle(String title, Pageable pageable) {
        Page<LiteraryWork> page = literaryWorkRepository.findAllByTitle(title, pageable);
        return page.stream().collect(Collectors.toList());
    }

    @Override
    public List<LiteraryWork> getTop5ByPages(Pageable pageable) {
        Page<LiteraryWork> page = literaryWorkRepository.findTop5ByOrderByPagesDesc(pageable);
        return page.stream().collect(Collectors.toList());
    }

    @Override
    public List<LiteraryWork> getAllBeforeYear(int year, Pageable pageable) {
        Page<LiteraryWork> page = literaryWorkRepository.findAllBeforeYear(1988, pageable);
        return page.stream().collect(Collectors.toList());
    }

    @Override
    public List<LiteraryWork> getAllByEditorial(String editorial, Pageable pageable) {
        Page<LiteraryWork> page = literaryWorkRepository.findAllByEditorial(editorial, pageable);
        return page.stream().collect(Collectors.toList());
    }
}
