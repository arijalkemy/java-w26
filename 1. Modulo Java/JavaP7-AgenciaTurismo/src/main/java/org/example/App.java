package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Cliente cliente1 = new Cliente("12345", "John Doe");

        Catalogo catalogo = new Catalogo();
        Repositorio repo = new Repositorio();

        // Crear primer localizador
        Localizador localizador1 = new Localizador(cliente1);

        localizador1.addPaqueteCompleto();
        localizador1.cerrarOrden(repo.filterCliente(cliente1));

        repo.addLocalizadores(localizador1);

        // Crear Segundo Localizador
        Localizador localizador2 = new Localizador(cliente1);

        localizador2.agregarProducto(catalogo.hotel);
        localizador2.agregarProducto(catalogo.hotel);
        localizador2.agregarProducto(catalogo.boletoViaje);
        localizador2.agregarProducto(catalogo.boletoViaje);
        localizador2.cerrarOrden(repo.filterCliente(cliente1));

        repo.addLocalizadores(localizador2);

        // Crear Tercer Localizador cliente 1
        Localizador localizador4 = new Localizador(cliente1);

        localizador4.agregarProducto(catalogo.comida);
        localizador4.cerrarOrden(repo.filterCliente(cliente1));

        repo.addLocalizadores(localizador4);


        System.out.println("Resultados del Repo");
        System.out.println(repo);




    }
}
