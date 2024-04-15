package com6.NumerosRomanos.Services.Impl;

import com6.NumerosRomanos.Services.IPresentadorDeNumeros;
import org.springframework.stereotype.Service;

@Service
public class PresentadorDeNumerosImpl implements IPresentadorDeNumeros {

    @Override
    public String presentar(int numeroEntero, String numeroRomano) {
        return numeroEntero + " en Romano se escribe: " + numeroRomano;
    }
}
