package org.example;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        List<Localizador> listaDeLocalizadores = new ArrayList<Localizador>();

        // EJERCICIO 1
        // Crear localizador con cliente y paquete completo e imprimirlo
        Cliente cliente = new Cliente("Lautaro Oleastro");
        Paquete paqueteCompleto = new Paquete(true,true,true,true);
        Localizador localizadorUno = new Localizador(cliente, List.of(paqueteCompleto));
        System.out.println(localizadorUno.toString());

        // EJERCICIO 2
        // Crear un localizador con 2 reservas de hotel y 2 boletos para el mismo cliente.
        // Almacenar e imprimir el resultado.
        Localizador localizadorDos = new Localizador(
                cliente,
                List.of(
                        new Paquete(true, false, true, false),
                        new Paquete(true, false, true, false)
                )
        );
        System.out.println(localizadorDos.toString());

        Localizador localizadorTres = new Localizador(
                cliente,
                List.of(
                        new Paquete(true, false, false, false)
                )
        );

        System.out.println(" ------- ");

        Agencia agenciaDeTurismo = new Agencia();

        agenciaDeTurismo.agregarLocalizador(localizadorUno);
        agenciaDeTurismo.agregarLocalizador(localizadorDos);
        agenciaDeTurismo.agregarLocalizador(localizadorTres);

        agenciaDeTurismo.imprimirLocalizadores();
    }
}
