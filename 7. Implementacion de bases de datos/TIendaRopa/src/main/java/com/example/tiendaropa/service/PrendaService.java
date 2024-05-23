package com.example.tiendaropa.service;

import com.example.tiendaropa.models.Dto.PrendaRequestDto;
import com.example.tiendaropa.models.Dto.PrendaResponseDto;
import com.example.tiendaropa.models.Prenda;
import com.example.tiendaropa.repository.IPrendaRepository;
import com.example.tiendaropa.utils.PrendaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrendaService implements IPrendaService {

    private final IPrendaRepository prendaRepository;

    public PrendaService(IPrendaRepository prendaRepository) {
        this.prendaRepository = prendaRepository;
    }


    @Override
    public PrendaResponseDto postNewPrenda(PrendaRequestDto prenda) {
        Prenda newPrenda = PrendaMapper.mapToPrenda(prenda);

        Prenda prendaAdded = prendaRepository.save(newPrenda);

        PrendaResponseDto response = PrendaMapper.mapToPrendaResponseDto(prendaAdded);

        return response;
    }

    @Override
    public List<PrendaResponseDto> getAllPrendas() {

        List<Prenda> allPrendas = prendaRepository.findAll();

        List<PrendaResponseDto> responseList = allPrendas.stream().map(p ->
                PrendaMapper.mapToPrendaResponseDto(p)).collect(Collectors.toList());
        return responseList;
    }

    @Override
    public PrendaResponseDto findPrendaById(Long id) {
        Optional<Prenda> p = prendaRepository.findById(id);
        if (p.isEmpty()) {
            throw new RuntimeException("No se encontro la prenda con el id:" + id);
        }
        PrendaResponseDto response = PrendaMapper.mapToPrendaResponseDto(p.get());
        return response;
    }

    @Override
    public PrendaResponseDto updatePrenda(Long id, PrendaRequestDto prenda) {
        Optional<Prenda> p = prendaRepository.findById(id);
        if (p.isEmpty()) {
            throw new RuntimeException("No se encontro la prenda con el id:" + id);
        }
        Prenda prendaFound = p.get();

        prendaFound.setCantidad(prenda.getCantidad());
        prendaFound.setColor(prenda.getColor());
        prendaFound.setNombre(prenda.getNombre());
        prendaFound.setMarca(prenda.getMarca());
        prendaFound.setTipo(prenda.getTipo());
        prendaFound.setPrecioVenta(prenda.getPrecioVenta());
        prendaFound.setTalla(prenda.getTalla());

        Prenda pUpdated = prendaRepository.save(prendaFound);
        PrendaResponseDto response = PrendaMapper.mapToPrendaResponseDto(pUpdated);

        return response;
    }

    @Override
    public String deletePrenda(Long id) {
        Optional<Prenda> p = prendaRepository.findById(id);
        if (p.isEmpty()) {
            throw new RuntimeException("No se encontro la prenda con el id:" + id);
        }
        prendaRepository.delete(p.get());
        return "Prenda eliminada correctamente";
    }

    @Override
    public List<PrendaResponseDto> findPrendasBySize(String talla) {
        List<PrendaResponseDto> prendasFound = prendaRepository.findPrendasByTalla(talla).stream()
                .map(p -> PrendaMapper.mapToPrendaResponseDto(p))
                .collect(Collectors.toList());
        return prendasFound;
    }

    @Override
    public List<PrendaResponseDto> findByName(String name) {
        List<PrendaResponseDto> prendasFound = prendaRepository.findPrendasByNombreContainingIgnoreCase(name).stream()
                .map(p -> PrendaMapper.mapToPrendaResponseDto(p))
                .collect(Collectors.toList());
        return prendasFound;
    }
}
