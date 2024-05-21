package com.example.joyeria.service;

import com.example.joyeria.model.Jewel;
import com.example.joyeria.repository.IJewelryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JewelryService implements IJewelryService {
    private final IJewelryRepository jewelryRepository;

    public JewelryService(IJewelryRepository jewelryRepository) {
        this.jewelryRepository = jewelryRepository;
    }

    @Override
    public ResponseEntity<?> saveJewel(Jewel jewel) {
        jewelryRepository.save(jewel);
        return ResponseEntity.status(200).body(jewel.getNro_identificatorio());
    }

    @Override
    public List<Jewel> getJewels() {
        return jewelryRepository.findByVentaONoTrue();
    }

    @Override
    public ResponseEntity<?> deleteJewel(Long id) {
        Optional<Jewel> jewelOpt = jewelryRepository.findById(id);
        if(jewelOpt.isPresent()){
            Jewel jewel = jewelOpt.get();
            jewel.setVentaONo(false);
            jewelryRepository.save(jewel);
            return ResponseEntity.ok("Joya marcada como borrada para la venta.");
        }

        return ResponseEntity.status(404).body("Joya no encontrada.");
    }

    @Override
    public ResponseEntity<?> editJewel(Long idModificar, Jewel jewel) {
        Optional<Jewel> jewelOpt = jewelryRepository.findById(idModificar);
        if(jewelOpt.isPresent()){
            Jewel jewelToEdit = jewelOpt.get();
            jewelToEdit.setNombre(jewel.getNombre());
            jewelToEdit.setMaterial(jewel.getMaterial());
            jewelToEdit.setPeso(jewel.getPeso());
            jewelToEdit.setParticularidad(jewel.getParticularidad());
            jewelToEdit.setPosee_piedra(jewel.isPosee_piedra());
            jewelToEdit.setVentaONo(jewel.isVentaONo());
            jewelryRepository.save(jewelToEdit);

            return ResponseEntity.status(200).body(jewelToEdit);
        }
        return  ResponseEntity.status(404).body("Joya no encontrada.");
    }
}
