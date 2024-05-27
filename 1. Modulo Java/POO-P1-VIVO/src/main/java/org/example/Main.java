package org.example;

public class Main {
    public static void main(String[] args) {
       Persona personaSinParamtros = new Persona();
       Persona personaConNombreEdadDni = new Persona("Pancho",26,"XXXX0000");
       Persona personaConAtributosCompletos = new Persona("Luz",27,"XXXX11111",80D,1.60);

        System.out.println(personaConAtributosCompletos.esMayorDeEdad());

        int IMC = personaConAtributosCompletos.calcularIMC();
        switch (IMC){
            case -2:
                System.out.println("Sin datos");
                break;
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso normal");
                break;
            case 1:
                System.out.println("Sobrepeso");
        }
        System.out.println(personaConAtributosCompletos.toString());
    }
}
