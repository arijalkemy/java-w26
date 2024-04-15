package com.example.c1iniciandospring.service;


import org.springframework.stereotype.Service;

@Service
public class SaludarServiceImpl implements ISaludarService{

        @Override
        public String saludar(String nombre) {
            return "Hola Mundo "+ nombre;
        }
}
