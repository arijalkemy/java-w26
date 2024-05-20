package com.joyerialasperlas.services.interfaces;

import com.joyerialasperlas.DTOs.JoyaDTO;
import org.springframework.http.ResponseEntity;

public interface IJoyaService {
    ResponseEntity<?> create(JoyaDTO joyaDTO);
    ResponseEntity<?> findById(Long id);
    ResponseEntity<?> findAll();
    ResponseEntity<?> update(Long id, JoyaDTO joyaDTO);
    ResponseEntity<?> delete(Long id);
}
