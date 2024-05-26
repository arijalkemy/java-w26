package com.prendas.services.impl;

import com.prendas.DTOs.request.SaleProductoRequestDTO;
import com.prendas.DTOs.request.SaleRequestDto;
import com.prendas.DTOs.response.SaleProductoResponseDTO;
import com.prendas.DTOs.response.SaleResponseDTO;
import com.prendas.exceptions.PrendaNotFound;
import com.prendas.models.Prenda;
import com.prendas.models.Venta;
import com.prendas.models.VentaPrenda;
import com.prendas.repositories.IPrendaRepository;
import com.prendas.repositories.IVentaPrendaRepository;
import com.prendas.repositories.IVentasRepository;
import com.prendas.services.IVentaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VentaServiceImpl implements IVentaService {

    private final IVentasRepository ventasRepository;
    private final IPrendaRepository prendaRepository;
    private final IVentaPrendaRepository ventaPrendaRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    @Transactional()
    public SaleResponseDTO crear(SaleRequestDto saleRequestDto) {
        Venta venta = modelMapper.map(
                saleRequestDto,
                Venta.class
        );

        List<VentaPrenda> ventaPrendas = new ArrayList<>();

        for (SaleProductoRequestDTO saleProductoRequestDTO : saleRequestDto.getListaDePrendas()){
            VentaPrenda ventaPrenda = new VentaPrenda();
            ventaPrenda.setCantidad(saleProductoRequestDTO.getCantidad());
            ventaPrenda.setPrecioUnitario(saleProductoRequestDTO.getPrecioUnitario());
            Prenda prenda = prendaRepository.findById(saleProductoRequestDTO.getPrendaId()).orElseThrow(
                    () -> new PrendaNotFound("Prenda no encontrada")
            );
            ventaPrenda.setPrenda(prenda);
            ventaPrenda.setVenta(venta);
            ventaPrenda = ventaPrendaRepository.save(ventaPrenda);
            ventaPrendas.add(ventaPrenda);
        }

        venta.setListaDePrendas(ventaPrendas);
        venta = ventasRepository.save(venta);

        return mapVentaToSaleResponseDTO(venta);
    }

    @Override
    public List<SaleResponseDTO> getAll() {
        List<Venta> ventas = ventasRepository.findAll();
        List<SaleResponseDTO> saleResponseDTOS = new ArrayList<>();
        for (Venta venta : ventas) {
            saleResponseDTOS.add(mapVentaToSaleResponseDTO(venta));
        }
        return saleResponseDTOS;
    }

    @Override
    public SaleResponseDTO findByNumber(Long number) {
        Venta venta = ventasRepository.findById(number).orElseThrow(
                () -> new RuntimeException("Prenda no encontrada")
        );
        return mapVentaToSaleResponseDTO(venta);
    }

    @Override
    public SaleResponseDTO update(Long id, SaleRequestDto saleRequestDto) {
        Venta venta = ventasRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Prenda no encontrada")
        );

        venta.setTotal(saleRequestDto.getTotal());
        venta.setMedioDePago(saleRequestDto.getMedioDePago());
        venta.setFecha(saleRequestDto.getFecha());

        venta = ventasRepository.save(venta);
        return mapVentaToSaleResponseDTO(venta);
    }

    @Override
    public void delete(Long number) {
        ventasRepository.deleteById(number);
    }

    private SaleResponseDTO mapVentaToSaleResponseDTO(Venta venta) {
        SaleResponseDTO saleResponseDTO = new SaleResponseDTO();
        saleResponseDTO.setNumber( venta.getNumber() );
        saleResponseDTO.setFecha( venta.getFecha() );
        saleResponseDTO.setTotal( venta.getTotal() );
        saleResponseDTO.setMedioDePago( venta.getMedioDePago() );
        saleResponseDTO.setListaDePrendas( venta.getListaDePrendas().stream().map( ventaPrenda -> {
            return SaleProductoResponseDTO.builder()
                    .id(ventaPrenda.getId())
                    .cantidad(ventaPrenda.getCantidad())
                    .precioUnitario(ventaPrenda.getPrecioUnitario())
                    .ventaId(ventaPrenda.getVenta().getNumber())
                    .prendaId(ventaPrenda.getPrenda().getCodigo())
                    .build();
        }).toList() );
        return saleResponseDTO;
    }
}
