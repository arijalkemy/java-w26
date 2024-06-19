package com.mercadolibre.project_be_java_hisp_w26_t7.service;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.sellers.SellerResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.entity.Seller;
import com.mercadolibre.project_be_java_hisp_w26_t7.exceptions.NotFoundException;
import com.mercadolibre.project_be_java_hisp_w26_t7.repository.ISellerRepository;
import com.mercadolibre.project_be_java_hisp_w26_t7.service.interfaces.ISellerService;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.MessageError;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements ISellerService {
    private final ISellerRepository sellerRepository;

    public SellerServiceImpl(@Autowired ISellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public SellerResponseDto findById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Seller current = sellerRepository.findById(id).orElseThrow(() ->
                new NotFoundException(MessageError.SELLER_NOT_FOUND.getMessage()));
        return modelMapper.map(current, SellerResponseDto.class);
    }
}
