package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Repositorio repositorio = new Repositorio();
        RepositorioCliente repositorioCliente=new RepositorioCliente();
        int eleccion=0;
        do{
            eleccion = mostrarMenu();
            switch(eleccion){
                case 1:
                    agregarLocalizador(repositorio,repositorioCliente);
                    break;
                case 2:
                    mostrarRepositorio(repositorio);
                    break;
                case 3:

                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }while(eleccion != 3);

    }

    public static int mostrarMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1)Generar Localizador.\n2)Mostrar Repositorio.\n3)Salir.\nElige una Opcion:");
        return sc.nextInt();
    }
    public static void agregarLocalizador(Repositorio repositorio, RepositorioCliente repositorioCliente){
        Scanner scn = new Scanner(System.in);
        System.out.printf("Ingrese el Nombre: ");
        String nombre = scn.nextLine();
        System.out.println("Ingrese el Apellido: ");
        String apellido = scn.nextLine();
        Cliente c=new Cliente(nombre,apellido);
        if(repositorioCliente.existeCliente(c)){
            System.out.println("El Cliente ya existe agregaremos el localizador");
        }else{
            agregarCDesdeL(repositorioCliente,nombre,apellido);
        }
        System.out.println("Ingrese el total: ");
        double total = scn.nextDouble();
        System.out.printf("Ingrese el Identificador: ");
        int identificador = scn.nextInt();
        System.out.printf("Numero de reservas en este localizador:");
        int reservar = scn.nextInt();
        List<String> reservas = new ArrayList<>();
        for(int i=1; i<=reservar; i++){
            System.out.println("Ingrese el tipo de reserva(Hotel, Comida, Boleto o Transporte:");
            String tipo = scn.next();
            reservas.add(tipo);
        }
        total=asignarDescuento(total,repositorio,reservas,nombre,apellido);//descuento aqui
        Localizador localizadorNuevo = new Localizador(c,identificador,total,reservas);
        repositorio.agregarLocalizador(localizadorNuevo);
        System.out.println("Localizador Agregado");
        mostrarRepositorio(repositorio);

    }
    public static void agregarCliente(RepositorioCliente repositorioC){
        Scanner scn = new Scanner(System.in);
        System.out.printf("Ingrese el Nombre: ");
        String nombre = scn.nextLine();
        System.out.println("Ingrese el Apellido: ");
        String apellido = scn.nextLine();
        Cliente cliente=new Cliente(nombre,apellido);
        repositorioC.agregarCliente(cliente);
        System.out.println("Cliente Agregado");
    }

    public static void agregarCDesdeL(RepositorioCliente repositorioC,String nombre, String apellido){
        Cliente cliente=new Cliente(nombre,apellido);
        repositorioC.agregarCliente(cliente);
        System.out.println("Cliente Agregado automaticamente al crear el localizador.");
    }

    public static void mostrarRepositorio(Repositorio repositorio){
        System.out.println(repositorio.getLocalizadores().size());
        List<Localizador> localizadors= repositorio.getLocalizadores();
        for(Localizador localizador: localizadors ){
            System.out.println(localizador.toString());
        }
    }
    public static double asignarDescuento(double total, Repositorio repositorio, List<String> reservas,String nombre, String apellido){
        int d1=descuentoTipo3(reservas);
        double descuento=0;
        switch(d1){
            case 1:
                System.out.println("Aplica descuento tipo 3 de 5%.");
                descuento=descuento+(total*0.05);
                break;
            case 2:
                System.out.println("Aplica descuento tipo 3 de 5%.");
                descuento=descuento+(total*0.05);
                break;
            case 3:
                System.out.println("Aplica descuento tipo 3 de 10%.");
                descuento=descuento+(total*0.1);
                break;
            default:

        }

        if(descuentoTipo2(reservas)){
            System.out.println("Aplica descuento tipo 2 de 10%.");
            descuento=descuento+(total*0.1);
        }

        if(descuentoTipo1(repositorio,nombre,apellido)){
            System.out.println("Aplica descuento tipo 1 e 5%.");
            descuento=descuento+(total*0.05);
        }
        return total-descuento;

    }
    public static int descuentoTipo3(List<String> reservas){
        int contadorS=0;
        int contadorB=0;
        for (String reserva: reservas){
            if(reserva.equals("Hotel")) {
                contadorS++;
            }
        }
        for (String reserva: reservas){
            if(reserva.equals("Boleto")) {
                contadorB++;
            }
        }

        if (contadorB>=2&&contadorS>=2){
            return 3;
        }else if (contadorS>=2){
            return 2;
        }else if (contadorB>=2){
            return 1;
        }else{
            return 4;
        }

    }
    public static boolean descuentoTipo2(List<String> reservas){
        int[] contador ={0,0,0,0};
        for (String str: reservas){
            if(str.equals("Hotel")) {
                contador[0]++;
            }
            if(str.equals("Comida")) {
                contador[1]++;
            }
            if(str.equals("Boleto")) {
                contador[2]++;
            }
            if(str.equals("Transporte")) {
                contador[3]++;
            }
        }
        return contador[0] >= 1 && contador[1] >= 1 && contador[2] >= 1 && contador[3] >= 1;
    }
    public static boolean descuentoTipo1(Repositorio repositorio,String nombre,String apellido){
        int contador=0;
        for(Localizador localizador:repositorio.getLocalizadores()){
            if(localizador.getCliente().getNombre().equals(nombre) &&
                    localizador.getCliente().getApellido().equals(apellido)) {
                contador++;
            }
        }
        return contador >= 2;
    }
}
