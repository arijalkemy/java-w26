package org.example;
public class App {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("pedro", 22, "dsdsdsdsd");
        Persona persona3 = new Persona("lusi", 15, "dsdsdsdsd", 1.75, 80);



        System.out.println(persona3.toString());

        boolean esMayorDeEdad = persona2.esMayorDeEdad();
        int imcCalcu = persona3.cacularIMC();
        switch (imcCalcu) {
            case -1:System.out.println("Bajo peso");
                break;
            case 0:System.out.println("Peso saludable");
                break;
            case 1:System.out.println("Sobrepeso");
                break;
        }

        if(esMayorDeEdad) {
            System.out.println("La persona " + persona2.getNombre() + " es mayor de edad");
        }else {
            System.out.println("La persona " + persona2.getNombre() + " no es mayor de edad");
        }
    }
}