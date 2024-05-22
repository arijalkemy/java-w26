package com.example.showroom.service.Impl;

import com.example.showroom.exceptions.NotFoundException;
import com.example.showroom.model.Clothes;
import com.example.showroom.model.Sales;
import com.example.showroom.model.dto.*;
import com.example.showroom.repository.ClothesRepository;
import com.example.showroom.repository.SalesRepository;
import com.example.showroom.service.ISalesService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalesService implements ISalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private ClothesRepository clothesRepository;

    public InfoMessageDto addSale(RequestedAddSaleDto newSale) {
        salesRepository.save(dtoToEntity(newSale));
        return new InfoMessageDto("venta guardada correctamente");
    }

    public List<RespSalesDto> getAllSales() {
        ModelMapper modelMapper = new ModelMapper();
        return salesRepository.findAll().stream().map(x-> modelMapper.map(x,RespSalesDto.class)).toList();
    }

    public RespSalesDto getSalesById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Sales> optionalSales = salesRepository.findById(id);

        if (optionalSales.isEmpty())
            throw new NotFoundException("No se encontró venta con id "+id);

        return modelMapper.map(optionalSales.get(), RespSalesDto.class);
    }


    @Override
    public InfoMessageDto updateSale(RequestUpdateSaleDto updatedSale) {
        Optional<Sales> optionalSales = salesRepository.findById(updatedSale.getId());

        if (optionalSales.isEmpty()) {
            return new InfoMessageDto("No se encontró venta con id " + updatedSale.getId());
        }

        Sales sale = optionalSales.get();
        double finalPrice = updatedSale.getListOfIDClothes().stream()
                .mapToDouble(clothesId -> clothesRepository.findById(clothesId)
                        .map(Clothes::getPrice)
                        .orElse(0.0))
                .sum();

        List<Clothes> clothesList = clothesRepository.findAllById(updatedSale.getListOfIDClothes());

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(updatedSale, sale);

        sale.setListOfClothes(clothesList);
        sale.setTotal(finalPrice);

        salesRepository.save(sale);
        return new InfoMessageDto("Venta con id " + updatedSale.getId() + " actualizada");
    }



    @Override
    public InfoMessageDto deleteSaleById(Long id){
        Optional<Sales> sale = salesRepository.findById(id);
        if (sale.isEmpty())
            return new InfoMessageDto("No se encontró venta con id "+id);

        Sales saleEntity = sale.get();
        saleEntity.getListOfClothes().clear();
        salesRepository.save(saleEntity);

        salesRepository.delete(saleEntity);
        return new InfoMessageDto("Venta con id " + id + " eliminada");
    }

    @Override
    public List<RespSalesDto> getSalesByDate(String date){
        ModelMapper mapper = new ModelMapper();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate filterDate = LocalDate.parse(date, formatter);
        List<Sales> responseSales = salesRepository.findAllByDate(filterDate);
        return mapper.map(responseSales, new TypeToken<List<RespSalesDto>>(){}.getType());
    }

    @Override
    public List<RespClothesDto> getClothesBySale(Long id){
        ModelMapper modelMapper = new ModelMapper();
        Optional<Sales> optionalSales = salesRepository.findById(id);

        if (optionalSales.isEmpty())
            throw new NotFoundException("No se encontró venta con id "+id);

        return optionalSales.map(sales -> sales.getListOfClothes().stream()
                .map(x -> modelMapper.map(x, RespClothesDto.class))
                .toList()).orElseGet(ArrayList::new);

    }

    private Sales dtoToEntity(RequestedAddSaleDto dto){
        Sales newSale = new Sales();
        double finalPrice = dto.getListOfIDClothes().stream()
                .mapToDouble(id -> clothesRepository.findById(id)
                        .map(Clothes::getPrice)
                        .orElse(0.0)) // puedes manejar el caso en el que no se encuentra la prenda de ropa como prefieras
                .sum();
        newSale.setDate(dto.getDate());
        newSale.setTotal(dto.getTotal());

        // Buscar las prendas por sus IDs y establecer la lista de prendas para la venta
        List<Clothes> clothesList = clothesRepository.findAllById(dto.getListOfIDClothes());
        newSale.setListOfClothes(clothesList);

        return newSale;
    }
}