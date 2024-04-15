package org.example;

import org.example.model.Cliente;
import org.example.model.Factura;
import org.example.model.Iteam;
import org.example.repository.ClienteImp;
import org.example.repository.FacturaImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        ClienteImp clienteImp = new ClienteImp();
        FacturaImp facturaImp = new FacturaImp();

        Cliente cliente1 = new Cliente(12345L, "pedro1", "arriaga1");
        Cliente cliente2 = new Cliente(123456L, "pedro2", "arriaga2");
        Cliente cliente3 = new Cliente(1234567L, "pedro3", "arriaga3");

        Iteam iteam1 = new Iteam(12345L, "iteam", 1, 12.2);
        List<Iteam> iteams = new ArrayList<>();
        iteams.add(iteam1);

        Factura factura1 = new Factura(12345L, cliente1,iteams, 12.1);



        //añadir
        clienteImp.save(cliente1);
        facturaImp.save(factura1);

        //mostrar
        clienteImp.mostrarPantalla();
        facturaImp.mostrarPantalla();

        Scanner teclado = new Scanner(System.in);
        System.out.println("ingresa el dni para buscar: ");
        Long dniBuscar = teclado.nextLong();
        clienteImp.buscar(dniBuscar);
        facturaImp.buscar(dniBuscar);


        System.out.println("ingresa el dni para borrar: ");
        Long dniPorBorrar = teclado.nextLong();


        clienteImp.eliminar(dniPorBorrar);
        facturaImp.eliminar(dniPorBorrar);
    }
}
