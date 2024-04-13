public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Marcos", 24, "42052682");
        Persona persona3 = new Persona("Ignacio", 17, "58473242", 76.2, 1.8);

        //Persona persona4 = new Persona("Bautista", 1);
        //Esto no es posible ya que no establecimos un constructor que acepte solamente estos dos parametros.

        //Mostramos informacion sobre la persona
        System.out.println(persona3.toString());

        //Mostramos informacion sobre su IMC
        switch (persona3.calcularIMC()) {
            case -1: System.out.println("\nBajo peso\n"); break;
            case 0: System.out.println("\nPeso saludable\n"); break;
            case 1: System.out.println("\nSobrepeso\n"); break;
        }

        //Mostramos si es mayor de edad o no
        if (persona3.esMayorDeEdad()) {
            System.out.println(persona3.getNombre() + " es mayor de edad.");
        }
        else {
            System.out.println(persona3.getNombre() + " no es mayor de edad.");
        }
    }
}
