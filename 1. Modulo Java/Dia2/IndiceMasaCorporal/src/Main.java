public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Nacho", 22, "12345678");
        Persona persona3 = new Persona("Martin", 24, "98765432", 1.80, 39.3);

        //Persona persona4 = new Persona("Esteban");
        //No funciona con solo un parámetro porque no hay un constructor definido en la clase Persona
        //que reciba esa cantidad de parametros de instancia

        if (persona3.esMayorDeEdad()) {
            System.out.println(persona3.getNombre() + " es mayor de edad");
        } else {
            System.out.println(persona3.getNombre() + " no es mayor de edad");
        }

        if (persona3.calcularIMC() == -1) {
            System.out.println("El peso de " + persona3.getNombre() + " es demasiado bajo");
        } else if (persona3.calcularIMC() == 0) {
            System.out.println("El peso de " + persona3.getNombre() + " es saludable");
        } else if (persona3.calcularIMC() == 1) {
            System.out.println("El peso de " + persona3.getNombre() + " es demasiado alto");
        } else {
            System.out.println("Error al calcular IMC de " + persona3.getNombre());
        }
    }
}