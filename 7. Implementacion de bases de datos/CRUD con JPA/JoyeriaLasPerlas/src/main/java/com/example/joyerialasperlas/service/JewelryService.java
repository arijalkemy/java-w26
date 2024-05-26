package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.model.Jewelry;
import com.example.joyerialasperlas.repository.IJewelryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelryService implements IJewelryService {
    private final IJewelryRepository jewelryRepository;

    public JewelryService(IJewelryRepository jewelryRepository) {
        this.jewelryRepository = jewelryRepository;
    }


    @Override
    public void saveJewelry(Jewelry jewelry) {
        jewelryRepository.save(jewelry);
    }

    @Override
    public List<Jewelry> getAllJewelry() {
        return jewelryRepository.findAll()
                .stream()
                .filter(j -> j.getVentaONo().equals(true))
                .toList();
    }

    @Override
    public void deleteJewelry(Long id) {
        Jewelry jewelry = jewelryRepository.findById(id).orElse(null);
        if (jewelry != null) {
            jewelry.setVentaONo(false);
            jewelryRepository.save(jewelry);
        }
    }

    @Override
    public Jewelry updateJewelry(Long id, Jewelry updatedJewelry) {
        Jewelry jewelry = jewelryRepository.findById(id).orElse(null);
        if (jewelry != null) {
            jewelry.setNombre(updatedJewelry.getNombre());
            jewelry.setMaterial(updatedJewelry.getMaterial());
            jewelry.setPeso(updatedJewelry.getPeso());
            jewelry.setParticularidad(updatedJewelry.getParticularidad());
            jewelry.setPoseePiedra(updatedJewelry.getPoseePiedra());
            jewelry.setVentaONo(updatedJewelry.getVentaONo());
        }
        jewelryRepository.save(jewelry);
        return jewelry;
    }
}
