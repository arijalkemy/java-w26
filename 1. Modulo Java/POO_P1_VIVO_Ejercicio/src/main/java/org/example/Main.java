package org.example;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Eduardo",25,"112345");
        Persona persona3 = new Persona("Joaquin",21,"453634",55.5,1.60);

        switch(persona3.calcularIMC()){
            case -1:
                System.out.println("En bajo de peso");
                break;
            case 0:
                System.out.println("En peso saludable");
                break;
            case 1:
                System.out.println("En sobrepeso");
                break;
        }

        if(persona3.esMayorDeEdad()){
            System.out.println("En mayor de edad");
        }
        else{
            System.out.println("En menor de edad");
        }

        System.out.println(persona3.toString());
    }
}