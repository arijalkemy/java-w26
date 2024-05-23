package org.example.showroomsql.service.impl;

import org.example.showroomsql.dto.RequestSaleDTO;
import org.example.showroomsql.dto.ResponseClothesDTO;
import org.example.showroomsql.dto.ResponseSaleDTO;
import org.example.showroomsql.exception.entity.NotFoundException;
import org.example.showroomsql.model.Clothes;
import org.example.showroomsql.model.Sale;
import org.example.showroomsql.repository.IClothesRepository;
import org.example.showroomsql.repository.ISaleRepository;
import org.example.showroomsql.service.ISaleService;
import org.example.showroomsql.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.example.showroomsql.util.Util.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServiceImpl implements ISaleService {

    @Autowired
    ISaleRepository saleRepository;
    @Autowired
    IClothesRepository clothesRepository;

    @Override
    public ResponseSaleDTO createSale(RequestSaleDTO request) {
        // Podria chequear si existe la ropa que esta en la venta
        request.getClothes().forEach(c -> {
            findClothesById(c.getCode());
        });

        Sale newSale = mapToSaleEntity(request);
        return mapToSaleDTO(saleRepository.save(newSale));
    }

    @Override
    public List<ResponseSaleDTO> getAllSales() {
        List<Sale> saleList = saleRepository.findAll();
        return saleList
                .stream()
                .map(Util::mapToSaleDTO)
                .toList();
    }

    @Override
    public ResponseSaleDTO getSaleByNumber(Long num) {
        Sale sale = this.findSaleById(num);
        return mapToSaleDTO(sale);
    }

    @Override
    public ResponseSaleDTO updateSale(Long num, RequestSaleDTO request) {
        this.findSaleById(num);

        Sale saleUpdate = mapToSaleEntity(request);
        saleUpdate.setNumber(num);
        saleRepository.save(saleUpdate);

        return mapToSaleDTO(saleUpdate);
    }

    @Override
    public String deleteSale(Long num) {
        this.findSaleById(num);
        saleRepository.deleteById(num);
        return "La venta con el numero " + num + " ha sido eliminado con éxito";
    }

    @Override
    public List<ResponseClothesDTO> getSalesByDate(LocalDate date) {
        List<Sale> saleList = saleRepository.findAllByDate(date);
        List<ResponseClothesDTO> clothesDTOList = new ArrayList<>();

        saleList.forEach(s -> {
            s.getClothes().forEach( c -> {
                clothesDTOList.add(mapToClothesDTO(c));
            });
        });

        return clothesDTOList;
    }

    @Override
    public List<ResponseClothesDTO> getClothesBySale(Long num) {
        Sale sale = this.findSaleById(num);
        List<ResponseClothesDTO> clothesDTOList = new ArrayList<>();

        sale.getClothes().forEach( c -> {
            clothesDTOList.add(mapToClothesDTO(c));
        });

        return clothesDTOList;
    }

    private Sale findSaleById(Long num) {
        return saleRepository.findById(num)
                .orElseThrow(
                        () -> new NotFoundException("No se encontró una venta con el numero " + num)
                );
    }

    private Clothes findClothesById(Long code) {
        return clothesRepository.findById(code)
                .orElseThrow(
                        () -> new NotFoundException("No se encontró una prenda con el codigo " + code)
                );
    }

}
