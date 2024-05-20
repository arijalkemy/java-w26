package com.example.joyeria.service;

import com.example.joyeria.model.Joyeria;
import com.example.joyeria.repository.IJoyeriaRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JoyeriaService implements IJoyeriaservice{
    private final IJoyeriaRepositorio iJoyeriaRepositorio;

    public JoyeriaService(IJoyeriaRepositorio iJoyeriaRepositorio) {
        this.iJoyeriaRepositorio = iJoyeriaRepositorio;
    }
    /*Dos*/
    @Override
    @Transactional(readOnly = true)
    public List<Joyeria> getJewerly() {
        return iJoyeriaRepositorio.findByVentaONoTrue();
    }
    /*1*/
    @Override
    @Transactional
    public void saveJewerly(Joyeria joya) {
        iJoyeriaRepositorio.save(joya);
    }

    @Override
    @Transactional
    public Joyeria editJewerly (Joyeria joya){
        Joyeria existingJoyeria = iJoyeriaRepositorio.findById(joya.getNroIdentificatorio())
                .orElseThrow(() -> new EntityNotFoundException("Joyería no encontrada con ID: " + joya.getNroIdentificatorio()));

        // Copiar propiedades de `joya` a `existingJoyeria` aquí, si es necesario
        existingJoyeria.setNombre(joya.getNombre());
        existingJoyeria.setMaterial(joya.getMaterial());
        existingJoyeria.setPeso(joya.getPeso());
        existingJoyeria.setParticularidad(joya.getParticularidad());
        existingJoyeria.setPoseePiedra(joya.getPoseePiedra());
        existingJoyeria.setVentaONo(joya.getVentaONo());

        return iJoyeriaRepositorio.save(existingJoyeria);
    }


    /*3*/
    @Override
    @Transactional
    public void deleteJewerly(long nroIdentificatorio) {
        Optional<Joyeria> joyeriaOptional = iJoyeriaRepositorio.findById(nroIdentificatorio);
        if(joyeriaOptional.isPresent()){
            Joyeria joyeria = joyeriaOptional.get();
            joyeria.setVentaONo(false);
            iJoyeriaRepositorio.save(joyeria);
        }else{
            throw new EntityNotFoundException("Joyeria no encontrada con ID: "+nroIdentificatorio);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Joyeria findJewerly(long nroIdentificatorio) {
        Joyeria jewerly=iJoyeriaRepositorio.findById(nroIdentificatorio).orElse(null);
        return jewerly;
    }

}
