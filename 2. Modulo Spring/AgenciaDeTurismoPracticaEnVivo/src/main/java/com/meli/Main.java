package com.meli;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

       /* List<Reserva> reservaClienteList = new ArrayList<>();
        reservaClienteList.add(new Reserva("Hotel",1000));
        reservaClienteList.add(new Reserva("Vuelo",2000));
        reservaClienteList.add(new Reserva("Comida",300));
        reservaClienteList.add(new Reserva("Transporte",40));
        Localizador localizador = new Localizador("Juan Perez", reservaClienteList);

        RepositorioCliente repositorioCliente = new RepositorioCliente();
        repositorioCliente.agregarLocalizador("Juan Perez", localizador);


        String cliente = "Juan Perez";

        List<Localizador> localizadores = repositorioCliente.obtenerLocalizadores(cliente);
        Descuentos descuentoTotal = new Descuentos();
        double descuento = descuentoTotal.calcularDescuento(localizadores);


        System.out.println("Descuento total para el cliente " + cliente + ": " + descuento);
            *
        */


        //Ejercicio parte 1

        String clienteEje1 = "Fabian Trujillo";

        // Crear un localizador con un paquete completo
        List<Reserva> paqueteCompleto = new ArrayList<>();
        paqueteCompleto.add(new Reserva("hotel", 200));
        paqueteCompleto.add(new Reserva("comida", 50));
        paqueteCompleto.add(new Reserva("boletos", 100));
        paqueteCompleto.add(new Reserva("transporte", 80));
        Localizador localizador1 = new Localizador(clienteEje1, paqueteCompleto);

        List<Reserva> localizadorConDosReservas = new ArrayList<>();
        localizadorConDosReservas.add(new Reserva("hotel", 200));
        localizadorConDosReservas.add(new Reserva("hotel", 200));
        localizadorConDosReservas.add(new Reserva("boletos", 50));
        localizadorConDosReservas.add(new Reserva("boletos", 50));
        Localizador localizador2 = new Localizador(clienteEje1, localizadorConDosReservas);


        List<Reserva> unaSolaReserva = new ArrayList<>();
        unaSolaReserva.add(new Reserva("hotel", 200));
        Localizador localizador3 = new Localizador(clienteEje1,unaSolaReserva);

        RepositorioCliente Repositorio = new RepositorioCliente();

        Repositorio.agregarLocalizador(clienteEje1, localizador1);
        Repositorio.agregarLocalizador(clienteEje1, localizador2);
        Repositorio.agregarLocalizador(clienteEje1, localizador3);

        List<Localizador> localizadoresEje1 = Repositorio.obtenerLocalizadores(clienteEje1);

        System.out.println("---------- Fabi -----");

        for(Localizador localizadores1: localizadoresEje1) {
            System.out.println("Cliente "+ localizadores1.getCliente());
            System.out.println("Reservas: " );

            for(Reserva reserva : localizadores1.getReservaList())
            {
                System.out.println("Tipo :" + reserva.getTipo());
                System.out.println("Precio: " + reserva.getPrecio());
            }

            System.out.println("Total sin descuento: " + localizadores1.getTotal());


            Descuentos descuento1 = new Descuentos();
            double descuentoTotal1 = descuento1.aplicarDescuentos(localizadores1);
            System.out.println("Descuento:" + descuentoTotal1);
            System.out.println("Total con descuento: " + (localizadores1.getTotal() - descuentoTotal1));


        }




    }

}