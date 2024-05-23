package com.bootcamp.joyerialasperlas.service;

import com.bootcamp.joyerialasperlas.models.Jewel;
import com.bootcamp.joyerialasperlas.repository.IJewelryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JewelryService implements IJewelryService{

    private final IJewelryRepository jewelryRepository;

    public JewelryService(IJewelryRepository jewelryRepository) {
        this.jewelryRepository = jewelryRepository;
    }

    @Override
    public Jewel addJewel(Jewel j) {
        return jewelryRepository.save(j);
    }

    @Override
    public List<Jewel> getAllJewels() {
        List<Jewel> allJewels = jewelryRepository.findAll();
        return allJewels.stream().filter(j -> j.isVentaONo() == true).collect(Collectors.toList());
    }

    @Override
    public Jewel deleteJewel(Long id) {
        Optional<Jewel>  jewelFound = jewelryRepository.findById(id);
        if (jewelFound.isEmpty()){
            throw new RuntimeException("No se encontro la joya con el id: " + id);
        }
        jewelFound.get().setVentaONo(false);
        return jewelryRepository.save(jewelFound.get());
    }

    @Override
    public Jewel modifyJewelParticularity(Long id, Jewel j) {
        Optional<Jewel>  jewelFound = jewelryRepository.findById(id);
        if (jewelFound.isEmpty()){
            throw new RuntimeException("No se encontro la joya con el id: " + id);
        }
        jewelFound.get().setParticularidad(j.getParticularidad());
        jewelFound.get().setPeso(j.getPeso());
        jewelFound.get().setNombre(j.getNombre());
        jewelFound.get().setMaterial(j.getMaterial());
        jewelFound.get().setPoseePiedra(j.isPoseePiedra());
        jewelFound.get().setVentaONo(j.isVentaONo());
        return jewelryRepository.save(jewelFound.get());
    }
}
