package com.mercadolibre.project_be_java_hisp_w26_t7.service.interfaces;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.representatives.RepresentativeResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.entity.Representative;
import com.mercadolibre.project_be_java_hisp_w26_t7.exceptions.NotFoundException;
import com.mercadolibre.project_be_java_hisp_w26_t7.repository.IRepresentativeRepository;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.enums.MessageError;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepresentativeServiceImpl implements IRepresentativeService {
    private final IRepresentativeRepository representativeRepository;

    public RepresentativeServiceImpl(@Autowired IRepresentativeRepository representativeRepository) {
        this.representativeRepository = representativeRepository;
    }

    @Override
    public RepresentativeResponseDto findById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Representative current = representativeRepository.findById(id).orElseThrow(() ->
                new NotFoundException(MessageError.REPRESENTATIVE_NOT_FOUND.getMessage()));
        return modelMapper.map(current, RepresentativeResponseDto.class);
    }
}
