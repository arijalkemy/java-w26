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
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor


public class SalesService implements ISalesService {
    private final SalesRepository salesRepository;
    private final ClothesRepository clothesRepository;

    //Crear una nueva venta.
    public InfoMessageDto addSale(RequestedAddSaleDto newSale) {
        //SOLO GUARDA IDS DE ROPA EXISTENTE
       salesRepository.save(mapdotToentity(newSale));
        return new InfoMessageDto("venta guardada correctamente");
    }



    //Devolver todas las ventas
    public List<RespSalesDto> getAllSales(RequestedAddSaleDto newSale) {
        ModelMapper modelMapper = new ModelMapper();
        return salesRepository.findAll().stream().map(x-> modelMapper.map(x,RespClothesDto.class)).toList();
    }
    public RespSalesDto getSalesById(Long id)
    {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Sales> optionalSales = salesRepository.findById(id);

        if (optionalSales.isEmpty())
            throw new RuntimeException("Not exist this sale");

        return modelMapper.map(optionalSales.get(), RespSalesDto.class);

    }

    //Actualizar una venta en particular

    /*Bryann*/
    //Eliminar una venta en particular
    @Override
    public InfoMessageDto deleteSaleById(Long id){
        boolean exists = salesRepository.existsById(id);
        if (!exists) {
            throw new NotFoundException("No se encontró venta con id "+id);
        }
        salesRepository.deleteById(id);
        return new InfoMessageDto("Venta con id " + id + " eliminada");

    }

    /*Bryann*/
    //Traer todas las prendas de una determinada fecha
    @Override
    public List<RespSalesDto> getSalesByDate(String date){
        ModelMapper mapper = new ModelMapper();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate filterDate = LocalDate.parse(date, formatter);
        List<Sales> responseSales = salesRepository.findAllByDateEqualsIgnoreCase(filterDate);
        return mapper.map(responseSales, new TypeToken<List<RespSalesDto>>(){}.getType());
    }

    /*Bryann*/
    //Traer la lista completa de prendas de una determinada venta.
    @Override
    public List<RespClothesDto> getClothesBySale(Long id){
        ModelMapper modelMapper = new ModelMapper();
        Optional<Sales> optionalSales = salesRepository.findById(id);

        if (optionalSales.isEmpty()) {
            throw new RuntimeException("Not exist this sale");
        }

        return optionalSales.get().getListOfClothes().stream()
                .map(x -> modelMapper.map(x, RespClothesDto.class))
                .toList();
    }

    private Sales mapdotToentity(RequestedAddSaleDto dto){
        Sales newSale = new Sales();
         double finalprice = dto.getListOfIDClothes().stream().mapToDouble(
                 d->{
                    return clothesRepository.getById(d).getPrice();
                 }
         ).sum();
        newSale.setDate(LocalDate.now());
        newSale.setTotal(finalprice);
        return newSale;

    }
}
