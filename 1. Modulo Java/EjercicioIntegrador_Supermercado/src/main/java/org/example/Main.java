package org.example;

import org.example.services.CompraService;

public class Main {

    public static void main(String[] args) {
        CompraService compraService = new CompraService();
        compraService.primeraPrueba();
        compraService.segundaPrueba();
        compraService.menu();
    }

}