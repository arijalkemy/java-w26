package org.bootcamp;

import org.bootcamp.model.Cliente;
import org.bootcamp.repository.ClienteImp;
import org.bootcamp.repository.FacturaImp;
import org.bootcamp.repository.ItemImp;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) {
        ClienteImp cliImp = new ClienteImp();
        FacturaImp factImp = new FacturaImp();
        ItemImp itImp = new ItemImp();

        Cliente cli1 = new Cliente(12365458L, "Luisina", "de Paula");
        Cliente cli2 = new Cliente(65987456L, "Zlatan", "Ibrahimovic");
        Cliente cli3 = new Cliente(11254789L, "Avril", "Lavigne");

        cliImp.save(cli1);
        cliImp.save(cli2);
        cliImp.save(cli3);
        cliImp.mostrarPantalla();

        //búsqueda del cliente
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni a buscar");
        Long dniBuscado = teclado.nextLong();
        cliImp.buscar(dniBuscado);

        //borrado del cliente
        System.out.println("Ingrese el dni a buscar para eliminar");
        Long dniBorrado = teclado.nextLong();
        cliImp.eliminar(dniBorrado);
    }
}
