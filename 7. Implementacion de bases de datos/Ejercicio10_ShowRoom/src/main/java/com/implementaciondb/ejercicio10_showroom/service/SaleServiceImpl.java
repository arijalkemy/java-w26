package com.implementaciondb.ejercicio10_showroom.service;

import com.implementaciondb.ejercicio10_showroom.exception.NotFoundException;
import com.implementaciondb.ejercicio10_showroom.mapper.GarmentMapper;
import com.implementaciondb.ejercicio10_showroom.mapper.SaleMapper;
import com.implementaciondb.ejercicio10_showroom.model.dto.Garment.GarmentResponseDto;
import com.implementaciondb.ejercicio10_showroom.model.dto.Sale.SaleDetailRequestDto;
import com.implementaciondb.ejercicio10_showroom.model.dto.Sale.SaleRequestDto;
import com.implementaciondb.ejercicio10_showroom.model.dto.Sale.SaleResponseDto;
import com.implementaciondb.ejercicio10_showroom.model.entity.Garment;
import com.implementaciondb.ejercicio10_showroom.model.entity.Sale;
import com.implementaciondb.ejercicio10_showroom.repository.IGarmentRepository;
import com.implementaciondb.ejercicio10_showroom.repository.ISaleDatailRepository;
import com.implementaciondb.ejercicio10_showroom.repository.ISaleRepository;
import com.implementaciondb.ejercicio10_showroom.service.interfaces.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleServiceImpl implements ISaleService {

    @Autowired
    private ISaleRepository saleRepository;

    @Autowired
    private ISaleDatailRepository saleDatailRepository;

    @Autowired
    private IGarmentRepository garmentRepository;

    @Override
    public SaleResponseDto saveSale(SaleRequestDto saleRequestDto) {
        for(SaleDetailRequestDto sdrd: saleRequestDto.getSaleDetails()) {
            if (garmentRepository.findById(sdrd.getGarment().getCode()).isEmpty()) {
                throw new NotFoundException("Una o varias prendas no están registradas");
            }
        }
        Sale sale = saleRepository.save(SaleMapper.mapToSale(saleRequestDto));
        return SaleMapper.mapToSaleResponseDto(sale);
    }

    @Override
    public List<SaleResponseDto> findAllSales() {
        List<Sale> sales  = saleRepository.findAll();
        return getResponsesDto(sales);
    }

    @Override
    public SaleResponseDto findSaleById(Long number) {
        Sale sale = saleRepository.findById(number).orElseThrow(
                () -> new NotFoundException("Venta no encontrada")
        );
        return SaleMapper.mapToSaleResponseDto(sale);
    }

    @Override
    public SaleResponseDto deleteSaleById(Long number) {
        SaleResponseDto saleResponseDto = findSaleById(number);
        saleRepository.deleteById(number);
        return saleResponseDto;
    }

    @Override
    public List<GarmentResponseDto> findClothesByDate(LocalDate date) {
        List<Garment> garments = saleRepository.findAllClothesByDate(date);
        return GarmentMapper.mapToGarmentResponseDtoList(garments);
    }

    @Override
    public List<GarmentResponseDto> findClothesBySale(Long number) {
        List<Garment> garments = saleRepository.findAllClothesBySale(number);
        return GarmentMapper.mapToGarmentResponseDtoList(garments);
    }

    private List<SaleResponseDto> getResponsesDto(List<Sale> sales) {
        if (sales.isEmpty()) {
            throw new NotFoundException("No se encontraron ventas");
        }
        return sales.stream().map(SaleMapper::mapToSaleResponseDto).toList();
    }

}
