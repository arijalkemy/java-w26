package com.mercadolibre.pf_be_hisp_w26_t07_torres.service;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.buyers.BuyerResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.entity.Buyer;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.repository.IBuyerRepository;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.service.interfaces.IBuyerService;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.MessageError;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BuyerServiceImpl implements IBuyerService {
    private final IBuyerRepository buyerRepository;

    public BuyerServiceImpl(@Autowired IBuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public BuyerResponseDto findById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Buyer current = buyerRepository.findById(id).orElseThrow(() ->
                new NotFoundException(MessageError.BUYER_NOT_FOUND.getMessage()));
        return modelMapper.map(current, BuyerResponseDto.class);
    }
}
