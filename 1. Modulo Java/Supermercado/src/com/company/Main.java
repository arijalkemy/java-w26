package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado();

        boolean on = true;
        while(on){
            System.out.println("Elija una opción:");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Registrar Compra");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Buscar Cliente");
            System.out.println("5. Salir");
            Scanner sc = new Scanner(System.in);
            int option;
            try{
                option = sc.nextInt();
            } catch (InputMismatchException e){
                option = 0;
            }
            switch(option){
                case 1:
                    System.out.println("Ingrese DNI del Cliente");
                    String dni = sc.nextLine();
                    Cliente placeHolder = supermercado.buscarClientePorDNI(dni);

                    if(placeHolder != null){
                        break;
                    }

                    printCreacionCliente(dni, supermercado, sc);

                    break;
                case 2:
                    List<Item> items = new ArrayList<Item>();

                    System.out.println("Ingrese DNI del Cliente");
                    dni = sc.nextLine();
                    Cliente cliente = supermercado.buscarClientePorDNI(dni);
                    if(cliente == null){
                        cliente = printCreacionCliente(dni, supermercado, sc);
                    }

                    boolean checkout = false;
                    while(!checkout){
                        System.out.println("1. Registrar item");
                        System.out.println("2. Mostrar items");
                        System.out.println("3. Checkout");
                        int opt;
                        try{
                            opt = sc.nextInt();
                        } catch (InputMismatchException e){
                            opt = 0;
                        }
                        switch (opt) {
                            case 1:
                                try{
                                    //Next sólo lee un token, es decir UNA PALABRA.
                                    System.out.println("Ingrese codigo de item");
                                    String codigo = sc.next();
                                    System.out.println("Ingrese nombre");
                                    String nombre = sc.nextLine();
                                    System.out.println("Ingrese cantidad comprada");
                                    int cantidad = sc.nextInt();
                                    System.out.println("Ingrese precio unitario");
                                    double precio = sc.nextDouble();
                                    items.add(new Item(codigo, nombre, cantidad, precio));
                                } catch (InputMismatchException e){
                                    System.out.println("Rehaga el registro de ítem. Ingrese un valor válido");
                                } finally {
                                    break;
                                }
                            case 2:
                                System.out.println(items);
                                break;
                            case 3:
                                supermercado.registrarCompra(cliente, items);
                                checkout = true;
                                break;
                            default:
                                System.out.println("Opción no valida");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Ingrese dni del Cliente");
                    dni = sc.nextLine();
                    Cliente aEliminar = supermercado.buscarClientePorDNI(dni);
                    if(aEliminar == null){
                        break;
                    }
                    supermercado.eliminarCliente(aEliminar);
                    break;
                case 4:
                    System.out.println("Ingrese dni del Cliente");
                    dni = sc.nextLine();
                    Cliente buscado = supermercado.buscarClientePorDNI(dni);
                    break;
                case 5:
                    on = false;
                    break;
                default:
                    System.out.println("Opción no valida");
            }
        }
    }

    private static Cliente printCreacionCliente(String dni, Supermercado supermercado, Scanner sc) {
        System.out.println("Ingrese nombre del Cliente");
        String nombre = sc.nextLine();
        System.out.println("Ingrese apellido del Cliente");
        String apellido = sc.nextLine();
        return supermercado.registrarCliente(new Cliente(dni, nombre, apellido));
    }
}
