package org.example.templatemvc.Service.in.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.templatemvc.DTOs.Response.PatenteMarca;
import org.example.templatemvc.DTOs.Response.PatenteMarcaTotalPerdida;
import org.example.templatemvc.Repository.Entity.Siniestro;
import org.example.templatemvc.Repository.ISiniestroRepository;
import org.example.templatemvc.Service.in.ISiniestroService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SiniestroServiceImpl implements ISiniestroService {

    private final ISiniestroRepository repository;
    private final ObjectMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<Siniestro> searchAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Siniestro create(Siniestro request) {
        return repository.save(request);
    }

    @Override
    public List<PatenteMarca> findAllByPerdidaGreaterThan(Double perdida) {
        List<Siniestro> siniestros = repository.findAllByPerdidaGreaterThan(perdida);

        //falta terminar
        return null;
    }

    @Override
    public List<PatenteMarcaTotalPerdida> findAllPatenteMarcaSumPerdida() {
        return List.of();
    }
}
