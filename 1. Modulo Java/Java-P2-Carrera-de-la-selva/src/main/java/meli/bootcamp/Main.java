package meli.bootcamp;

import java.util.*;

public class Main {
    public static void main(String[] args){

        //Cantidad de usuarios
        int N = 20;

        //Número aleatorio
        Random random = new Random();

        // Estructura list carreras: [i][0] = km | [i][1] costo menores [i][2] |costo mayores | costo total
        List<int[]> listaCarreras = new ArrayList<int[]>();

        listaCarreras.add(new int[]{2, 1300, 1500, 0});
        listaCarreras.add(new int[]{5, 2000, 2300, 0});
        listaCarreras.add(new int[]{10, -1, 2800, 0});

        //Estructura list usuarios [i][0] = id | [i][1] = edad
        List<int[]> listaUsuarios = new ArrayList<int[]>();


        //Llenamos listausuarios aleatoriamente
        for(int i = 0; i < N; i++){
            listaUsuarios.add(new int[]{i, random.nextInt(86) + 15});
        }


        //Creamos hash vinculante entre usuario id y carrera
        HashMap<Integer, int[]> idCarreraMerge = new HashMap<Integer, int[]>();

        //Llenado de hash
        for(int[] atributos:listaUsuarios){
            idCarreraMerge.put(atributos[0], listaCarreras.get(random.nextInt(3)));
        }

        //Imprimimos

        for(int[] atributos:listaUsuarios){
            int id = atributos[0];
            int edad = atributos[1];

            System.out.println("Participante: " + atributos[0] + " Edad: " + atributos[1]);

            //Validamos
            if(idCarreraMerge.get(id) == null){
                System.out.println("Participante no registrado");
            }else{
                System.out.println("Participante registrado con cobro de: " + getCosto(id, idCarreraMerge.get(id)));
            }
        }

        //Borramos un participante de prueba
        idCarreraMerge.remove(0);

        //corroboramos
        System.out.println("-----------------");


        for(int[] atributos:listaUsuarios){
            int id = atributos[0];
            int edad = atributos[1];

            System.out.println("Participante: " + atributos[0] + " Edad: " + atributos[1]);

            //Validamos
            if(idCarreraMerge.get(id) == null){
                System.out.println("Participante no registrado");
            }else{
                System.out.println("Participante registrado con cobro de: " + getCosto(id, idCarreraMerge.get(id)));
            }
        }
        //Sacamos costos totales
        for(Map.Entry<Integer, int[]> entrada : idCarreraMerge.entrySet()){
            if(entrada.getValue()[0] == 2){
                entrada.getValue()[3] += getCosto(entrada.getKey(), entrada.getValue());
            }

            if(entrada.getValue()[0] == 5){
                entrada.getValue()[3] += getCosto(entrada.getKey(), entrada.getValue());
            }

            if(entrada.getValue()[0] == 10){
                entrada.getValue()[3] += getCosto(entrada.getKey(), entrada.getValue());
            }
        }
        System.out.println("--------------------");

        //Impresion de costos
        System.out.println("Carrera 2K costos totales: " +listaCarreras.get(0)[3]);
        System.out.println("Carrera 5K costos totales: " + listaCarreras.get(1)[3]);
        System.out.println("Carrera 10K costos totales: " + listaCarreras.get(2)[3]);
    }


    public static int getCosto(int edad, int[] carrera){
        int res;
        if (edad <= 18){
            res = carrera[2];
        }
        else {
            res = carrera[1];
        }
        return res;
    }

}