package com.example.showroom.service.implement;

import com.example.showroom.dto.PrendaResponseDto;
import com.example.showroom.dto.VentaDto;
import com.example.showroom.dto.VentaResponseDto;
import com.example.showroom.entity.Prenda;
import com.example.showroom.entity.Venta;
import com.example.showroom.exception.NotFoundException;
import com.example.showroom.repository.IVentaRepository;
import com.example.showroom.service.IVentaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService implements IVentaService {
    private IVentaRepository repository;
    private ObjectMapper mapper;
    public VentaService(IVentaRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public VentaResponseDto saveSale(VentaDto venta) {
        return convertToVentaResponseDto(repository.save(convertToVenta(venta)));
    }

    @Override
    public List<VentaResponseDto> findAllSales() {
        return repository.findAll().stream()
                .map(this::convertToVentaResponseDto).toList();
    }

    @Override
    public VentaResponseDto findSaleById(Long number) {
        return convertToVentaResponseDto(repository.findById(number)
                .orElseThrow(()-> new NotFoundException("No se encontro la venta")));
    }

    @Override
    public String deleteSaleById(Long number) {
        repository.deleteById(number);
        return "Se elimino con exito";
    }

    @Override
    public List<PrendaResponseDto> findClothesByDate(LocalDate date) {
        return repository.findAllPrendasByDate(date).stream()
                .map(this::convertToPrendaResponseDto).toList();
    }

    @Override
    public List<PrendaResponseDto> findClothesBySale(Long number) {
        return repository.findAllPrendasBySale(number).stream()
                .map(this::convertToPrendaResponseDto).toList();
    }

    private Venta convertToVenta(VentaDto ventaDto){
        return mapper.convertValue(ventaDto,Venta.class);
    }

    private VentaResponseDto convertToVentaResponseDto(Venta venta){
        return mapper.convertValue(venta, VentaResponseDto.class);
    }

    private PrendaResponseDto convertToPrendaResponseDto(Prenda prenda){
        return mapper.convertValue(prenda, PrendaResponseDto.class);
    }
}
