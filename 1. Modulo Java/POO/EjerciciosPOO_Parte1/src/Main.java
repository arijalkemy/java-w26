import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //-----INICIO Ejercicio práctico----- Automovil
        Automovil cocheTest = new Automovil("Nissa", "Azul", 11);
        System.out.println(cocheTest.mostrarMarcaYColor()); //Prueba de instancia correcta.
        //-----FIN prueba - Automovil-----

        //-----INICIO Clase en VIVO Ejercicio 1-------
        Persona personaSinArgumentos = new Persona(); //Persona sin argumentos
        Persona personaParcial = new Persona("Yair", 27, "VAGY9608");//Argumentos parciales
        Persona personaTotal = new Persona("Leon", 56, "JOHN1213", 80, 1.55); //Todos los atributos
    if(personaSinArgumentos.esMayorDeEdad()){
        System.out.println("Es mayor de edad");
    }
    if(personaParcial.esMayorDeEdad()){
        System.out.println(personaParcial.getNombre()+" Es mayor de edad");
    }
        int IMC = personaTotal.calcularIMC();
    switch (IMC){
        case -1:
            System.out.println("Peso Bajo");
            break;
        case 0:
            System.out.println("Peso correcto");
            break;
        case 1:
            System.out.println("Sobrepeso");
            break;
        default:
            System.out.println("Imposible calcular IMC");
    }

    //Ejercicio práctico parte 2
        //Mensaje final
        String mensajeFinal = "Este es el último mensaje";

//Código que arroja excepción
        int[] numeros = new int[5];
        try{numeros[5] = 10;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println(mensajeFinal);
        }

//------ Ejercicio 1 -----
            PracticaExcepciones test = new PracticaExcepciones();
            System.out.println(test.cociente()); //Punto 1
            //System.out.println(test.cocienteIllegal()); //Punto 2, comentado para evitar errores

//----- Ejercicio 2 -----

            //Creamos nuestros productos.
            Perecederos producto1 = new Perecederos("Leche",25,7);
            Perecederos producto2 = new Perecederos("Pan",50,2);
            Perecederos producto3 = new Perecederos("Huevo",70,1);
            NoPerecederos producto4 = new NoPerecederos("Papel higienico",50,"Desechable");
            NoPerecederos producto5 = new NoPerecederos("Fabuloso",15,"Limpiador");
            Distribuidora distribuidora = new Distribuidora(new ArrayList<>());
            ArrayList<Productos> lista= distribuidora.listaProductos;
            lista.add(producto1);
            lista.add(producto2);
            lista.add(producto3);
            lista.add(producto4);
            lista.add(producto5);
//Cantidad de productos (Al azar para hacerlo más divertido)
            Random rand = new Random();
            for (Productos producto : lista) {
                int numeroAleatorio = rand.nextInt(50);
                System.out.println("Producto: "+producto.getNombre()+" Cantidad: "+numeroAleatorio+" Precio Unitario: "+ producto.getPrecio()+" Total a pagar: "+producto.calcular(numeroAleatorio));
            }


    }
}
