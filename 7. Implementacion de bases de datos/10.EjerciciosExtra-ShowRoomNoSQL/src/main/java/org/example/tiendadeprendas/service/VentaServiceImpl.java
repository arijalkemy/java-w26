package org.example.tiendadeprendas.service;

import org.example.tiendadeprendas.dto.PrendaDto;
import org.example.tiendadeprendas.dto.VentaDto;
import org.example.tiendadeprendas.exception.NotFoundException;
import org.example.tiendadeprendas.model.Prenda;
import org.example.tiendadeprendas.model.Venta;
import org.example.tiendadeprendas.repository.IVentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.StreamSupport;

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
    public VentaDto findByIdVenta(String idVenta) {
        return findByCode(idVenta);
    }

    public VentaDto findByCode(String code) {
        Venta venta = ventaRepository.findById(code).orElseThrow(
                () -> new NotFoundException("NO SE ENCONTRÓ LA VENTA CON EL CODIGO "+ code)
        );
        return modelMapper.map(venta, VentaDto.class);
    }

    @Override
    public void updateVenta(String idVenta, VentaDto ventaDto) {
        findByCode(idVenta);
        Venta venta = modelMapper.map(ventaDto,Venta.class);
        venta.setIdVenta(idVenta);
        ventaRepository.save(venta);
    }

    @Override
    public List<PrendaDto> findAllPrendasByVenta(String number){
        return  findByCode(number).getPrendaLista()
                .stream()
                .map(prenda ->modelMapper.map(prenda, PrendaDto.class))
                .toList();
    }

    @Override
    public void deleteVenta(String code) {
        ventaRepository.deleteById(code);
    }

    @Override
    public List<VentaDto> allVentas() {
        Iterable<Venta> iterable = ventaRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .toList()
                .stream()
                .map(venta -> modelMapper.map(venta, VentaDto.class))
                .toList();
    }

    @Override
    public List<PrendaDto> findAllPrendasByFecha(LocalDate fecha) {
        Iterable<Venta> iterable = ventaRepository.findAllByFecha(fecha);
        return StreamSupport.stream(iterable.spliterator(), false)
                .toList()
                .stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDto.class))
                .toList();
    }
}
