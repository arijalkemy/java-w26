package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        //Parte 1
        Cliente cliente1 = new Cliente(135223, "Rogelio", "Gonzalez");
        Cliente cliente2 = new Cliente(345212, "Mariano", "Coto");
        Cliente cliente3 = new Cliente(135043, "Ricardo", "Nini");

        ArrayList<Cliente> listCliente = new ArrayList<Cliente>();

        listCliente.add(cliente1);
        listCliente.add(cliente2);
        listCliente.add(cliente3);
        Scanner scanner = new Scanner(System.in);
        /* PARTE I

        for (Cliente element : listCliente) {
            System.out.println(element);
        }
        System.out.print("Ingrese el DNI del cliente a borrar: ");
        int dniBorrar= scanner.nextInt();
        int index=0;
        for (Cliente element : listCliente) {
            if (element.getDni() == dniBorrar) {
                listCliente.remove(index);
                break;
            }
            index++;
        }

        for (Cliente element : listCliente) {
            System.out.println(element);
        }
        System.out.println("Busqueda de cliente en nuestra base de datos");
        System.out.print("Ingrese el numero del dni del Cliente: ");
        int dniIngresado = scanner.nextInt();

            for (Cliente element : listCliente) {

                if (element.getDni()==dniIngresado) {
                    System.out.println("DNI: " + element.getDni()
                    + ", Nombre: " + element.getNombre()
                    + ", Apellido: " + element.getApellido());
                }else{
                    System.out.println("El cliente ingresado no se encuentra en la base de datos");
                }
        }*/

        //Parte 2
        ArrayList <Producto> productoList = new ArrayList<>();
        productoList.add(new Producto(123, "deshodorante", 2, 3.41));
        productoList.add(new Producto(124, "pan", 4, 2.45));
        productoList.add(new Producto(125, "carne vacio", 1, 10.3));
        productoList.add(new Producto(126, "fideos don vicente", 2, 43.23));

        System.out.print("Ingrese el numero de DNI del cliente: ");
        int dni = scanner.nextInt();
        boolean ok=false;
        int index=0;
        for (Cliente cliente : listCliente) {//Si el cliente existe en la BD, genero la factura al cliente existente
            if (cliente.getDni() == dni) {
                ok=true;
                break;
            }
            index++;
        }
        if (!ok) {//Sino esta en la BD, se crea
            listCliente.add(new Cliente(dni, "Esteban", "Martinez"));
            index=listCliente.size()-1;
        }

        Factura factura = new Factura(4532, "23/04/1945", listCliente.get(index), productoList);
        System.out.println(factura);


    }

}
