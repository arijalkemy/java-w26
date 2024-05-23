package com.ejerciciosjpa.extrajpa.service.implementation;

import com.ejerciciosjpa.extrajpa.dto.ClothResponseDto;
import com.ejerciciosjpa.extrajpa.dto.SaleRequestDto;
import com.ejerciciosjpa.extrajpa.dto.SaleResponseDto;
import com.ejerciciosjpa.extrajpa.entities.Cloth;
import com.ejerciciosjpa.extrajpa.entities.Sale;
import com.ejerciciosjpa.extrajpa.repository.ISaleRepository;
import com.ejerciciosjpa.extrajpa.service.ISaleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleServiceImpl implements ISaleService {
    @Autowired
    ISaleRepository saleRepository;

    ModelMapper mapper = new ModelMapper();
    @Override
    public SaleResponseDto createSale(SaleRequestDto request) {
        Sale response = saleRepository.save(mapper.map(request,Sale.class));
        return mapper.map(response,SaleResponseDto.class);
    }

    @Override
    public List<SaleResponseDto> getAllSales() {
        return saleRepository.findAll().stream().map(e->mapper.map(e,SaleResponseDto.class)).toList();
    }

    @Override
    public SaleResponseDto getSaleById(Long number) {
        return mapper.map(saleRepository.findByNumero(number),SaleResponseDto.class);
    }

    @Override
    public SaleResponseDto updateSale(Long number, SaleRequestDto request) {
        Sale sale = mapper.map(getSaleById(number),Sale.class);

        sale.setNumero(sale.getNumero());
        sale.setFecha(request.getFecha());
        sale.setTotal(request.getTotal());
        sale.setMedioDePago(request.getMedioDePago());
        sale.setClothes(request.getClothes());

        Sale response = saleRepository.save(sale);
        return mapper.map(response,SaleResponseDto.class);
    }

    @Override
    public void deleteSale(Long number) {
        saleRepository.deleteById(number);
    }

    @Override
    public List<SaleResponseDto> getAllSalesByDate(LocalDate date) {
        return saleRepository.findSalesByFechaEquals(date).stream().map(e->mapper.map(e,SaleResponseDto.class)).toList();
    }

    @Override
    public List<ClothResponseDto> getAllClothesBySale(Long number) {
        return saleRepository.findSalesByClothesAndNumero(number).stream().map(e->mapper.map(e,ClothResponseDto.class)).toList();
    }
}
