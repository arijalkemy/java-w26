package com.mercadolibre.pf_be_hisp_w26_t07_torres.service;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.sellers.SellerResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.entity.Seller;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.repository.ISellerRepository;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.service.interfaces.ISellerService;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.MessageError;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SellerServiceImpl implements ISellerService {
    private final ISellerRepository sellerRepository;

    public SellerServiceImpl(@Autowired ISellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public SellerResponseDto findById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Seller current = sellerRepository.findById(id).orElseThrow(() ->
                new NotFoundException(MessageError.SELLER_NOT_FOUND.getMessage()));
        return modelMapper.map(current, SellerResponseDto.class);
    }
}
