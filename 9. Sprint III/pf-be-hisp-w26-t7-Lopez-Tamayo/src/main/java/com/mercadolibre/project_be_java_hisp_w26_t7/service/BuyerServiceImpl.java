package com.mercadolibre.project_be_java_hisp_w26_t7.service;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.buyers.BuyerResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.entity.Buyer;
import com.mercadolibre.project_be_java_hisp_w26_t7.exceptions.NotFoundException;
import com.mercadolibre.project_be_java_hisp_w26_t7.repository.IBuyerRepository;
import com.mercadolibre.project_be_java_hisp_w26_t7.service.interfaces.IBuyerService;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.MessageError;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImpl implements IBuyerService {
    private final IBuyerRepository buyerRepository;

    public BuyerServiceImpl(@Autowired IBuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @Override
    public BuyerResponseDto findById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Buyer current = buyerRepository.findById(id).orElseThrow(() ->
                new NotFoundException(MessageError.BUYER_NOT_FOUND.getMessage()));
        return modelMapper.map(current, BuyerResponseDto.class);
    }
}
