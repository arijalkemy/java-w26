package org.example.ejercicios_extra_elasticsearch.service;

import lombok.RequiredArgsConstructor;
import org.example.ejercicios_extra_elasticsearch.dto.VentaDto;
import org.example.ejercicios_extra_elasticsearch.dto.VentaRequestDto;
import org.example.ejercicios_extra_elasticsearch.exception.NotFoundException;
import org.example.ejercicios_extra_elasticsearch.model.Prenda;
import org.example.ejercicios_extra_elasticsearch.model.Venta;
import org.example.ejercicios_extra_elasticsearch.repository.IVentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VentaService implements IVentaService {

    private final IVentaRepository ventaRepository;

    private final IPrendaServiceInternal prendaServiceInternal;

    private final ModelMapper mapper;

    @Override
    public VentaDto crearVenta(VentaRequestDto ventaRequestDto) {
        Venta nuevaVenta = mapper.map(ventaRequestDto, Venta.class);
        List<Prenda> listaDePrendas = ventaRequestDto.getIdPrendas().stream().map(
                prendaServiceInternal::getByIdOrThrow
        ).toList();
        BigDecimal total = BigDecimal.ZERO;
        for (Prenda p: listaDePrendas) {
            total = total.add(p.getPrecioVenta());
        }
        nuevaVenta.setPrendas(listaDePrendas);
        nuevaVenta.setTotal(total);
        ventaRepository.save(nuevaVenta);
        return mapper.map(nuevaVenta, VentaDto.class);
    }

    @Override
    public List<VentaDto> buscarTodasLasVentas() {
        return ventaRepository.findAll().stream().map(
                (element) -> mapper.map(element, VentaDto.class)
        ).toList();
    }

    @Override
    public VentaDto buscarVentaPorId(String id) {
        return mapper.map(getByIdOrThrow(id), VentaDto.class);
    }

    public Venta getByIdOrThrow(String idVenta) {

        return ventaRepository.findById(idVenta)
                .orElseThrow(() -> new NotFoundException("No se encontró una Venta con id=" + idVenta));
    }
}
