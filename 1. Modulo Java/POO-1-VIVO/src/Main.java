//EJERCICIO 3
public class Main {
    public static void main(String[] args) {

        //EJERCICIO 4
        Persona persona1 = new Persona();

        Persona persona2 = new Persona("Rodrigo",27,"39090994");

        Persona persona3 = new Persona("Leonardo",18,"30988449", 65, 1.70);

        //Persona persona4 = new Persona("Leonardo",28);

        //EJERCICIO 6

        int valorIMC = persona3.calcularIMC();
        if(valorIMC == -1){
            System.out.println("La persona tiene un peso bajo");
        }else{
            if (valorIMC == 0){
                System.out.println("La persona tiene un peso saludable");
            }
            else {
                System.out.println("La persona tiene sobrepeso");
            }
        }

        System.out.println((persona3.esMayorDeEdad())?"Es mayor de edad":"Es menor de edad");

        System.out.println(persona3.toString());




    }
}