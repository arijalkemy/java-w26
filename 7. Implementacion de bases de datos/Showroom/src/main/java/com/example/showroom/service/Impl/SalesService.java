package com.example.showroom.service.Impl;

import com.example.showroom.exceptions.NotFoundException;
import com.example.showroom.model.Clothes;
import com.example.showroom.model.Sales;
import com.example.showroom.model.dto.InfoMessageDto;
import com.example.showroom.model.dto.RequestedAddSaleDto;
import com.example.showroom.model.dto.RespClothesDto;
import com.example.showroom.model.dto.RespSalesDto;
import com.example.showroom.repository.ClothesRepository;
import com.example.showroom.repository.SalesRepository;
import com.example.showroom.service.ISalesService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor
public class SalesService implements ISalesService {
    private final SalesRepository salesRepository;
    private final ClothesRepository clothesRepository;

    @Override
    public InfoMessageDto addSale(RequestedAddSaleDto newSale) {
        salesRepository.save(getEntityFromDto(newSale));
        return new InfoMessageDto("venta guardada correctamente");
    }

    @Override
    public List<RespSalesDto> getAllSales() {
        ModelMapper modelMapper = new ModelMapper();
        List<Sales> allSales = salesRepository.findAll();

        return allSales.stream().map(
                x -> modelMapper.map(x, RespSalesDto.class)
        ).toList();
    }

    @Override
    public RespSalesDto getSaleById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Sales> optionalSales = salesRepository.findById(id);

        if (optionalSales.isEmpty())
            throw new NotFoundException("Not exist this sale");

        return modelMapper.map(optionalSales.get(), RespSalesDto.class);

    }

    @Override
    public RespSalesDto updateSale(Long id, RequestedAddSaleDto updatedDto) {
        ModelMapper modelMapper = new ModelMapper();
        Sales updatedSale = getEntityFromDto(updatedDto);
        updatedSale.setId(id);
        salesRepository.save(updatedSale);
        return modelMapper.map(updatedSale, RespSalesDto.class);
    }

    @Override
    public InfoMessageDto deleteSaleById(Long id) {
        boolean exists = salesRepository.existsById(id);
        if (!exists) {
            throw new NotFoundException("No se encontró venta con id " + id);
        }
        salesRepository.deleteById(id);
        return new InfoMessageDto("Venta con id " + id + " eliminada");

    }

    @Override
    public List<RespSalesDto> getSalesByDate(String date) {
        ModelMapper mapper = new ModelMapper();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate filterDate = LocalDate.parse(date, formatter);
        List<Sales> responseSales = salesRepository.findAllByDateEqualsIgnoreCase(filterDate);
        return mapper.map(responseSales, new TypeToken<List<RespSalesDto>>() {
        }.getType());
    }

    @Override
    public List<RespClothesDto> getClothesBySale(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Sales> optionalSales = salesRepository.findById(id);

        if (optionalSales.isEmpty()) {
            throw new RuntimeException("Not exist this sale");
        }

        return optionalSales.get().getListOfClothes().stream()
                .map(x -> modelMapper.map(x, RespClothesDto.class))
                .toList();
    }

    private Sales getEntityFromDto(RequestedAddSaleDto dto) {
        Sales newSale = new Sales();
        List<Clothes> clothesToAdd = new ArrayList<>();
        double totalClothePrice = dto.getListOfIDClothes().stream().mapToDouble(
                d -> {
                    Optional<Clothes> clothe = clothesRepository.findById(d);
                    clothesToAdd.add(clothe.orElse(null));
                    return clothe.map(Clothes::getPrice).orElse(0.0);
                }
        ).sum();
        clothesToAdd.removeAll(Collections.singleton(null));
        newSale.setDate(LocalDate.now());
        newSale.setTotal(totalClothePrice);
        newSale.setMethodOfPay(dto.getMethodOfPay());
        newSale.setListOfClothes(clothesToAdd);
        return newSale;

    }
}
