package org.example;

import org.example.Productos.Boleto;
import org.example.Productos.Comida;
import org.example.Productos.Hotel;
import org.example.Productos.Transporte;

import java.util.ArrayList;
import java.util.List;

public class Paquete {
    private List<Hotel> hotels = new ArrayList();
    private List<Comida> comidas  = new ArrayList();
    private List<Transporte> transportes = new ArrayList();
    private List<Boleto> boletos = new ArrayList();

    public Paquete() {
    }

    public Paquete(List<Hotel> hotels, List<Comida> comidas, List<Transporte> transportes, List<Boleto> boletos) {
        this.hotels = hotels;
        this.comidas = comidas;
        this.transportes = transportes;
        this.boletos = boletos;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public List<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(List<Comida> comidas) {
        this.comidas = comidas;
    }

    public List<Transporte> getTransportes() {
        return transportes;
    }

    public void setTransportes(List<Transporte> transportes) {
        this.transportes = transportes;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }
}
