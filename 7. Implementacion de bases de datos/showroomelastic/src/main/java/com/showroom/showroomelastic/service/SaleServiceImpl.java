package com.showroom.showroomelastic.service;

import com.showroom.showroomelastic.dto.ClothResponseDTO;
import com.showroom.showroomelastic.dto.SaleRequestDTO;
import com.showroom.showroomelastic.dto.SaleResponseDto;
import com.showroom.showroomelastic.model.Cloth;
import com.showroom.showroomelastic.model.Sale;
import com.showroom.showroomelastic.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class SaleServiceImpl implements ISaleService{

    @Autowired
    private SalesRepository salesRepository;

    @Override
    public SaleResponseDto save(SaleRequestDTO sale) {
        Sale s = mapSale(sale);
        salesRepository.save( s );
        return mapSaleResponseDTO(s);
    }

    @Override
    public List<SaleResponseDto> getAll() {
        return salesRepository.findAll().stream().map(this::mapSaleResponseDTO).toList();
    }

    @Override
    public SaleResponseDto getById(String id) {
        return mapSaleResponseDTO(salesRepository.findById(id).get());
    }

    @Override
    public SaleResponseDto getByDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate localDate = LocalDate.parse(date, formatter);
            return mapSaleResponseDTO(salesRepository.findSaleByDate(localDate));
        } catch (DateTimeParseException e) {
            System.out.println("No se pudo parsear la fecha: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<ClothResponseDTO> getClothes(String id) {
        Sale s = salesRepository.findById(id).get();
        return s.getClothes().stream().map(ClothServiceImpl::mapClothResponseDTO).toList();
    }

    @Override
    public SaleResponseDto update(String id, SaleRequestDTO sale) {
        Sale s = mapSale(sale);
        s.setId( id );
        salesRepository.save(s);
        return mapSaleResponseDTO(s);
    }

    @Override
    public String delete(String id) {
        salesRepository.deleteById(id);
        return "Deleted Cloth with id: " + id;
    }



    private SaleResponseDto mapSaleResponseDTO(Sale sale) {
        return SaleResponseDto.builder()
                .date(sale.getDate())
                .paymentMethod(sale.getPaymentMethod())
                .totalPrice(sale.getTotalPrice())
                .build();
    }
    private Sale mapSale( SaleRequestDTO sale) {
        Sale s = new Sale();
        s.setDate( sale.getDate() );
        s.setPaymentMethod( sale.getPaymentMethod());
        s.setClothes( sale.getClothes() );
        s.setTotalPrice( s.getClothes().stream().mapToDouble(Cloth::getSellPrice).sum() );
        return s;
    }
}
