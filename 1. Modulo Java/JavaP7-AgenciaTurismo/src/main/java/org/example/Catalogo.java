package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Catalogo {
    public Producto hotel;
    public Producto comida;
    public Producto boletoViaje;
    public Producto transporte;



    public Catalogo() {
        this.hotel = new Producto("Hotel", 200);
        this.comida = new Producto("Comida", 300);
        this.boletoViaje = new Producto("Boleto de Viaje", 150);
        this.transporte = new Producto("Transporte", 20);
    }

    public ArrayList<Producto> listCatalogo(){
        return new ArrayList<>(Arrays.asList(hotel, comida, boletoViaje, transporte));
    }
}
