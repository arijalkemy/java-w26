package org.example;

public class Main {

    public static void main(String[] args) {
        Persona personaConstructorVacio = new Persona();
        Persona personaConstructorMedio = new Persona("Jose",33, "3577323");
        Persona personaConstructorCompleto = new Persona("Roberto", 56, "14023043", 89.2, 1.77);

        /* No existe una sobrecarga del constructor con esos parametros */
        //Persona personaConConstructorErroneo = new Persona("Maria", 33);

        System.out.println(personaConstructorCompleto.toString());
        if(personaConstructorCompleto.esMayorDeEdad())
            System.out.print("Es mayor de edad y ");
        else
            System.out.print("Es menor de edad y ");

        switch (personaConstructorCompleto.calcularIMC()) {
            case -1:
                System.out.println("tiene bajo peso");
                break;
            case 0:
                System.out.println("su peso es saludable");
                break;
            case 1:
                System.out.println("tiene sobrepeso");
                break;
        }




    }
}
