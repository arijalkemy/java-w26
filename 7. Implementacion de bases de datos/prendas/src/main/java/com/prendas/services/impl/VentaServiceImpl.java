package com.prendas.services.impl;

import com.prendas.DTOs.request.SaleProductoRequestDTO;
import com.prendas.DTOs.request.SaleRequestDto;
import com.prendas.DTOs.response.PrendaResponseDTO;
import com.prendas.DTOs.response.SaleProductoResponseDTO;
import com.prendas.DTOs.response.SaleResponseDTO;
import com.prendas.exceptions.PrendaNotFoundException;
import com.prendas.exceptions.VentaNotFoundException;
import com.prendas.models.Prenda;
import com.prendas.models.Venta;
import com.prendas.models.VentaPrenda;
import com.prendas.repositories.IPrendaRepository;
import com.prendas.repositories.IVentasRepository;
import com.prendas.services.IVentaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VentaServiceImpl implements IVentaService {

    private final IVentasRepository ventasRepository;
    private final IPrendaRepository prendaRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public SaleResponseDTO crear(SaleRequestDto saleRequestDto) {
        Venta venta = mapDTOToEntity(saleRequestDto);
        ventasRepository.save(venta);
        return mapToDTO(venta);
    }

    @Override
    public List<SaleResponseDTO> getAll() {
        return this.ventasRepository
                .findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public SaleResponseDTO findByNumber(Long number) {
        return mapToDTO(getVentaById(number));
    }


    @Override
    public SaleResponseDTO update(Long id, SaleRequestDto saleRequestDto) {

        if (!this.ventasRepository.existsById(id)) {
            throw new VentaNotFoundException("Venta not found");
        }

        Venta venta = mapDTOToEntity(saleRequestDto);

        venta.setNumber(id);

        venta = this.ventasRepository.save(venta);

        return mapToDTO(venta);
    }

    @Override
    public void delete(Long number) {
        this.ventasRepository.deleteById(number);
    }

    @Override
    public List<SaleResponseDTO> findByDate(LocalDate date) {
        return this.ventasRepository
                .findByFecha(date)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public List<PrendaResponseDTO> findClothesByNumber(Long number) {
        List<Prenda> prendas = this.ventasRepository.findClothesByNumber(number);

        if(prendas.isEmpty()){
            throw new VentaNotFoundException("Venta not found or doesn't have any clothes");
        }

        List<PrendaResponseDTO> prendaResponseDTOS = prendas
                .stream()
                .map(prenda -> modelMapper.map(
                        prenda,
                        PrendaResponseDTO.class
                ))
                .toList();
        return prendaResponseDTOS;
    }

    private SaleResponseDTO mapToDTO(Venta venta) {
        return SaleResponseDTO
                .builder()
                .number(venta.getNumber())
                .fecha(venta.getFecha())
                .total(venta.getTotal())
                .medioDePago(venta.getMedioDePago())
                .listaDePrendas(venta
                        .getListaDePrendas()
                        .stream()
                        .map(ventaPrenda -> SaleProductoResponseDTO
                                .builder()
                                .id(ventaPrenda.getId())
                                .cantidad(ventaPrenda.getCantidad())
                                .precioUnitario(ventaPrenda.getPrecioUnitario())
                                .ventaId(ventaPrenda
                                        .getVenta()
                                        .getNumber())
                                .prendaId(ventaPrenda
                                        .getPrenda()
                                        .getCodigo())
                                .build())
                        .toList())
                .build();
    }

    private Venta mapDTOToEntity(SaleRequestDto saleRequestDto) {
        Venta venta = Venta
                .builder()
                .fecha(saleRequestDto.getFecha())
                .medioDePago(saleRequestDto.getMedioDePago())
                .total(saleRequestDto.getTotal())
                .build();

        for (SaleProductoRequestDTO sale : saleRequestDto.getListaDePrendas()) {
            VentaPrenda ventaPrenda = VentaPrenda
                    .builder()
                    .venta(venta)
                    .cantidad(sale.getCantidad())
                    .precioUnitario(sale.getPrecioUnitario())
                    .build();

            Prenda prenda = prendaRepository
                    .findById(sale.getPrendaId())
                    .orElseThrow(() -> new PrendaNotFoundException("Prenda not found"));

            ventaPrenda.setPrenda(prenda);

            venta.addVentaPrenda(ventaPrenda);
        }
        return venta;
    }

    private Venta getVentaById(Long number) {
        return this.ventasRepository
                .findById(number)
                .orElseThrow(() -> new PrendaNotFoundException("Venta not found"));
    }
}
