package jpa.lasperlas.service;

import jpa.lasperlas.model.Joya;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface IServiceJoya {
    ResponseEntity<?> crearJoya(Joya joya);
}
