package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.representatives.RepresentativeResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.Representative;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.repository.IRepresentativeRepository;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.util.enums.MessageError;
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
