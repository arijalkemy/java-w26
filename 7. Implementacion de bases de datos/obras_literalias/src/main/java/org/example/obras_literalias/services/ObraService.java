package org.example.obras_literalias.services;

import org.example.obras_literalias.DTO.ObraLiterariaDTO;
import org.example.obras_literalias.domain.ObraLiteraria;
import org.example.obras_literalias.repository.IObraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraService implements IObraService{

    private final IObraRepository obraRepository;
    private final ModelMapper mapper;

    public ObraService(IObraRepository obraRepository) {
        this.obraRepository = obraRepository;
        mapper=new ModelMapper();
    }

    @Override
    public List<ObraLiterariaDTO> findByAuthor(String author) {
        return obraRepository.findByAuthorName(author,Pageable.unpaged())
                .stream()
                .map(this::convertEntityToDTO).toList();
    }

    @Override
    public List<ObraLiterariaDTO> findByTitleKeyword(String keyword) {
        return obraRepository.findByNameContains(keyword,Pageable.unpaged())
                .stream()
                .map(this::convertEntityToDTO).toList();
    }

    @Override
    public List<ObraLiterariaDTO> findTopFiveWithMoreAmountPages() {
        return obraRepository.findTop5ByOrderByAmountOfPagesDesc(Pageable.unpaged())
                .stream()
                .map(this::convertEntityToDTO).toList();
    }

    @Override
    public List<ObraLiterariaDTO> findAllPublishedBeforeYear(Integer year) {
        return obraRepository.findByPublishingYearIsLessThan(year,Pageable.unpaged())
                .stream()
                .map(this::convertEntityToDTO).toList();
    }

    @Override
    public List<ObraLiterariaDTO> findAllByEditorial(String editorial) {
        return obraRepository.findByEditorial(editorial, Pageable.unpaged())
                .stream()
                .map(this::convertEntityToDTO).toList();
    }

    private ObraLiterariaDTO convertEntityToDTO(ObraLiteraria obraLiteraria){
        return mapper.map(obraLiteraria, ObraLiterariaDTO.class);
    }
}
