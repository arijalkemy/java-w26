package org.example;

import org.example.model.Cliente;

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
        Cliente cliente1 = new Cliente(123455L,"Jose","Guzman");
        Cliente cliente2 = new Cliente(103344L,"Andres","Quevedo");
        Cliente cliente3 = new Cliente(155653L,"Johan","Munoz");

        List<Cliente> clienteList = new ArrayList<>();
        clienteList.add(cliente1);
        clienteList.add(cliente2);
        clienteList.add(cliente3);

        for (Cliente c : clienteList){
            System.out.println("Dni: "+c.getDni());
            System.out.println("Nombre: "+c.getNombre());
            System.out.println("Apellido: "+c.getApellido());
        }

        Scanner teclado = new Scanner(System.in);
        Long dniBorrar = teclado.nextLong();
        boolean isCliente = false;
        for (Cliente c : clienteList){
            if(c.getDni().equals(dniBorrar)){
                clienteList.remove(c);
                isCliente = true;
                break;
            }
        }
        if (isCliente){
            System.out.println("Se ha eliminado el cliente exitosamente!!!");
        }else {
            System.out.println("No se encontro el cliente, verifique los datos e intentelo de nuevo.");
        }
        Long dniBuscar = teclado.nextLong();
        isCliente = false;
        for (Cliente c : clienteList){
            if (c.getDni().equals(dniBuscar)){
                System.out.println("------ Cliente encontrado!!! ------");
                System.out.println("Dni: "+c.getDni());
                System.out.println("Nombre: "+c.getNombre());
                System.out.println("Apellido: "+c.getApellido());
                isCliente = true;
                break;
            }
        }
        if (isCliente){
            System.out.println("Se ha encontrado el cliente exitosamente!!!");
        }else {
            System.out.println("No se encontro el cliente, verifique los datos e intentelo de nuevo.");
        }
    }
}
