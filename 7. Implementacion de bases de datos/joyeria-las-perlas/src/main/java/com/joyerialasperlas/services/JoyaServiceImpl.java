package com.joyerialasperlas.services;

import com.joyerialasperlas.DTOs.JoyaDTO;
import com.joyerialasperlas.DTOs.JoyaResponseDTO;
import com.joyerialasperlas.exceptions.JoyaNotFound;
import com.joyerialasperlas.models.Joya;
import com.joyerialasperlas.repositories.IJoyaRepository;
import com.joyerialasperlas.services.interfaces.IJoyaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JoyaServiceImpl implements IJoyaService {

    IJoyaRepository joyaRepository;

    public JoyaServiceImpl(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    @Transactional
    public ResponseEntity<?> create(JoyaDTO joyaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Joya newJoya = modelMapper.map(joyaDTO, Joya.class);

        newJoya = joyaRepository.save(newJoya);

        return new ResponseEntity<>(
                modelMapper.map(newJoya, JoyaResponseDTO.class),
                HttpStatus.CREATED
        );
    }

    @Override
    @Transactional
    public ResponseEntity<?> findById(Long id) {
        Joya joya = this.getJoyaById(id);

        return new ResponseEntity<>(
                joya,
                HttpStatus.OK
        );
    }

    @Override
    @Transactional
    public ResponseEntity<?> findAll() {

        List<Joya> filteredJoyas = joyaRepository.findAll().stream()
                .filter(Joya::getVentaONo)
                .toList();

        return new ResponseEntity<>(
                filteredJoyas,
                HttpStatus.OK
        );
    }

    @Override
    @Transactional
    public ResponseEntity<?> update(Long id, JoyaDTO joyaDTO) {
        if(joyaRepository.existsById(id)){
            ModelMapper modelMapper = new ModelMapper();
            Joya joyaUpdated = modelMapper.map(joyaDTO, Joya.class);
            joyaUpdated.setId(id);
            joyaRepository.save(joyaUpdated);
            return new ResponseEntity<>(
                    joyaUpdated,
                    HttpStatus.OK
            );
        } else {
            throw new JoyaNotFound("Joya not found");
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> delete(Long id) {

        Joya joya = getJoyaById(id);

        joya.setVentaONo(false);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private Joya getJoyaById(Long id){
        return joyaRepository
                .findById(id)
                .orElseThrow(()-> new JoyaNotFound("Joya not found"));
    }
}
