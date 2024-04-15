package org.example;

import org.example.model.Cliente;
import org.example.repository.ClienteImp;
import org.example.repository.FacturaImp;
import org.example.repository.ItemImp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Optional;

public class Main {
    public static void main(String[] args){
        ClienteImp cliImp = new ClienteImp();
        FacturaImp factImp = new FacturaImp();
        ItemImp itImp = new ItemImp();

        //creamos 3 clientes
        Cliente cli1=new Cliente(112421L,"Alvaro","Alvarez");
        Cliente cli2=new Cliente(126671L,"Maria","Gonzalez");
        Cliente cli3=new Cliente(642186L,"Marina","Martinez");

        cliImp.save(cli1); //guardar un cliente
        cliImp.save(cli2); //guardar un cliente
        cliImp.save(cli3); //guardar un cliente
        cliImp.mostrarPantalla(); //mostrando todos los clientes

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
