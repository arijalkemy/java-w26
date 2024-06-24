package org.example.templatemvc.Service.in.Impl;

import lombok.RequiredArgsConstructor;
import org.example.templatemvc.DTOs.Response.PatenteMarca;
import org.example.templatemvc.Repository.Entity.Vehiculo;
import org.example.templatemvc.Repository.IVehiculoRepository;
import org.example.templatemvc.Service.in.IVehiculoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl implements IVehiculoService {

    private final IVehiculoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Vehiculo> searchAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Vehiculo create(Vehiculo vehiculo) {
        return repository.save(vehiculo);
    }

    @Override
    public List<String> listAllPlates() {
        return repository.listAllPatentes();
    }

    @Override
    public List<PatenteMarca> searchAllPatenteMarcaOrderAsc() {
        return repository.listAllPatenteMarcaOrderAsc();
    }

    @Override
    public List<String> searchAllPatentesByAnioAndCantRuedas(Integer anio) {
        return repository.listAllPatentesByAnioAndCantRuedas(anio);
    }
}
