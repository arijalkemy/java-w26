package org.example;

import java.util.Scanner;

public class Menu {

    public static int mostrarMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("-------- 10/04 Ejercicios tarde --------");
        System.out.println("1) 1er ejercicio");
        System.out.println("2) 2do ejercicio");
        System.out.println("3) Salir del programa");
        return scan.nextInt();
    }

    public static void ejercicioUno() {
        Scanner scan = new Scanner(System.in);
        System.out.println("ingrese el numero a dividir");
        int a = scan.nextInt();
        System.out.println("ingrese el numero por el cual quiere dividir");
        int b = scan.nextInt();
        double resultado = PracticaExcepciones.Division(a, b);
        System.out.println("Resultado de la división :" + resultado);
    }

    public static void ejercicioDos() {
        Producto productos[] = {new Perecedero("Tomate", 1500, 2), new Perecedero("lechuga", 3000, 1), new Perecedero("milanesa", 5000, 3), new NoPerecedero("mouse",20000, "tecnologia"), new NoPerecedero("Monitor",40000, "tecnologia")};
        for(int j=0;j<productos.length;j++){
            productos[j].calcular(5);
        }
    }
}
