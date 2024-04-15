package org.example;

import org.example.Productos.*;

import java.util.ArrayList;
import java.util.List;

public class Paquete {
    private List<Hotel> hotels = new ArrayList<>();
    private List<Comida> comidas  = new ArrayList<>();
    private List<Transporte> transportes = new ArrayList<>();
    private List<Boleto> boletos = new ArrayList<>();

    public Paquete() {
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

    public int calcularDescuentoPaquete(){
        int descuentoTotal = 0;
        if(!this.hotels.isEmpty() && !this.comidas.isEmpty() && !this.transportes.isEmpty() && !this.boletos.isEmpty()){
            descuentoTotal = descuentoTotal + 10;

        }

        if( this.hotels.size() >= 2 || this.boletos.size() >= 2){
            descuentoTotal = descuentoTotal + 5;
        }
        return descuentoTotal;
    }

    public double costoTotal(){

        double totalHoteles = this.hotels.stream().mapToDouble(Producto::getPrecio).sum();
        double totalComidas = this.comidas.stream().mapToDouble(Producto::getPrecio).sum();
        double totalTransportes = this.transportes.stream().mapToDouble(Producto::getPrecio).sum();
        double totalBoletos = this.boletos.stream().mapToDouble(Producto::getPrecio).sum();


        return totalHoteles + totalComidas + totalTransportes + totalBoletos;
    }
}
