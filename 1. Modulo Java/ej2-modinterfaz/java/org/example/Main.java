package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Persona medico = new Persona();

        Persona paciente = new Persona("erik",11,"25555555");
        Persona paciente2 = new Persona("erik",11,"25555555", 80, 1.80f);
        Persona paciente3 = new Persona("erik",11,"25555555", 80, 1.80f);

        List<Persona> pacientes = new ArrayList<>();
        pacientes.add(paciente);
        pacientes.add(paciente2);
        pacientes.add(paciente3);
        int imc = paciente.cacularIMC();
        System.out.println("el paciente tiene un IMC de: ");
        switch(imc){
            case -1:
                System.out.println("NIVEL DE PESO BAJO");
                break;
            case 0:
                System.out.println("SOBREPESO");
                break;
            case 1:
                System.out.println("PESO NORMAL");
                break;
        }


        if (paciente3.esMayorDeEdad()){
            System.out.println("Es mayor de edad");
        }else {
            System.out.println("Es menor de edad");
        }

        for(Persona actual : pacientes){
            System.out.println(actual.toString());
        }


        //Ejercicio 2
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();

        try
        {
            practicaExcepciones.calcularCociente();
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }


    }
}