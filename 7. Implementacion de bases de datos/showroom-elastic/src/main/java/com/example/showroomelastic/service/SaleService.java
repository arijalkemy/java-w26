package com.example.showroomelastic.service;

import com.example.showroomelastic.dto.SaleRequestDto;
import com.example.showroomelastic.dto.SaleResponseDto;
import com.example.showroomelastic.models.Sale;
import com.example.showroomelastic.repository.ISaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService implements ISaleService {

    @Autowired
    ISaleRepository saleRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public SaleResponseDto createSale(SaleRequestDto ventaRequestDto) {
        return modelMapper.map(saleRepository.save(modelMapper.map(ventaRequestDto, Sale.class)), SaleResponseDto.class);
    }

    @Override
    public List<SaleResponseDto> getSales() {
        return saleRepository
                .findAll()
                .stream()
                .map(element -> modelMapper.map(element, SaleResponseDto.class))
                .toList();
    }

    @Override
    public SaleResponseDto getSaleById(String id) {

        if(!isExist(id))
            throw new RuntimeException("La venta no existe");

        return modelMapper.map(saleRepository.findById(id), SaleResponseDto.class);
    }

    @Override
    public SaleResponseDto updateSale(String id, SaleRequestDto ventaRequestDto) {
        if(!isExist(id))
            throw new RuntimeException("La venta no existe");

        Sale sale = modelMapper.map(ventaRequestDto, Sale.class);
        sale.setId(id);
        saleRepository.save(sale);

        return modelMapper.map(sale, SaleResponseDto.class);
    }

    @Override
    public String deleteSale(String id) {
        if(!isExist(id))
            throw new RuntimeException("La venta no existe");
        saleRepository.deleteById(id);
        return "Sale deleted successfully";
    }

    @Override
    public List<SaleResponseDto> searchByDate(String date) {

        return saleRepository.findByFecha(LocalDate.parse(date))
                .stream()
                .map(element -> modelMapper.map(element, SaleResponseDto.class))
                .toList();

    }

    @Override
    public SaleResponseDto searchByNumber(String number) {
        return modelMapper.map(saleRepository.findByNumero(number), SaleResponseDto.class);
    }
    private Boolean isExist(String id) {
        return saleRepository.existsById(id);
    }
}
