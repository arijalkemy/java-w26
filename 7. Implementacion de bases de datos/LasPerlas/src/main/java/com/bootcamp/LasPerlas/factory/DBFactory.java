package com.bootcamp.LasPerlas.factory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootcamp.LasPerlas.model.Joya;
import com.bootcamp.LasPerlas.repository.IJoyaRepository;

@Component
public class DBFactory implements InitializingBean {
    @Autowired
    IJoyaRepository repository;
    
    @Override
    public void afterPropertiesSet() throws Exception {
        Joya joya1 = Joya.builder()
                    .nombre("Morada")
                    .material("Diamante morado")
                    .peso(10D)
                    .particularidad("De un juego")
                    .ventaONo(false).build();

        Joya joya2 = Joya.builder()
                    .nombre("Rosada")
                    .material("Diamante rosao")
                    .peso(10D)
                    .particularidad("De un juego osea MU")
                    .ventaONo(true).build();

        repository.save(joya1);
        repository.save(joya2);
    }
    
}
