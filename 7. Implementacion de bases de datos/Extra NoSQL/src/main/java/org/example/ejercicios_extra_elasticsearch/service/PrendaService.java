package org.example.ejercicios_extra_elasticsearch.service;

import lombok.RequiredArgsConstructor;
import org.example.ejercicios_extra_elasticsearch.dto.PrendaDto;
import org.example.ejercicios_extra_elasticsearch.dto.PrendaRequestDto;
import org.example.ejercicios_extra_elasticsearch.exception.NotFoundException;
import org.example.ejercicios_extra_elasticsearch.model.Prenda;
import org.example.ejercicios_extra_elasticsearch.repository.IPrendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PrendaService implements IPrendaService, IPrendaServiceInternal {

    private final IPrendaRepository prendaRepository;

    private final ModelMapper mapper;


    @Override
    public PrendaDto crearPrenda(PrendaRequestDto prendaRequestDto) {

        Prenda nuevaPrenda = mapper.map(prendaRequestDto, Prenda.class);

        nuevaPrenda = prendaRepository.save(nuevaPrenda);

        return mapper.map(nuevaPrenda, PrendaDto.class);
    }

    @Override
    public List<PrendaDto> buscarTodasLasPrendas() {

        return prendaRepository.findAll().stream()
            .map(p -> mapper.map(p, PrendaDto.class))
            .toList();
    }

    @Override
    public PrendaDto buscarPrendaPorId(String idPrenda) {
        return mapper.map(getByIdOrThrow(idPrenda), PrendaDto.class);
    }

    @Override
    public PrendaDto actualizarPrendaPorId(String idPrenda, PrendaRequestDto prendaRequestDto) {

        Prenda prenda = getByIdOrThrow(idPrenda);

        prenda.setNombre(prendaRequestDto.getNombre());
        prenda.setTipo(prendaRequestDto.getTipo());
        prenda.setMarca(prendaRequestDto.getMarca());
        prenda.setColor(prendaRequestDto.getColor());
        prenda.setTalle(prendaRequestDto.getTalle());
        prenda.setCantidad(prendaRequestDto.getCantidad());
        prenda.setPrecioVenta(prendaRequestDto.getPrecioVenta());

        prenda = prendaRepository.save(prenda);

        return mapper.map(prenda, PrendaDto.class);
    }

    @Override
    public void eliminarPrendaPorId(String idPrenda) {

        getByIdOrThrow(idPrenda);

        prendaRepository.deleteById(idPrenda);
    }

    @Override
    public List<PrendaDto> buscarPrendasPorTamaño(String talle) {

        return prendaRepository.findByTalle(talle).stream()
            .map(p -> mapper.map(p, PrendaDto.class))
            .toList();
    }

    @Override
    public List<PrendaDto> buscarPrendasPorNombre(String nombre) {
        return prendaRepository.findByNombreContainingIgnoreCase(nombre).stream().map(
                (element) -> mapper.map(element, PrendaDto.class)
        ).collect(Collectors.toList());
    }


    public Prenda getByIdOrThrow(String idPrenda) {

        return prendaRepository.findById(idPrenda)
            .orElseThrow(() -> new NotFoundException("No se encontró una Prenda con id=" + idPrenda));
    }
}
