package org.example;

import org.example.enums.Tipo_Reserva;
import org.example.repositorio.Repositorio;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        Cliente cliente = new Cliente();
        List<Reserva> paqueteCompleto = new ArrayList<Reserva>(){{
            add(new Reserva(Tipo_Reserva.COMIDA,500));
            add(new Reserva(Tipo_Reserva.HOTEL ,1000));
            add(new Reserva(Tipo_Reserva.BOLETO_DE_VIAJE, 5000));
            add(new Reserva(Tipo_Reserva.TRANSPORTE,1000));
    }};
        List<Reserva> paqueteDoble = new ArrayList<Reserva>(){{
            add(new Reserva(Tipo_Reserva.HOTEL,1000));
            add(new Reserva(Tipo_Reserva.HOTEL,1000));
            add(new Reserva(Tipo_Reserva.BOLETO_DE_VIAJE, 5000));
            add(new Reserva(Tipo_Reserva.BOLETO_DE_VIAJE,5000));
        }};
        List<Reserva> paqueteSimple = new ArrayList<Reserva>(){{
            add(new Reserva(Tipo_Reserva.HOTEL,1000));
        }};

        List<Localizador> localizadoresCliente = new ArrayList<Localizador>(){{
            add(new Localizador(cliente, paqueteCompleto));
            add(new Localizador(cliente, paqueteDoble));
            add(new Localizador(cliente, paqueteSimple));
        }};

        Repositorio repositorio = new Repositorio();

        localizadoresCliente.forEach(repositorio::agregarLocalizador);

        System.out.println(repositorio.toString());

    }
}
