package com.practicasextra.showroom.service;

import com.practicasextra.showroom.model.Prenda;
import com.practicasextra.showroom.repository.PrendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrendaService implements IPrendaService {
    @Autowired
    private PrendaRepository prendaRepository;


    public Prenda guardar(Prenda prenda) {
        return prendaRepository.save(prenda);
    }

    public Prenda findByCodigo(Long codigo) {
        Optional<Prenda> prenda = prendaRepository.findById(codigo);
        return prenda.orElse(null);
    }

    @Override
    public List<Prenda> findAll() {
        return prendaRepository.findAll();
    }

    public Prenda actualizar(Prenda prenda) {
        prendaRepository.findById(prenda.getCodigo());
        return prendaRepository.save(prenda);
    }

    public void eliminar(Long codigo) {
        prendaRepository.deleteById(codigo);
    }

    public List<Prenda> findAllByTalle(String talle) {
        return prendaRepository.findAllByTalle(talle);
    }

    public List<Prenda> findAllByNombreContaining(String nombre) {
        return prendaRepository.findByNombreContainingIgnoreCase(nombre);
    }
}
