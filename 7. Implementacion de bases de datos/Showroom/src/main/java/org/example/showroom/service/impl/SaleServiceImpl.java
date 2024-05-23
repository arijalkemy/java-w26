package org.example.showroom.service.impl;

import org.example.showroom.dto.clothe.ClotheResponseDto;
import org.example.showroom.dto.sale.SaleRequestDto;
import org.example.showroom.dto.sale.SaleResponseDto;
import org.example.showroom.entity.Clothe;
import org.example.showroom.entity.Sale;
import org.example.showroom.exception.NotFoundException;
import org.example.showroom.repository.ISaleRepository;
import org.example.showroom.service.IClothesService;
import org.example.showroom.service.ISaleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class SaleServiceImpl implements ISaleService {
    private final ISaleRepository saleRepository;
    private final IClothesService clothesService;

    public SaleServiceImpl(@Autowired ISaleRepository saleRepository, @Autowired IClothesService clothesService) {
        this.saleRepository = saleRepository;
        this.clothesService = clothesService;
    }

    @Override
    @Transactional
    public SaleResponseDto save(SaleRequestDto sale) {
        AtomicReference<Double> totalSale = new AtomicReference<>(0.0);
        ModelMapper modelMapper = new ModelMapper();
        List<Clothe> clothes = new ArrayList<>();
        sale.getClothes().forEach(clotheId -> {
            Clothe currentClothe = clothesService.getClotheByIdEntity(clotheId);
            clothes.add(currentClothe);
            totalSale.updateAndGet(v -> v + currentClothe.getPrice());
        });
        Sale saved = modelMapper.map(sale, Sale.class);
        // completar los campos de la venta
        saved.setTotal(totalSale.get());
        saved.setClotheList(clothes);
        // guardar en la base de datos
        return modelMapper.map(saleRepository.save(saved), SaleResponseDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public SaleResponseDto findById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Sale find = saleRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        return modelMapper.map(find, SaleResponseDto.class);
    }

    @Override
    public List<SaleResponseDto> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return saleRepository.findAll()
                .stream()
                .map(sale -> modelMapper.map(sale, SaleResponseDto.class))
                .toList();
    }

    @Override
    public SaleResponseDto update(Long id, SaleRequestDto sale) {
        return null;
    }

    @Override
    public void delete(Long id) {
        saleRepository.deleteById(id);
    }

    @Override
    public List<ClotheResponseDto> findClothes(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Sale find = saleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Sale with id " + id + " not found"));
        return find.getClotheList()
                .stream()
                .map(clothe -> modelMapper.map(clothe, ClotheResponseDto.class))
                .toList();
    }
}
