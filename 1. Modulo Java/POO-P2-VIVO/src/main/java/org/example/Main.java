package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Ejercicio 1.
        int a = 0;
        int b = 300;

        try{
            int resultado = b/a;
        }
        catch (Exception e){
            System.out.println("Se a producido un error");
            //throw  new IllegalArgumentException("No se puede dividir por cero"); //Comentada para continuar con el programa
        }
        finally {
            System.out.println("Programa finalizado");
        }
        //Ejercicio 2.
        //Por comodidad, Main será la clase distribuidora

        List<Producto> distribuira = new ArrayList<>();

        distribuira.add(new Perecedero("Arroz",50));
        distribuira.add(new Perecedero("Frijol",150));
        distribuira.add(new NoPerecedero("Playera azul",100));
        distribuira.add(new NoPerecedero("Resistol 500",23.12));
        distribuira.add(new NoPerecedero("Palatzo",100000));

        for (Producto producto: distribuira) {
             boolean isPerecedero = producto instanceof Perecedero ?  true : false;
             if(isPerecedero){
                 System.out.println(((Perecedero) producto).calcular(5,3));
             }
             else {
                 System.out.println(producto.calcular(5));
             }


        }




    }
}
