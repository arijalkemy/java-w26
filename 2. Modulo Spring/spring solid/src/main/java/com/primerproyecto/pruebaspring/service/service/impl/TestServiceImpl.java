package com.primerproyecto.pruebaspring.service.service.impl;

import com.primerproyecto.pruebaspring.service.ITestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements ITestService {
    @Override
    public String saludar(String name) {
        return "Hola a " + name;
    }
}
