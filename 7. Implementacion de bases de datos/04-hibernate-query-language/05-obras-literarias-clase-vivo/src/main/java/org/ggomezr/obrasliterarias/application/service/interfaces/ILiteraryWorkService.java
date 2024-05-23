package org.ggomezr.obrasliterarias.application.service.interfaces;

import org.ggomezr.obrasliterarias.domain.dto.LiteraryWorkDTO;
import org.ggomezr.obrasliterarias.domain.dto.ResponseDTO;
import org.ggomezr.obrasliterarias.domain.model.LiteraryWork;

import java.util.List;

public interface ILiteraryWorkService {
    LiteraryWorkDTO create(LiteraryWorkDTO literaryWorkDTO);
    List<LiteraryWorkDTO> createAll(List<LiteraryWorkDTO> literaryWorkDTO);
    List<LiteraryWorkDTO> findAll();
    LiteraryWorkDTO findById(String id);
    LiteraryWorkDTO update(String id, LiteraryWorkDTO literaryWorkDTO);
    ResponseDTO delete(String id);
    List<LiteraryWorkDTO> findByAuthor(String author);
    List<LiteraryWorkDTO> findByTitleContaining(String title);
    List<LiteraryWorkDTO> findTop5ByPagesDesc();
    List<LiteraryWorkDTO> findByReleaseDateYearBefore(Integer releaseDateYear);
    List<LiteraryWorkDTO> findByEditorial(String editorial);
}
