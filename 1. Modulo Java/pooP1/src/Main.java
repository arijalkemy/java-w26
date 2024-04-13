import ejerciciopoo.Persona;

import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

   static Map<Integer, String> mapaIMC = Map.of(-1,"Bajo peso",
            0,"Peso saludable",
            1, "Sobrepeso");

    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Monica", 32, "10538456");
        Persona persona3 = new Persona("Maria", 25, "1045678", 56.2, 1.65);

       Integer masaCorporal =  persona3.calcularIMC();
       String esMayor = persona3.esMayorDeEdad();
        System.out.println("su indice de masa corporal es: " + mapaIMC.get(masaCorporal) + " , su edad es " + persona3.getEdad() + " Y " + esMayor );
    }


}