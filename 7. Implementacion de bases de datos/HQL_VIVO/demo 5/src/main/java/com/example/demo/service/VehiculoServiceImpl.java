package com.example.demo.service;

import com.example.demo.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

   @Autowired
   VehiculoRepository vehiculoRepository;

    @Override
    public List<String> obtenerPatentesRegistradas() {
        return vehiculoRepository.obtenerPatentesRegistradas();
    }

}
