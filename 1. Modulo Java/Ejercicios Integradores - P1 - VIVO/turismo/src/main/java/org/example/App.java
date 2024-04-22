package org.example;

import org.example.Productos.Boleto;
import org.example.Productos.Comida;
import org.example.Productos.Hotel;
import org.example.Productos.Transporte;


public class App 
{
    public static void main( String[] args )
    {
        Hotel hotel1 = new Hotel("hotel1", 100);
        Boleto boleto = new Boleto("boleto1", 50);
        Comida Comida1 = new Comida("comida1", 10);
        Transporte transporte1 = new Transporte("transporte1", 40);

        Cliente cliente1 = new Cliente("cliente1", "apellido","121212");

        Paquete paquete1 = new Paquete();
        paquete1.getBoletos().add(boleto);
        paquete1.getHotels().add(hotel1);
        paquete1.getComidas().add(Comida1);
        paquete1.getTransportes().add(transporte1);


        System.out.println(paquete1.getBoletos());



    }
}
