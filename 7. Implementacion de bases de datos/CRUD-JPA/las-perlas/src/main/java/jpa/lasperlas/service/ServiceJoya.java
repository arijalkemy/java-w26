package jpa.lasperlas.service;

import jpa.lasperlas.model.Joya;
import jpa.lasperlas.repository.IJoyaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceJoya implements IServiceJoya {

    private final IJoyaRepository joyaRepository;

    public ServiceJoya(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    @Transactional
    public ResponseEntity<?> crearJoya(Joya joya){
        joyaRepository.save(joya);
        return ResponseEntity.ok("nro_identificatorio: " + joya.getNroIdentificatorio());
    }



}
