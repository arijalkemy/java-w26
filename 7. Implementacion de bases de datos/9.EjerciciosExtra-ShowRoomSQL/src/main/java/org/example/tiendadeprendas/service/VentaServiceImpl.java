package org.example.tiendadeprendas.service;

import org.example.tiendadeprendas.dto.PrendaDto;
import org.example.tiendadeprendas.dto.VentaDto;
import org.example.tiendadeprendas.exception.NotFoundException;
import org.example.tiendadeprendas.model.Prenda;
import org.example.tiendadeprendas.model.Venta;
import org.example.tiendadeprendas.repository.IPrendaRepository;
import org.example.tiendadeprendas.repository.IVentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaServiceImpl implements IVentaService {

    @Autowired
    IVentaRepository ventaRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public void createVenta(VentaDto ventaDto){
        Venta venta = modelMapper.map(ventaDto, Venta.class);
        ventaRepository.save(venta);
    }

    @Override
    public VentaDto findByIdVenta(Long idVenta) {
        Venta venta = ventaRepository.findById(idVenta).get();
        return modelMapper.map(venta, VentaDto.class);
    }

    public PrendaDto findByCode(Long code) {
        Venta prenda = ventaRepository.findById(code).orElseThrow(
                () -> new NotFoundException("NO SE ENCONTRÓ LA VENTA CON EL CODIGO "+ code)
        );
        return modelMapper.map(prenda, PrendaDto.class);
    }

    @Override
    public void updateVenta(Long idVenta, VentaDto ventaDto) {
        findByCode(idVenta);
        Venta venta = modelMapper.map(ventaDto,Venta.class);
        venta.setIdVenta(idVenta);
        ventaRepository.save(venta);
    }

    @Override
    public List<PrendaDto> findAllPrendasByVenta(Long number){
        return ventaRepository.findVentaByIdVenta(number)
                .getPrendaLista()
                .stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDto.class))
                .toList();
    }

    @Override
    public void deleteVenta(Long code) {
        ventaRepository.deleteById(code);
    }

    @Override
    public List<VentaDto> allVentas() {
        return ventaRepository.findAll()
                .stream()
                .map(venta -> modelMapper.map(venta, VentaDto.class))
                .toList();
    }

    @Override
    public List<PrendaDto> findAllPrendasByFecha(LocalDate fecha) {
        return ventaRepository.findAllByFecha(fecha)
                .stream()
                .map(s -> modelMapper.map(s, PrendaDto.class))
                .collect(Collectors.toList());
    }
}
