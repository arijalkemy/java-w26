package org.example;

import org.example.clases.GuardaRopa;
import org.example.clases.Prenda;

import java.util.ArrayList;
import java.util.HashMap;
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
        Scanner scan = new Scanner(System.in);
        GuardaRopa guardaRopaCba = new GuardaRopa("Cordoba",2, new HashMap<Integer, List<Prenda>>());
        int opcion=0;
        //carga de listas
        List<Prenda> lista1 = new ArrayList<>();
        lista1.add(new Prenda("Camiseta", "Nike", "Modelo1"));
        lista1.add(new Prenda("Pantalón", "Adidas", "Modelo2"));
        lista1.add(new Prenda("Zapatos", "Puma", "Modelo3"));
        lista1.add(new Prenda("Gorra", "New Era", "Modelo4"));
        lista1.add(new Prenda("Chaqueta", "The North Face", "Modelo5"));
        lista1.add(new Prenda("Bufanda", "Gucci", "Modelo6"));

        // Lista 2
        List<Prenda> lista2 = new ArrayList<>();
        lista2.add(new Prenda("Falda", "Zara", "Modelo1"));
        lista2.add(new Prenda("Camisa", "H&M", "Modelo2"));
        lista2.add(new Prenda("Botas", "Dr. Martens", "Modelo3"));
        lista2.add(new Prenda("Sudadera", "Under Armour", "Modelo4"));
        lista2.add(new Prenda("Bufanda", "Burberry", "Modelo5"));
        lista2.add(new Prenda("Gafas de sol", "Ray-Ban", "Modelo6"));

        // Lista 3
        List<Prenda> lista3 = new ArrayList<>();
        lista3.add(new Prenda("Vestido", "Mango", "Modelo1"));
        lista3.add(new Prenda("Pantalón corto", "Pull&Bear", "Modelo2"));
        lista3.add(new Prenda("Zapatillas", "Converse", "Modelo3"));
        lista3.add(new Prenda("Cazadora", "Levi's", "Modelo4"));
        lista3.add(new Prenda("Sombrero", "Guess", "Modelo5"));
        lista3.add(new Prenda("Guantes", "Dolce&Gabbana", "Modelo6"));
        do{
            opcion = mostrarMenu();
            switch (opcion){
                case 1:
                    System.out.println("Elija entre las listas 1 2 o 3 (un mal tipeo cargara la lista 3)");
                    int lista = scan.nextInt();
                    if(lista==1){
                        guardaRopaCba.guardarPrendas(lista1);
                    } else if (lista == 2) {
                        guardaRopaCba.guardarPrendas(lista2);
                    }else
                        guardaRopaCba.guardarPrendas(lista3);
                    break;
                case 2:
                    guardaRopaCba.mostrarPrendas();
                    break;
                case 3:
                    System.out.println("Ingrese el numero de identificacion para regresar las prendas");
                    int key= scan.nextInt();
                    guardaRopaCba.devolverPrendas(key);
                    break;
                default:
            }
        }while(opcion!=4);
    }
    public static int mostrarMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("********* SAVE THE ROPA CBA ********* ");
        System.out.println("1) Guardar ropa");
        System.out.println("2) Mostrar Ropa ");
        System.out.println("3) Devolver Ropa");
        System.out.println("4) Salir");
        System.out.println("Elija una opcion: ");
        return scan.nextInt();
    }
}
