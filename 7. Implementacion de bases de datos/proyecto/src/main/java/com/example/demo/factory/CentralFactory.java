package com.example.demo.factory;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Compra;
import com.example.demo.entities.CompraKey;
import com.example.demo.entities.Persona;
import com.example.demo.repository.ICompraRepository;
import com.example.demo.repository.IPersonaRepository;

@Component
public class CentralFactory implements InitializingBean {

    @Autowired
    ICompraRepository compraRepository;

    @Autowired
    IPersonaRepository personaRepository;

    @Override
    @Transactional
    public void afterPropertiesSet() throws Exception {
        Persona persona = new Persona(1000, 2, "Nilson");
        personaRepository.save(persona);
        personaRepository.flush();

        Compra compra1 = new Compra(Double.valueOf(100), CompraKey.of(persona));
        
        Compra compra2 = new Compra(Double.valueOf(200), CompraKey.of(persona));
        Compra compra3 = new Compra(Double.valueOf(300), CompraKey.of(persona));
        Compra compra4 = new Compra(Double.valueOf(400), CompraKey.of(persona));
        Compra compra5 = new Compra(Double.valueOf(500), CompraKey.of(persona));
        
        List<Compra> compras = List.of(compra1, compra2, compra3, compra4, compra5);
        
        compraRepository.saveAllAndFlush(compras);

    }
    
}
