package org.ggomezr.obrasliterarias.application.service.impl;

import org.ggomezr.obrasliterarias.application.service.interfaces.ILiteraryWorkService;
import org.ggomezr.obrasliterarias.domain.dto.LiteraryWorkDTO;
import org.ggomezr.obrasliterarias.domain.dto.ResponseDTO;
import org.ggomezr.obrasliterarias.domain.exception.NotFoundException;
import org.ggomezr.obrasliterarias.domain.model.LiteraryWork;
import org.ggomezr.obrasliterarias.domain.repository.ILiteraryWorkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class LiteraryWorkService implements ILiteraryWorkService {

    private final ILiteraryWorkRepository literaryWorkRepository;
    private final ModelMapper modelMapper;

    public LiteraryWorkService(ILiteraryWorkRepository literaryWorkRepository, ModelMapper modelMapper) {
        this.literaryWorkRepository = literaryWorkRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LiteraryWorkDTO create(LiteraryWorkDTO literaryWorkDTO) {
        LiteraryWork literaryWork = convertToEntity(literaryWorkDTO);
        literaryWork = literaryWorkRepository.save(literaryWork);
        return convertToDto(literaryWork);
    }

    @Override
    public List<LiteraryWorkDTO> createAll(List<LiteraryWorkDTO> literaryWorkDTO) {
        List<LiteraryWork> literaryWorks = literaryWorkDTO.stream()
                .map(this::convertToEntity).toList();
        List<LiteraryWork> savedLiteraryWorks = (List<LiteraryWork>) literaryWorkRepository.saveAll(literaryWorks);
        return savedLiteraryWorks.stream()
                .map(this::convertToDto).toList();
    }

    @Override
    public List<LiteraryWorkDTO> findAll() {
        Iterable<LiteraryWork> literaryWorks = literaryWorkRepository.findAll();
        Stream<LiteraryWork> literaryWorkStream = StreamSupport.stream(literaryWorks.spliterator(), false);
        return literaryWorkStream
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public LiteraryWorkDTO findById(String id) {
        Optional<LiteraryWork> literaryWorkOptional = literaryWorkRepository.findById(id);
        if (literaryWorkOptional.isEmpty()) throw new NotFoundException("Literary work not found");

        return convertToDto(literaryWorkOptional.get());
    }

    @Override
    public LiteraryWorkDTO update(String id, LiteraryWorkDTO literaryWorkDTO) {
        Optional<LiteraryWork> literaryWorkOptional = literaryWorkRepository.findById(id);
        if (literaryWorkOptional.isEmpty()) throw new NotFoundException("Literary work not found");

        LiteraryWork updatedLiteraryWork = convertToEntity(literaryWorkDTO);
        updatedLiteraryWork.setId(id);

        literaryWorkRepository.save(updatedLiteraryWork);
        return convertToDto(updatedLiteraryWork);
    }

    @Override
    public ResponseDTO delete(String id) {
        Optional<LiteraryWork> literaryWorkOptional = literaryWorkRepository.findById(id);
        if (literaryWorkOptional.isEmpty()) throw new NotFoundException("Literary work not found");

        literaryWorkRepository.deleteById(id);
        return new ResponseDTO("Literary work deleted successfully");
    }

    @Override
    public List<LiteraryWorkDTO> findByAuthor(String author) {
        List<LiteraryWork> literaryWorks = literaryWorkRepository.findByAuthor(author);
        return literaryWorks.stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public List<LiteraryWorkDTO> findByTitleContaining(String title) {
        List<LiteraryWork> literaryWorks = literaryWorkRepository.findByTitleContaining(title);
        return literaryWorks.stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public List<LiteraryWorkDTO> findTop5ByPagesDesc() {
        List<LiteraryWork> literaryWorks = literaryWorkRepository.findTop5ByOrderByPagesDesc();
        return literaryWorks.stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public List<LiteraryWorkDTO> findByReleaseDateYearBefore(Integer releaseDateYear) {
        List<LiteraryWork> literaryWorks = literaryWorkRepository.findByReleaseDateYearBefore(releaseDateYear);
        return literaryWorks.stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public List<LiteraryWorkDTO> findByEditorial(String editorial) {
        List<LiteraryWork> literaryWorks = literaryWorkRepository.findByEditorial(editorial);
        return literaryWorks.stream()
                .map(this::convertToDto)
                .toList();
    }

    private LiteraryWorkDTO convertToDto(LiteraryWork literaryWork) {
        return modelMapper.map(literaryWork, LiteraryWorkDTO.class);
    }

    private LiteraryWork convertToEntity(LiteraryWorkDTO literaryWorkDTO) {
        return modelMapper.map(literaryWorkDTO, LiteraryWork.class);
    }
}
