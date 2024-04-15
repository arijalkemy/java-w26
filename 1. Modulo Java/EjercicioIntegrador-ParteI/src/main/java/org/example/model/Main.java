package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Cliente cli1=new Cliente(112421L,"Alvaro","Alvarez");
        Cliente cli2=new Cliente(126671L,"Maria","Gonzalez");
        Cliente cli3=new Cliente(642186L,"Marina","Martinez");
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(cli1);
        listaClientes.add(cli2);
        listaClientes.add(cli3 );
        for (Cliente c : listaClientes){
            System.out.println("DNI:"+c.getDni());
            System.out.println("NOMBRE:"+c.getNombre());
            System.out.println("APELLIDO:"+c.getApellido());
        }
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni de lea persona a borrar");
        Long dniBorrado = teclado.nextLong();
        boolean bandera;
        bandera = false;
        for (Cliente c : listaClientes){
            if (c.getDni().equals(dniBorrado)){
                listaClientes.remove(c);
                bandera = true;
                break;
            }
        }
        if (bandera){
            System.out.println("Cliente borrado correctamente");
        }
        else {
            System.out.println("No se encontro el cliente a borrar");
        }
        bandera = false;
        System.out.println("Ingrese el dni de lea persona a buscar");
        Long dniBuscar = teclado.nextLong();
        for (Cliente c : listaClientes){
            if (c.getDni().equals(dniBuscar)){
                System.out.println("DNI:"+c.getDni());
                System.out.println("NOMBRE:"+c.getNombre());
                System.out.println("APELLIDO:"+c.getApellido());
                bandera = true;
                break;
            }
        }
        if (!bandera){
            System.out.println("Cliente no encontrado");
        }
    }
}
