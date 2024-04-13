package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        // Entry Scanner
        Scanner scn = new Scanner(System.in);

        // Ejecución del menú
        boolean boolMenu = true;

        // Opción del menú
        int opMenu = 0;

        // Opción para buscar una prenda en el locker
        int searchClothesNum = 0;

        // Creación de lista de prendas y objeto para guardarlas
        SaveClothes save = new SaveClothes();

        while (boolMenu) {
            System.out.println("Bienvenido al sistema de almacenamiento de ropa");
            System.out.println("1. Guardar prendas" + "\n" + 
                               "2. Consultar prendas" + "\n" + 
                               "3. Mostrar todas las prendas" + "\n" + 
                               "4. Salir");
            System.out.print(">_ ");
            
            // Lectura de opción de menú
            opMenu = scn.nextInt();
            scn.nextLine();



            switch (opMenu) {
                case 1:

                    // Opción de confirmación
                    int clothOp = 0;

                    while (boolMenu) {
                        PieceOfCloth cloth = new PieceOfCloth();
                        List<PieceOfCloth> clothes = new ArrayList<>();

                        System.out.println("------ Guardado de prendas -------");
                        
                        System.out.print("Marca: ");
                        cloth.setBrand(scn.nextLine());
                        System.out.println();

                        System.out.print("Modelo: ");
                        cloth.setModel(scn.nextLine());
                        System.out.println();

                        clothes.add(cloth);
                        clothes.toString();

                        System.out.println("¿Quires guardar otra prenda?");
                        System.out.println("1. Sí" + "\n" + "2. No");
                        System.out.print(">_ ");

                        clothOp = scn.nextInt();
                        scn.nextLine();
                        if (clothOp == 1) {
                            boolMenu = true;
                        } else if (clothOp == 2){
                            System.out.println("Guardando prendas....");
                            save.saveClothes(clothes);
                            boolMenu = false;
                        }
                    }
                boolMenu = true;
                break;

                case 2:
                    System.out.println("------ Consulta de Locker-------");

                    System.out.print("Digita el número de Locker: ");
                    searchClothesNum = scn.nextInt();
                    scn.nextLine();

                    List<PieceOfCloth> auxList = save.returnClothes(searchClothesNum);
                    System.out.println(save.getClothes(auxList));
                break;

                case 3:
                    save.showClothes();
                break;

                case 4:
                boolMenu = false;
                break;
                default:
                System.out.println("Opción Incorrecta");
                boolMenu = false;
                break;
            }                
            
        }

    scn.close(); 
    }
}
