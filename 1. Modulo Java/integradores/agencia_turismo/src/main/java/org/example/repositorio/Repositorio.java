package org.example.repositorio;

import org.example.Cliente;
import org.example.Localizador;
import org.example.Reserva;
import org.example.enums.Tipo_Reserva;

import java.util.*;
import java.util.stream.Collectors;

public class Repositorio {
    List<Localizador> localizadores = new ArrayList<>();
    public List<Cliente>  clientes = new ArrayList<>();

    public Repositorio() {}

    public List<Localizador> getLocalizadorList() {
        return localizadores;
    }

    public void agregarLocalizador(Localizador localizador){
        if(!clientes.contains(localizador.getCliente())){
            clientes.add(localizador.getCliente());
        } // si el cliente no existe lo agrega a la lista.
        aplicarDescuentos(localizador);
        localizadores.add(localizador);
    }

    private List<Localizador> filtrarLocalizadoresCliente(Cliente cliente){
        return localizadores.stream()
                .filter(localizador -> localizador.getCliente().equals(cliente))
                .collect(Collectors.toList());
    }

    private void aplicarDescuentos(Localizador localizador){
        double descuentos = 0;
        if(localizador.esPaqueteCompleto()){
            descuentos += 0.1; //descuenta el 10% a paquetes completos
            System.out.println("aplicado descuenta el 10% a paquetes completos");
        }
        if(localizador.esReservaDobleHotelOViaje()){
            descuentos +=0.05; //descuenta 5% a paquetes dobles
            System.out.println("aplicado descuenta el 5% a paquetes dobles");
        }
        if(filtrarLocalizadoresCliente(localizador.getCliente()).size() >= 2){
            descuentos += 0.1; //descuenta 10% si ya tiene dos localizadores
            System.out.println("aplicado descuenta el 10% a cliente leal");
        }
        localizador.setDescuento(descuentos);
    }

    @Override
    public String toString() {
        return "Repositorio{" +
                "localizadores=" + localizadores +
                ", clientes=" + clientes +
                '}';
    }
}
