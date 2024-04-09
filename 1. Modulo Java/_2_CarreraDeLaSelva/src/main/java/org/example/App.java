package org.example;

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
        Categoria categoria1 = new Categoria(0, "circuito chico", "2 km por selva y arroyos");
        Categoria categoria2 = new Categoria(1, "circuito medio", "5 km por selva, arroyos y barro");
        Categoria categoria3 = new Categoria(2, "circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        List<Categoria> categorias = new ArrayList<Categoria>();
        categorias.add(categoria1);
        categorias.add(categoria2);
        categorias.add(categoria3);

        Participante participante = new Participante(0, 2022020, 23, 349222222, 349222223, "Marcos", "Bellotti", "A+");

        Inscripcion inscripcion = new Inscripcion(0, categorias.get(0), participante);
        List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
        inscripciones.add(inscripcion);


        System.out.println("El monto a abonar es: " + inscripcion.Monto);


        //desinscribir a un participante
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el nro de inscripcion a borrar: ");
        int nroInscripcion = teclado.nextInt();

        for (int i=0; i < inscripciones.size() ; i++){
            if(inscripciones.get(i).NroInscripcion == nroInscripcion) {
                inscripciones.remove(i);
                System.out.println("Se borro con exito la inscripcion nro " + i);
                break;
            }
        }

        //calcular el total de categoria
        double totalCategoria1 = 0;
        double totalCategoria2 = 0;
        double totalCategoria3 = 0;
        double totalDeLaCarrera = 0;

        for (int i=0; i < inscripciones.size() ; i++){
            switch (inscripciones.get(i).Categoria.Nombre){
                case "circuito chico":
                    totalCategoria1 += inscripciones.get(i).Monto;
                    break;
                case "circuito medio":
                    totalCategoria2 += inscripciones.get(i).Monto;
                    break;
                case "circuito avanzado":
                    totalCategoria3 += inscripciones.get(i).Monto;
                    break;
            }
            totalDeLaCarrera += inscripciones.get(i).Monto;
        }
        System.out.println("El total de la categoria 1 es: " + totalCategoria1);
        System.out.println("El total de la categoria 2 es: " + totalCategoria2);
        System.out.println("El total de la categoria 3 es: " + totalCategoria3);

        System.out.println("El total de la carrera es: " + totalDeLaCarrera);
    }

}
